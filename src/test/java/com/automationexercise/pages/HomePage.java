package com.automationexercise.pages;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.automationexercise.utils.ConfigReader;
import static com.automationexercise.utils.Utils.*;

public class HomePage extends BasePage{
	
	protected static List<List<WebElement>> listOfButtons;
	protected WebDriverWait wait;
	protected String xpath;
	protected BasePage basePage;
	protected String itemName;
	protected static String nameOfCategory;
	protected static String nameOfSubcategory;
	protected static String nameOfBrand;
	protected static String[] addedItemAtributes = {"//img","//p","//h2"};
	protected static String[] replacedAtributes = {"item","description","price"};
	protected static LinkedHashMap<String, String> addedItem;
	protected static List<LinkedHashMap<String, String>> allAddedItems = new LinkedList<>();
	private int number;
	
	@FindBy (xpath = "//div[@class='panel-heading']")
	protected static List<WebElement> categoryFilterList;
	
	@FindBy (xpath = "")
	protected static List<WebElement> subcategoryFilterList;

	@FindBy (xpath = "//div[contains(@class,'brands_products')]//li")
	protected static List<WebElement> brandsFilterList;

	@FindBy (xpath = "//div[contains(@class,'features_items')]")
	protected WebElement allProducts;
	
	@FindBy (xpath = "//div[contains(@class,'productinfo')]")
	protected List<WebElement> productsList;
	
	@FindBy (xpath = "//div[contains(@class,'productinfo')]//a")
	protected static List<WebElement> addToCartBtnList;
	
	@FindBy (xpath = "//div[@class='choose']//a[contains(@href,'/product_details/')]")
	protected static List<WebElement> viewProductBtnList;
	
	@FindBy (xpath = "//div[@class='modal-content']")
	protected WebElement AddedToCartMsg;
	
	@FindBy (xpath = "//div[@class='modal-content']//button")
	protected WebElement continueShopingBtn;
	
	@FindBy (xpath = "//div[@class='modal-body']//p//a")
	protected WebElement viewCartBtn;
	
	@FindBy (id = "slider-carousel")
	private WebElement sliderCarousel;

	@FindBy (xpath = "//div[contains(@class,'recommended_items')]")
	private WebElement recomendedItemsCarousel;
	
	@FindBy (xpath = "//div[contains(@id,'recommended')]//div[contains(@class,'col-sm')]//a")
	private List<WebElement> AddToCartRecomendedItemsBtnsList;
	
	public static void setAllAddedItems(List<LinkedHashMap<String, String>> allAddedItems) {
		HomePage.allAddedItems = allAddedItems;
	}
	@FindBy (xpath = "//div[contains(@id,'recommended-item')]//a//i[contains(@class,'fa-angle-right')]")
	private WebElement clickRecommendCarouselRight;
	
	@FindBy (xpath = "//div[contains(@id,'recommended-item')]//a//i[contains(@class,'fa-angle-left')]")
	private WebElement clickRecommendCarouselLeft;

	public HomePage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	public WebElement getSliderCarousel() {
		return sliderCarousel;
	}
	
	public WebElement getViewCartBtn() {
		return viewCartBtn;
	}

	public static List<LinkedHashMap<String, String>> getAllAddedItems() {
		return allAddedItems;
	}

	public static String getNameOfCategory() {
		return nameOfCategory;
	}

	public static String getNameOfSubcategory() {
		return nameOfSubcategory;
	}

	public static String getNameOfBrand() {
		return nameOfBrand;
	}
	
	public static void verifyPageBtns() {
		listOfButtons = new ArrayList<>();
		listOfButtons.add(categoryFilterList);
		listOfButtons.add(brandsFilterList);
		listOfButtons.add(addToCartBtnList);
		listOfButtons.add(viewProductBtnList);
		
		for (int i = 0; i < listOfButtons.size(); i++) {
			for (WebElement webElement : listOfButtons.get(i)) {
			Assert.assertTrue(webElement.getText() + " button is not enabled",webElement.isEnabled());
			}
		}
	}
	
	public static void getItemInfo(String xpath) {
		addedItem = new LinkedHashMap<>();
		int quantity = 1;
		addedItem.put(replacedAtributes[0],driver.findElement(By.xpath(xpath.replace("//a", addedItemAtributes[0]))).getAttribute("src"));  
		for(int i = 1; i < addedItemAtributes.length; i++) {
			addedItem.put(replacedAtributes[i],driver.findElement(By.xpath(xpath.replace("//a", addedItemAtributes[i]))).getText().trim());
		}
		addedItem.put("quantity",String.valueOf(quantity));
		addedItem.put("total","Rs. " + String.valueOf(quantity * Integer.parseInt(addedItem.get("price").replaceAll("[^0-9]+", ""))));
		allAddedItems.add(addedItem);
	}
	
	public static void getItemInfo(LinkedHashMap<String,String> elements) {
		allAddedItems.add(elements);
	}

	@Override
	public void verify() {
		super.verify();
		Assert.assertTrue(sliderCarousel.getTagName() + " is not displayed",sliderCarousel.isDisplayed());
		Assert.assertTrue(recomendedItemsCarousel.getTagName() + " is not displayed",recomendedItemsCarousel.isDisplayed());
		verifyPageBtns();
	}
	
	public void fillOutSubscriptionField() {
		subscribeInput.sendKeys(ConfigReader.getProperty("email"));
	}
	
	public void clickAddToCartRecomendedItem() {
		xpath = "(//div[contains(@class,'active')]//div[contains(@class,'productinfo')]//a)[3]";
		driver.findElement(By.xpath(xpath)).click();
		getItemInfo(xpath);
	}
	
	public void clickRandomAddToCartBtn() {
		number = randomPositiveIntBelow(addToCartBtnList.size());
		xpath = "(//div[contains(@class,'productinfo')]//a)[" + number +"]";
		driver.findElement(By.xpath(xpath)).click();
		getItemInfo(xpath);
	}
	
	public void clickViewProduct(int number) {
		if(number > viewProductBtnList.size())
			number = viewProductBtnList.size();
		if(number < 1)
			number = 1;
		String xpath = "(//div[@class='choose']//a)[" + number +"]";
		driver.findElement(By.xpath(xpath)).click();
	}
	
	public void clickContinueShopBtn() {
		wait = new WebDriverWait(driver,1);
		wait.until(ExpectedConditions.visibilityOf(continueShopingBtn));
		continueShopingBtn.click();
	}

	public void selectRandomCategoryAndSubcategory() {
		number = randomPositiveIntBelow(categoryFilterList.size());
		xpath = "(//div[@class='panel-heading'])[" + number +"]";
		nameOfCategory = driver.findElement(By.xpath(xpath)).getText().trim();
		driver.findElement(By.xpath(xpath+"//span")).click();
		xpath = "//div[@id='"+nameOfCategory.substring(0,1)+nameOfCategory.substring(1).toLowerCase()+"']//li";
		number = driver.findElements(By.xpath(xpath)).size();
		number = randomPositiveIntBelow(number);
		xpath = xpath+"["+number+"]"+"//a";
		nameOfSubcategory = getSubcategoryName(xpath);
		driver.findElement(By.xpath(xpath)).click();
	}
	
	public void selectRandomBrand() {
		number = randomPositiveIntBelow(brandsFilterList.size());
		xpath = "(//div[@class='brands-name']//ul//li)["+number+"]";
		nameOfBrand = driver.findElement(By.xpath(xpath)).getText().trim().substring(4);
		System.out.println("THE BRAND BUTTON TO CLICK IS: " + nameOfBrand);
		driver.findElement(By.xpath(xpath+"//a")).click();
	}
	
	private String getSubcategoryName(String xpath) {
		
		String [] subcategories = {"DRESS","TOPS","TSHIRTS","DRESS","TOPS & SHIRTS","JEANS","SAREE"};
		String nameTemp = driver.findElement(By.xpath(xpath)).getAttribute("href").split("/")[4];
		switch (nameTemp) {
		case "1":
		case "4":
			nameOfSubcategory = subcategories[0];
			break;
		case "2":
			nameOfSubcategory = subcategories[1];
			break;
		case "3":
			nameOfSubcategory = subcategories[2];
			break;
		case "5":
			nameOfSubcategory = subcategories[4];
			break;
		case "6":
			nameOfSubcategory = subcategories[5];
			break;
		case "7":
			nameOfSubcategory = subcategories[6];
			break;	
		default:
			break;
		}
		return nameOfSubcategory;
	}
}

package com.automationexercise.pages;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.automationexercise.utils.ConfigReader;

public class HomePage extends BasePage{
	
	protected List<List<WebElement>> listOfButtons;
	protected WebDriverWait wait;

	@FindBy (xpath = "//div[contains(@class,'category-products')]//div[@class='panel-heading']")
	protected List<WebElement> categoryFilterList;

	@FindBy (xpath = "//div[contains(@class,'brands_products')]//li")
	protected List<WebElement> brandsFilterList;

	@FindBy (xpath = "//div[contains(@class,'features_items')]")
	protected WebElement allProducts;
	
	@FindBy (xpath = "//div[contains(@class,'productinfo')]")
	protected List<WebElement> productsList;
	
	@FindBy (xpath = "//div[contains(@class,'productinfo')]//a")
	protected List<WebElement> addToCartBtnList;
	
	@FindBy (xpath = "//div[@class='choose']//a[contains(@href,'/product_details/')]")
	protected List<WebElement> viewProductBtnList;
	
	@FindBy (xpath = "//div[@class='modal-content']")
	protected WebElement AddedToCartMsg;
	
	@FindBy (xpath = "//div[@class='modal-content']//button")
	protected WebElement continueShopingBtn;
	
	@FindBy (xpath = "//div[@class='modal-body']//p//a")
	protected WebElement viewCartBtn;
	
	@FindBy (id = "slider-carousel")
	private WebElement sliderCarousel;

	@FindBy (xpath = "//div[contains(@class,'recommended_items')]")
	private WebElement recomendedItems;

	public HomePage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	public WebElement getSliderCarousel() {
		return sliderCarousel;
	}
	
	public WebElement getContinueShopingBtn() {
		return continueShopingBtn;
	}
	
	public WebElement getViewCartBtn() {
		return viewCartBtn;
	}

	@Override
	public void verify() {
		super.verify();
		Assert.assertTrue(sliderCarousel.getTagName() + " is not displayed",sliderCarousel.isDisplayed());
		
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
		Assert.assertTrue(recomendedItems.getTagName() + " is not displayed",recomendedItems.isDisplayed());
	}
	
	public void fillOutSubscriptionField() {
		subscribeInput.sendKeys(ConfigReader.getProperty("email"));
	}
	
}

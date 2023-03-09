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

import com.automationexercise.utils.Utils;
import static com.automationexercise.pages.HomePage.getAllAddedItems;

public class ViewCartPage extends BasePage {

	@FindBy (xpath = "//a[contains(@class,'check_out')]")
	private WebElement proceedToCheckoutBtn;
	
	@FindBy (xpath = "//table[contains(@id,'info_table')]//tr[contains(@id,'product-')]")
	private List<WebElement> rowsList;
	
	@FindBy (xpath = "(//table[contains(@id,'info_table')]//tr[contains(@id,'product-')])[1]//td")
	private List<WebElement> colnList;
	
	@FindBy (xpath = "//table[contains(@id,'info_table')]//tr[@class='cart_menu']//td")
	private List<WebElement> headersList;
	
	@FindBy (xpath="//tr[contains(@id,'product-')]//td[@class='cart_delete']//a")
	private List<WebElement> removeItemBtnsList;
	
	@FindBy (xpath = "//span[@id='empty_cart']//p")
	private WebElement emptyCartMsg;
	
	@FindBy (xpath = "//span[@id='empty_cart']//a")
	private WebElement linkToBuyProducts;
	
	@FindBy (id = "cart_info_table")
	private WebElement cartTable;
	
	@FindBy (xpath = "//div[@class='breadcrumbs']//a")
	private WebElement homePageBtn;
	
	private List<String> headers;
	public static List<LinkedHashMap<String, String>> allTableData;
	private WebElement cell;
	private String cellData;
	private String xpath;
	
	public WebElement getHomePageBtn() {
		return homePageBtn;
	}

	public ViewCartPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}
	
	public void verify() {
		super.verify();
		Assert.assertTrue("Orange button home page is not enabled",homePageBtn.isEnabled());
		if(emptyCartMsg.isDisplayed()) {
			Assert.assertTrue("The cat is empty and link to buy products is not enabled",linkToBuyProducts.isEnabled());
			Assert.assertTrue(emptyCartMsg.getText().toLowerCase().contains("cart is empty!"));
		}else {
		Assert.assertTrue("Proceed to checkout button is not enabled",proceedToCheckoutBtn.isEnabled());
		Assert.assertTrue("Cart table is not displayed",proceedToCheckoutBtn.isDisplayed());
			for (WebElement removeBtn : removeItemBtnsList) {
				Assert.assertTrue("Remove button is not enabled", removeBtn.isEnabled());
			}
		}
	}
	public void verifyCart() {
		List <LinkedHashMap<String, String>> cartItems = getshoppingCartData();
		List <LinkedHashMap<String, String>> addedItems = HomePage.getAllAddedItems();
		for(int i = 0; i < cartItems.size(); i++) {
			Assert.assertTrue(cartItems.get(i).get(headers.get(i)).contains(addedItems.get(i).get(headers.get(i))));
		}
	}
	
	public List<LinkedHashMap<String, String>> getshoppingCartData() {
		allTableData = new LinkedList<LinkedHashMap<String, String>>();
		LinkedHashMap<String, String> eachRowData;
		headers = getHeaders();
		for (int i = 1; i <= rowsList.size(); i++) {
			eachRowData = new LinkedHashMap<>();
			xpath = "(//table[contains(@id,'info_table')]//tr[contains(@id,'product-')]["+i+"]//td)[1]//img";
			cell = driver.findElement(By.xpath(xpath));
			cellData = cell.getAttribute("src");
			eachRowData.put(headers.get(0), cellData);
			for (int j = 2; j <= headers.size()-1; j++) {
				xpath = "(//table[contains(@id,'info_table')]//tr[contains(@id,'product-')]["+i+"]//td)["+j+"]";
				cell = driver.findElement(By.xpath(xpath));
				cellData = cell.getText().strip().trim();
		        eachRowData.put(headers.get(j-1), cellData);
			}
			allTableData.add(eachRowData);
		}
		return allTableData;
	}
	
	public void removeItemFromTheCart() {
		if(removeItemBtnsList.size() > 0) {
			int itemToDelete = Utils.randomPositiveIntBelow(removeItemBtnsList.size());
			String valueToDelete = getshoppingCartData().get(itemToDelete-1).get("item");
			for (int i = 0; i < getAllAddedItems().size(); i++) {
				if (getAllAddedItems().get(i).get("item").contains(valueToDelete))
					getAllAddedItems().remove(i);
			}
			removeItemBtnsList.get(itemToDelete-1).click();
		}
		else {
			Assert.assertTrue("There is no items in cart for deleting",removeItemBtnsList.size() > 0);
		}
	}
	
	private List<String> getHeaders(){
		headers = new ArrayList<String>();
		for (WebElement header : headersList) {
			headers.add(header.getText().trim().toLowerCase());
		}
		return headers;
	}
}

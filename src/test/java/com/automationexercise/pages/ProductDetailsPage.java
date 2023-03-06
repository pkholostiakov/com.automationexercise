package com.automationexercise.pages;

import java.util.ArrayList;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductDetailsPage extends HomePage{

	private BasePage basePage;
	
	@FindBy (xpath = "//div[@class='view-product']//img")
	private WebElement itemImg;
	
	@FindBy (xpath = "//div[contains(@class,'product-information')]")
	private static WebElement productInfo;
	
	@FindBy (xpath = "//div[@class='product-information']//h2")
	private WebElement productName;
	
	@FindBy (xpath = "//div[@class='product-information']//*[contains(text(),'Category:')]")
	private static WebElement category;
	
	@FindBy (xpath = "//div[@class='product-information']//*[contains(text(),'Rs.')]")
	private WebElement price;
	
	@FindBy (id = "quantity")
	private WebElement quantityInput;
	
	@FindBy (xpath = "//div[@class='product-information']//*[contains(text(),'Availability')]")
	private WebElement availability;
	
	@FindBy (xpath = "//div[@class='product-information']//*[contains(text(),'Condition')]")
	private WebElement condition;
	
	@FindBy (xpath = "//div[@class='product-information']//*[contains(text(),'Brand')]")
	private WebElement brand;
	
	@FindBy (xpath = "//div[@class='product-information']//button[contains(@class,'cart')]")
	private WebElement addToCartBtn;
	
	@FindBy (xpath = "//div[contains(@class,'shop-details-tab')]//a")
	private WebElement reviewBar;
	
	@FindBy (xpath = "//form[@id='review-form']//input[@id='name']")
	private WebElement reviewNameInput;
	
	@FindBy (xpath = "//form[@id='review-form']//input[@id='email']")
	private WebElement reviewEmailInput;
	
	@FindBy (xpath = "//form[@id='review-form']//textarea[@id='review']")
	private WebElement reviewTextInput;
	
	@FindBy (xpath = "//form[@id='review-form']//button[@id='button-review']")
	private WebElement submitReviewBtn;
	
	public ProductDetailsPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}
	
	public static WebElement getProductInfo() {
		return productInfo;
	}
	
	public static WebElement getCategory() {
		return category;
	}

	public void verify() {
		basePage = new BasePage(driver);
		basePage.verify();
		
		listOfButtons = new ArrayList<>();
		listOfButtons.add(categoryFilterList);
		listOfButtons.add(brandsFilterList);
		
		for (int i = 0; i < listOfButtons.size(); i++) {
			for (WebElement webElement : listOfButtons.get(i)) {
			Assert.assertTrue(webElement.getText() + " button is not enabled",webElement.isEnabled());
			}
		}
		Assert.assertTrue("Item image is not displayed", itemImg.isDisplayed());
		Assert.assertTrue("Product image is not displayed", productInfo.isDisplayed());
		Assert.assertTrue("Quantity input is not enabled",quantityInput.isEnabled());
		Assert.assertTrue("Add to cart button is not enabled",addToCartBtn.isEnabled());
		Assert.assertTrue("Review name input is not enabled",reviewNameInput.isEnabled());
		Assert.assertTrue("Review email input is not enabled",reviewEmailInput.isEnabled());
		Assert.assertTrue("Review text input is not enabled",reviewTextInput.isEnabled());
		Assert.assertTrue("Review submit button is not enabled",submitReviewBtn.isEnabled());
	}

}

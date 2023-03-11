package com.automationexercise.pages;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutPage extends BasePage{
	
	@FindBy (xpath = "//ul[@id='address_delivery']//li")
	private List<WebElement> deliveryBoxElements;
	
	@FindBy (xpath = "//ul[@id='address_invoice']//li")
	private  List<WebElement> billingBoxElements;
	
	@FindBy (xpath = "//ul[@id='address_delivery']")
	private WebElement deliveryBox;
	
	@FindBy (xpath = "//ul[@id='address_invoice']")
	private WebElement billingBox;
	
	@FindBy (xpath = "//div[@id='ordermsg']//textarea")
	private WebElement descriptionInput;
	
	@FindBy (xpath = "//a[contains(@href,'payment')]")
	private WebElement placeOrderBtn;

	public CheckoutPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}
	
	public WebElement getPlaceOrderBtn() {
		return placeOrderBtn;
	}

	public void verify() {
		super.verify();
		Assert.assertTrue("Delivery box is not displayed",deliveryBox.isDisplayed());
		Assert.assertTrue("Billing box is not displayed",billingBox.isDisplayed());
		Assert.assertTrue("Place order button is not enabled",placeOrderBtn.isEnabled());
	}
	
	public void checkDeliveryAndBillingAddresesAreMatch() {
		for(int i = 1; i < deliveryBoxElements.size(); i++) {
			Assert.assertEquals("Addresses element are not match in " + i + " line",
					deliveryBoxElements.get(i).getText(), billingBoxElements.get(i).getText());
		}
	}
	
	public void fillOutDiscription() {
		descriptionInput.sendKeys("Delivery the order please MN-FR, 9AM to 6 PM");
	}

}

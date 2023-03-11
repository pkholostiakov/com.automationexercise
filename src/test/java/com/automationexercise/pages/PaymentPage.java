package com.automationexercise.pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static com.automationexercise.utils.ConfigReader.*;

public class PaymentPage extends BasePage {
	
	@FindBy (xpath = "//input[@class='form-control']")
	private WebElement cardNameInput;
	
	@FindBy (xpath = "//input[@name='card_number']")
	private WebElement cardNumberInput;
	
	@FindBy (xpath = "//input[@name='cvc']")
	private WebElement cvcCode;
	
	@FindBy (xpath = "//input[@name='expiry_month']")
	private WebElement monthExp;
	
	@FindBy (xpath = "//input[@name='expiry_year']")
	private WebElement yearExp;
	
	@FindBy (xpath = "//button[@id='submit']")
	private WebElement payAndConfirmOrderBtn;
	
	@FindBy (xpath = "(//div[contains(text(),'Your order has been placed successfully!'])[1]")
	private WebElement successMsg;

	public PaymentPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}
	
	public WebElement getPayAndConfirmOrderBtn() {
		return payAndConfirmOrderBtn;
	}
	
	public WebElement getSuccessMsg() {
		return successMsg;
	}

	public void verify() {
		super.verify();
		Assert.assertTrue("Card name input is not enabled",cardNameInput.isEnabled());
		Assert.assertTrue("Card number input is not enabled",cardNumberInput.isEnabled());
		Assert.assertTrue("Card cvc input is not enabled",cvcCode.isEnabled());
		Assert.assertTrue("Card month exp input is not enabled",monthExp.isEnabled());
		Assert.assertTrue("Card year exp input is not enabled",yearExp.isEnabled());
		Assert.assertTrue("Pay and confirm order button is not enabled",payAndConfirmOrderBtn.isEnabled());
	}

	public void fillOutCardData() {
		cardNameInput.sendKeys(getProperty("firstName") + " " + getProperty("lastName"));
		cardNumberInput.sendKeys(getProperty("cardNumber"));
		cvcCode.sendKeys(getProperty("cvc"));
		monthExp.sendKeys(getProperty("monthExp"));
		yearExp.sendKeys(getProperty("yearExp"));
	}
}

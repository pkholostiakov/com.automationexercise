package com.automationexercise.pages;

import java.io.File;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PaymentDonePage extends BasePage{
	
	@FindBy (xpath = "//a[contains(@href,'download')]")
	private WebElement downloadInvoiceBtn;
	
	@FindBy (xpath = "//a[contains(@data-qa,'continue-button')]")
	private WebElement continueBtn;
	
	@FindBy (xpath = "//h2[@data-qa='order-placed']")
	private WebElement header;
	
	@FindBy (xpath = "//div[@id='success_message']")
	private WebElement successMsg;
	
	@FindBy (xpath = "//div[contains(@class,'col-sm-9')]//p")
	private WebElement textMsg;

	public PaymentDonePage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}
	
	public WebElement getDownloadInvoiceBtn() {
		return downloadInvoiceBtn;
	}

	public void verify() {
		super.verify();
		Assert.assertTrue("Download invoice button is not enabled",downloadInvoiceBtn.isEnabled());
		Assert.assertTrue("Continue button is not enabled",continueBtn.isEnabled());
		Assert.assertTrue("Header is not displayed",header.isDisplayed());
		Assert.assertTrue("Text messgae is not displayed",textMsg.isDisplayed());
		sureOrderIsPlaced();
	}
	
	public void sureOrderIsPlaced() {
		Assert.assertTrue("Header is not displayed",header.getText().toLowerCase().contains("order placed"));
		Assert.assertTrue("Text messgae is not displayed",textMsg.getText().toLowerCase().contains("congratulations! your order has been confirmed!"));
	}
	
	public void sureFailIsDownloaded() throws InterruptedException {
		File file = new File(System.getProperty("user.home") + "/Downloads/invoice.txt");
        Thread.sleep(3000);
        Assert.assertTrue("File is not exists in " + file.getAbsolutePath(),file.exists());
	}
}

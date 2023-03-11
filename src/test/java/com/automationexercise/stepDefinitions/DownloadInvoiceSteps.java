package com.automationexercise.stepDefinitions;

import org.openqa.selenium.WebDriver;

import com.automationexercise.pages.PaymentDonePage;
import com.automationexercise.utils.Driver;

import io.cucumber.java.en.*;

public class DownloadInvoiceSteps {
	
	private WebDriver driver = Driver.getDriver();
	private PaymentDonePage paymentDone = new PaymentDonePage(driver);
	

	@When("user clicks download invoice button")
	public void user_clicks_download_invoice_button() {
		paymentDone.getDownloadInvoiceBtn().click();
	}

	@Then("invoice is downloaded")
	public void invoice_is_downloaded() throws InterruptedException {
		paymentDone.sureFailIsDownloaded();
	}

}

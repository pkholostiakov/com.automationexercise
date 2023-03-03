package com.automationexercise.pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class AccountDeletedPage extends AccountCreatedPage {

	public AccountDeletedPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	@Override
	public void verify() {
		BasePage basePage = new BasePage(driver);
		basePage.verify();
		Assert.assertTrue(headerMsg.getText().trim().equals("ACCOUNT DELETED!"));
		Assert.assertTrue("Message is not match",
				actualMsg().contains("Your account has been permanently deleted!"
				+ "You can create new account to take advantage of member privileges to enhance your online shopping experience with us."));
		Assert.assertTrue(continueBtn.getTagName() + " is not enabled", continueBtn.isEnabled());
	}



}

package com.automationexercise.pages;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountCreatedPage extends BasePage{

	@FindBy (xpath = "//div//a[contains(text(),'Continue')]")
	protected WebElement continueBtn;

	@FindBy (xpath = "//h2[contains(@class,'text-center')]")
	protected WebElement headerMsg;

	@FindBy (xpath = "//div[contains(@class,'col-sm-9')]//p")
	protected List<WebElement> psMsg;

	public WebElement getContinueBtn() {
		return continueBtn;
	}

	public AccountCreatedPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	@Override
	public void verify() {
		super.verify();
		Assert.assertTrue(headerMsg.getText().trim().equals("ACCOUNT CREATED!"));
		Assert.assertTrue("Message is not match",
				actualMsg().contains("Congratulations! Your new account has been successfully created!"
				+ "You can now take advantage of member privileges to enhance your online shopping experience with us."));
		Assert.assertTrue(continueBtn.getTagName() + " is not enabled", continueBtn.isEnabled());
	}

	protected String actualMsg() {
		String message = "";
		for (WebElement p : psMsg) {
			message += p.getText().trim();
		}
		return message;
	}

}

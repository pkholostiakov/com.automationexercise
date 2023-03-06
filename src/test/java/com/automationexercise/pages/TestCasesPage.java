package com.automationexercise.pages;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TestCasesPage extends BasePage{
	
	@FindBy	(xpath = "//h2[contains(@class,'title')]")
	private WebElement header;
	
	@FindBy	(xpath = "//div[@class='panel-group'][contains(.,'Click on the scenario for detailed')]")
	private WebElement infoMsg;
	
	@FindBy	(xpath = "//a[@data-toggle='collapse'][contains(.,'Test')]")
	private List<WebElement> testCasesList;
	
	@FindBy	(xpath = "//a[@data-toggle='collapse'][contains(.,'Feedback')]")
	private WebElement feedBackDropDownMenu;

	public WebElement getFeedBackDropDownMenu() {
		return feedBackDropDownMenu;
	}

	public TestCasesPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}
	
	public void verify() {
		super.verify();
		Assert.assertTrue("Test cases header is incorrect",header.getText().trim().toLowerCase().contains("test cases"));
		Assert.assertTrue("Info message is not displayed",infoMsg.isDisplayed());
		for (WebElement webElement : testCasesList) {
			Assert.assertTrue(webElement.getText().trim().toUpperCase() + " is not enabled",webElement.isEnabled());
		}
		Assert.assertTrue("Feedback dropdown menu is not enabled",feedBackDropDownMenu.isEnabled());
		
	}

}

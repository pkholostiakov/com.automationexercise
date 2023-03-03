package com.automationexercise.pages;

import static com.automationexercise.utils.ConfigReader.getProperty;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.automationexercise.utils.Driver;

public class BasePage {

	protected static WebDriver driver = Driver.getDriver();
	protected WebDriverWait wait;

	@FindBy (xpath = "//img[contains(@src,'logo')]")
	protected WebElement mainLogo;

	@FindBy (xpath = "//ul[contains(@class,'navbar')]//li")
	protected static List<WebElement> menuBtns;

	@FindBy (id = "susbscribe_email")
	protected WebElement subscribeInput;

	@FindBy (id = "subscribe")
	protected WebElement subscribeBtn;

	@FindBy (id = "scrollUp")
	protected WebElement scrollUpBtn;

	public BasePage(WebDriver driver) {
		BasePage.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public static void clickMenuBtn(String nameBtn) {
		int i = 0;
		for (WebElement webElement : menuBtns) {
			if(webElement.getText().trim().toLowerCase().contains(nameBtn)) {
				webElement.click();
				i++;
				break;
				}
			if (i!=0)
				break;
			}
		if (i==0) {
			System.out.println("NAME OF BUTTON IS NOT CORRECT");
			System.exit(0);
		}
	}

	public void navigateTo(String pageName) {
		driver.get(getProperty("url") + pageName);
	}

	public void verify() {
		for (WebElement webElement : menuBtns)
			Assert.assertTrue(webElement.getText() + " button is not enabled",webElement.isEnabled());
		Assert.assertTrue(subscribeInput.getText() + " input is not enabled",subscribeInput.isEnabled());
		Assert.assertTrue(subscribeBtn.getText() + " button is not enabled",subscribeBtn.isEnabled());
		Assert.assertTrue(scrollUpBtn.getText() + " button is not enabled",scrollUpBtn.isEnabled());
	}

	public void verifyAsNewUser() {
		verify();
		Assert.assertTrue("User is not logged as " + getProperty("username"),
				menuBtns.get(menuBtns.size()-1).getText().trim().replace("Logged in as ", "").equals(getProperty("usernameNew")));
	}

	public void verifyAsParticularUser(){
		verify();
		Assert.assertTrue("User is not logged as " + getProperty("username"),
				menuBtns.get(menuBtns.size()-1).getText().trim().replace("Logged in as ", "").equals(getProperty("username")));
	}

	public void checkElementIsDisplayed(WebElement element) {
		wait = new WebDriverWait(driver,3);
		wait.until(ExpectedConditions.visibilityOf(element));
		Assert.assertTrue(element.getAttribute("id") + "is not displayed",element.isDisplayed());
	}

	public void checkElementIsDisplayedIFrame(WebElement element) {
		try {
			String dismissBtn = "//div[@id='dismiss-button']";
			driver.switchTo().frame("aswift_1");
			driver.switchTo().frame("ad_iframe");
			driver.findElement(By.xpath(dismissBtn)).click();
			driver.switchTo().defaultContent();
			wait = new WebDriverWait(driver,2);
			wait.until(ExpectedConditions.visibilityOf(element));
			Assert.assertTrue(element.getAttribute("id") + "is not displayed",element.isDisplayed());
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}

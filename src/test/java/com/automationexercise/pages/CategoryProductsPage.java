package com.automationexercise.pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CategoryProductsPage extends HomePage {
	
	@FindBy (xpath = "(//div[@class='features_items']//h2)[1]")
	private WebElement header;

	public CategoryProductsPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}
	
	public void verify() {
		basePage = new BasePage(driver);
		basePage.verify();
		HomePage.verifyPageBtns();
		Assert.assertTrue("Header is not displayed",header.isDisplayed());
	}
	
	public void checkProductsAreMatch() {
		String expectedHeader = HomePage.getNameOfCategory() + " - " + HomePage.getNameOfSubcategory() + " " + "PRODUCTS";
		Assert.assertTrue("The header is not match. Expected header is: " + expectedHeader + ". Actual header is: " + header.getText(),header.getText().equalsIgnoreCase(expectedHeader));
	}
}

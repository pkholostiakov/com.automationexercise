package com.automationexercise.pages;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.automationexercise.utils.ConfigReader;

public class ProductsPage extends HomePage{
	
	@FindBy (id = "sale_image")
	private WebElement specialOfferLogo;
	
	@FindBy (id = "search_product")
	private WebElement searchProductInput;
	
	@FindBy (id = "submit_search")
	private WebElement searchBtn;

	public ProductsPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	public WebElement getSearchProductInput() {
		return searchProductInput;
	}

	public WebElement getSearchBtn() {
		return searchBtn;
	}
	
	public void verify() {
		basePage = new BasePage(driver);
		basePage.verify();
		
		Assert.assertTrue(specialOfferLogo.getTagName()+" is not displayed",specialOfferLogo.isDisplayed());
		Assert.assertTrue(searchProductInput.getTagName()+" is not enabled",searchProductInput.isEnabled());
		Assert.assertTrue(searchBtn.getTagName()+" is not enabled",searchBtn.isEnabled());
		
		listOfButtons = new ArrayList<>();
		listOfButtons.add(categoryFilterList);
		listOfButtons.add(brandsFilterList);
		listOfButtons.add(addToCartBtnList);
		listOfButtons.add(viewProductBtnList);
		
		for (int i = 0; i < listOfButtons.size(); i++) {
			for (WebElement webElement : listOfButtons.get(i)) {
			Assert.assertTrue(webElement.getText() + " button is not enabled",webElement.isEnabled());
			}
		}
	}
	
	public void searchProduct() {
		searchProductInput.sendKeys(ConfigReader.getProperty("searchingQuiry"));
	}
	
	public void checkSearchingOutput() {
		itemName = "//div[contains(@class,'productinfo')]//p";
		List<WebElement> foundItemsNames = driver.findElements(By.xpath(itemName));
		String openInNewTab = Keys.chord(Keys.CONTROL,Keys.RETURN);
		String mainHandle = driver.getWindowHandle();
		Set<String> handles;
		String[]windows;
		String forMsg;
		for (int i = 0; i < foundItemsNames.size();i++) {
			if (foundItemsNames.get(i).getText().toLowerCase().contains(ConfigReader.getProperty("searchingQuiry"))) {
				Assert.assertTrue(foundItemsNames.get(i).getText().toLowerCase().contains(ConfigReader.getProperty("searchingQuiry")));
				continue;
				}
			forMsg = foundItemsNames.get(i).getText();
			viewProductBtnList.get(i).sendKeys(openInNewTab);
			handles = driver.getWindowHandles();
			windows=handles.toArray(new String[handles.size()]);
			driver.switchTo().window(windows[windows.length-1]);
			wait = new WebDriverWait(driver,1);
			wait.until(ExpectedConditions.visibilityOf(ProductDetailsPage.getProductInfo()));
			Assert.assertTrue(forMsg + " have no to be display in case of searching " 
			+ ConfigReader.getProperty("searchingQuiry") + " because have no searching quiry neither name or category.",
			ProductDetailsPage.getCategory().getText().toLowerCase().contains(ConfigReader.getProperty("searchingQuiry")));
			driver.close();
			driver.switchTo().window(mainHandle);
		}
	}
}

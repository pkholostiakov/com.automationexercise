package com.automationexercise.pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends BasePage{

	@FindBy (id = "slider-carousel")
	private WebElement sliderCarousel;

	@FindBy (xpath = "//div[contains(@class,'category-products')]")
	private WebElement categoryFilter;

	@FindBy (xpath = "//div[contains(@class,'brands_products')]")
	private WebElement brandsFilter;

	@FindBy (xpath = "//div[contains(@class,'features_items')]")
	private WebElement featuresItems;

	@FindBy (xpath = "//div[contains(@class,'recommended_items')]")
	private WebElement recomendedItems;

	public HomePage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	public WebElement getSliderCarousel() {
		return sliderCarousel;
	}

	@Override
	public void verify() {
		super.verify();
		Assert.assertTrue(sliderCarousel.getTagName() + " is not displayed",sliderCarousel.isDisplayed());
		Assert.assertTrue(categoryFilter.getTagName() + " is not displayed",categoryFilter.isDisplayed());
		Assert.assertTrue(brandsFilter.getTagName() + " is not displayed",brandsFilter.isDisplayed());
		Assert.assertTrue(featuresItems.getTagName() + " is not displayed",featuresItems.isDisplayed());
		Assert.assertTrue(recomendedItems.getTagName() + " is not displayed",recomendedItems.isDisplayed());
	}
}

package com.automationexercise.stepDefinitions;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import com.automationexercise.pages.BrandProductsPage;
import com.automationexercise.pages.HomePage;
import com.automationexercise.utils.Driver;

import io.cucumber.java.en.*;

public class BrandSteps {
	
	private WebDriver driver = Driver.getDriver();
	private HomePage homePage = new HomePage(driver);
	private BrandProductsPage brandProductsPage = new BrandProductsPage(driver);
	
	@When("user clicks some of brand")
	public void user_clicks_some_of_brand() {
		homePage.selectRandomBrand();
	}

	@Then("user is navigated to brand products page")
	public void user_is_navigated_to_brand_products_page() {
		Assert.assertTrue(driver.getCurrentUrl().contains("brand_products"));
	}

	@Then("brand products page is visible successfully")
	public void brand_products_page_is_visible_successfully() {
		brandProductsPage.verify();
	}

	@Then("products at the page is match with selected brand")
	public void products_at_the_page_is_match_with_selected_brand() {
		brandProductsPage.checkProductsAreMatch();
	}
}

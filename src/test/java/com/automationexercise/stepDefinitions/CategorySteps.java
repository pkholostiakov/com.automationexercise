package com.automationexercise.stepDefinitions;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import com.automationexercise.pages.HomePage;
import com.automationexercise.pages.CategoryProductsPage;
import com.automationexercise.utils.Driver;

import io.cucumber.java.en.*;

public class CategorySteps {
	
	private WebDriver driver = Driver.getDriver();
	private HomePage homePage = new HomePage(driver);
	private CategoryProductsPage categoryProductsPage = new CategoryProductsPage(driver);
	
	@When("user clicks some of category and subcategory")
	public void user_clicks_some_of_category_and_subcategory() {
		homePage.selectRandomCategoryAndSubcategory();
	}

	@Then("user is navigated to category products page")
	public void user_is_navigated_to_category_products_page() {
		Assert.assertTrue(driver.getCurrentUrl().contains("category_products"));
	}

	@And("category products page is visible successfully")
	public void category_products_page_is_visible_successfully() {
		categoryProductsPage.verify();
	}

	@And("products at the page is match with selected category and subcategory")
	public void products_at_the_page_is_match_with_selected_category_and_subcategory() {
		categoryProductsPage.checkProductsAreMatch();
	}
}

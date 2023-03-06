package com.automationexercise.stepDefinitions;

import org.openqa.selenium.WebDriver;

import com.automationexercise.pages.BasePage;
import com.automationexercise.pages.ProductDetailsPage;
import com.automationexercise.pages.ProductsPage;
import com.automationexercise.utils.Driver;

import io.cucumber.java.en.*;

public class ProductsSteps {
	
	private WebDriver driver = Driver.getDriver();
	private BasePage basePage = new BasePage(driver);
	private ProductsPage productsPage = new ProductsPage(driver);
	private ProductDetailsPage productDetailsPage = new ProductDetailsPage(driver);
	
	@When("user clicks Products button")
	public void user_clicks_products_button() {
		BasePage.clickMenuBtn("products");
	}

	@Then("user is navigated to Products page")
	public void user_is_navigated_to_products_page() throws InterruptedException {
		basePage.checkElementIsDisplayed(productsPage.getSearchProductInput());
	}

	@Then("products page is visible successfully")
	public void products_page_is_visible_successfully() {
		productsPage.verify();
	}

	@When("user clicks on the first product from the product list")
	public void user_clicks_on_the_first_product_from_the_product_list() {
		productsPage.clickViewProduct(1);
	}

	@Then("user is navigated to the Product Details page")
	public void user_is_navigated_to_the_product_details_page() throws InterruptedException {
		ProductDetailsPage.getProductInfo().isDisplayed();
	}

	@Then("product details page is visible successfully")
	public void product_details_page_is_visible_successfully() {
		productDetailsPage.verify();
	}

	@When("user enters product name in search input")
	public void user_enters_product_name_in_search_input() {
		productsPage.searchProduct();
	}

	@When("user clicks search button near search input")
	public void user_clicks_search_button_near_search_input() {
		productsPage.getSearchBtn().click();
	}

	@Then("searched products is visible succsessfully and products related to search")
	public void searched_products_is_visible_succsessfully_and_products_related_to_search() throws InterruptedException {
		productsPage.checkSearchingOutput();
	}

}

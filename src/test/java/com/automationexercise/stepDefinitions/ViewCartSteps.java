package com.automationexercise.stepDefinitions;

import org.openqa.selenium.WebDriver;

import com.automationexercise.pages.BasePage;
import com.automationexercise.pages.HomePage;
import com.automationexercise.pages.ProductDetailsPage;
import com.automationexercise.pages.ProductsPage;
import com.automationexercise.pages.ViewCartPage;
import com.automationexercise.utils.Driver;

import io.cucumber.java.en.*;

public class ViewCartSteps {
	
	private WebDriver driver = Driver.getDriver();
	private BasePage basePage = new BasePage(driver);
	private HomePage homePage = new HomePage(driver);
	private ViewCartPage viewCartPage = new ViewCartPage(driver);
	private ProductsPage productsPage = new ProductsPage(driver);
	private ProductDetailsPage productDetailsPage = new ProductDetailsPage(driver);

	@When("user clicks add to cart button on recommended product")
	public void user_clicks_add_to_cart_button_on_recomended_product() {
		homePage.clickAddToCartRecomendedItem();
	}
	
	@When("user clicks add to cart button on the item")
	public void user_clicks_add_to_cart_button_on_the_item() {
		productsPage.clickRandomAddToCartBtn();
	}
	
	@When("user clicks continue shopping button")
	public void user_clicks_continue_shopping_button() {
		homePage.clickContinueShopBtn();
	}
	
	@When("user clicks view cart button")
	public void user_clicks_view_cart_button() {
		BasePage.clickMenuBtn("cart");
	}
	
	@Then("user is navigated to view cart page")
	public void user_is_navigated_to_view_cart_page() {
		basePage.checkElementIsDisplayed(viewCartPage.getHomePageBtn());
	}
	
	@Then("view cart page is visible successfully")
	public void view_cart_page_is_visible_successfully() {
		viewCartPage.verify();
	}
		
	@And("user verify all the products in the cart")
	public void user_verify_all_the_products_in_the_cart() {
		viewCartPage.verifyCart();
	}
	
	@When("user clicks remove button in the cart")
	public void user_clicks_remove_button_in_the_cart() {
		viewCartPage.removeItemFromTheCart();
	}
		
	@When("user clicks add to cart button near the quantity")
	public void user_clicks_add_to_cart_button_near_the_quantity() {
		productDetailsPage.addToCartButtonNearQuantity();
	}

	@When("user increases quantity")
	public void user_increases_quantity() {
		productDetailsPage.entersQuantity();
	}
}

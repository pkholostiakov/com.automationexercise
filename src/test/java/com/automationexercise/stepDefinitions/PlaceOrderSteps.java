package com.automationexercise.stepDefinitions;

import org.openqa.selenium.WebDriver;

import com.automationexercise.pages.CheckoutPage;
import com.automationexercise.pages.PaymentDonePage;
import com.automationexercise.pages.PaymentPage;
import com.automationexercise.pages.ViewCartPage;
import com.automationexercise.utils.Driver;

import io.cucumber.java.en.*;

public class PlaceOrderSteps {
	
	private WebDriver driver = Driver.getDriver();
	private ViewCartPage viewCartPage = new ViewCartPage(driver);
	private CheckoutPage checkoutPage = new CheckoutPage(driver);
	private PaymentPage paymentPage = new PaymentPage(driver);
	private PaymentDonePage paymentDone = new PaymentDonePage(driver);
	
	@When("user clicks proceed to checkout button")
	public void user_clicks_proceed_to_checkout_button() {
		viewCartPage.getProceedToCheckoutBtn().click();
	}

	@When("user clicks register login button")
	public void user_clicks_register_login_button() {
		viewCartPage.getRegisterOrLoginBtn().click();
	}

	@When("user is navigated to checkout page")
	public void user_is_navigated_to_checkout_page() {
		driver.getCurrentUrl().contains("checkout");
	}

	@When("checkout page is visible successfully")
	public void checkout_page_is_visible_successfully() {
		checkoutPage.verify();
	}

	@When("delivery address and user info is matches")
	public void delivery_address_and_user_info_is_matches() {
		checkoutPage.checkDeliveryAndBillingAddresesAreMatch();
	}

	@When("user enters discription in comment text area")
	public void user_enters_discription_in_comment_text_area() {
		checkoutPage.fillOutDiscription();
	}

	@When("user clicks place order button")
	public void user_clicks_place_order_button() {
		checkoutPage.getPlaceOrderBtn().click();
	}

	@When("user is navigated to payment page")
	public void user_is_navigated_to_payment_page() {
		driver.getCurrentUrl().contains("payment");
	}

	@When("payment page is visible successfully")
	public void payment_page_is_visible_successfully() {
		paymentPage.verify();
	}

	@When("user enters name on card, card number, CVC and expiration date")
	public void user_enters_name_on_card_card_number_cvc_and_expiration_date() {
		paymentPage.fillOutCardData();
	}

	@When("user clicks pay and confirm order button")
	public void user_clicks_pay_and_confirm_order_button() {
		paymentPage.getPayAndConfirmOrderBtn().click();
	}

	@Then("user is navigated to payment done page")
	public void user_is_navigated_to_payment_done_page() {
		driver.getCurrentUrl().contains("payment_done");
	}

	@Then("payment done page is visible successfully")
	public void payment_done_page_is_visible_successfully() {
		paymentDone.verify();
	}
	
	@And ("order placed message is appears")
	public void order_placed_message_is_appears() {
		paymentDone.sureOrderIsPlaced();
	}

}

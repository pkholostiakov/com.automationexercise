package com.automationexercise.stepDefinitions;

import org.openqa.selenium.WebDriver;

import com.automationexercise.pages.BasePage;
import com.automationexercise.pages.ProductDetailsPage;
import com.automationexercise.utils.Driver;

import io.cucumber.java.en.*;

public class ReviewSteps {
	
	private WebDriver driver = Driver.getDriver();
	private ProductDetailsPage productDetailsPage = new ProductDetailsPage(driver);
	private BasePage basePage = new BasePage(driver);

	@When("user enters {string},{string} and {string}")
	public void user_enters_and(String name, String email, String review) {
		productDetailsPage.leaveReview(name , email, review);
	}
	
	@And ("user clicks submit review button")
	public void user_clicks_submit_review_button() {
		productDetailsPage.getSubmitReviewBtn().click();
	}

	@Then("success message about review appears")
	public void success_message_about_review_appears() {
		basePage.checkElementIsDisplayed(productDetailsPage.getSuccessReviewMsg());
	}
	
}

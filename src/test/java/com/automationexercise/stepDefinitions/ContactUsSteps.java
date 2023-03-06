package com.automationexercise.stepDefinitions;

import org.openqa.selenium.WebDriver;

import com.automationexercise.pages.BasePage;
import com.automationexercise.pages.ContactUsPage;
import com.automationexercise.utils.Driver;

import io.cucumber.java.en.*;

public class ContactUsSteps {
	
	private WebDriver driver = Driver.getDriver();
	private BasePage basePage = new BasePage(driver);
	private ContactUsPage contactUsPage = new ContactUsPage(driver);

	@When("user clicks Contact us button")
	public void user_clicks_contact_us_button() {
		BasePage.clickMenuBtn("contact us");
	}

	@Then("user is navigated to contact us page")
	public void user_is_navigated_to_contact_us_page() throws InterruptedException {
		basePage.checkElementIsDisplayed(contactUsPage.getHeader());
	}

	@Then("contact us page is visible successfully")
	public void contact_us_page_is_visible_successfully() {
		contactUsPage.verify();
	}

	@When("user enters {string}, {string}, {string} and {string}")
	public void user_enters_name_email_subject_and_message(String name, String email, String subject, String message) {
		contactUsPage.fillInnFeedbackForm(name, email, subject, message);
	}

	@When("user uploads file")
	public void user_uploads_file() throws InterruptedException {
		contactUsPage.uploadFile();
	}

	@When("user clicks submit button")
	public void user_clicks_submit_button() {
		contactUsPage.getSubmitBtn().click();
	}

	@When("user clicks ok button in alert")
	public void user_clicks_ok_button_in_alert() {
		contactUsPage.acceptAlert();
	}

	@Then("success message is apears")
	public void success_message_is_apears() {
		basePage.checkElementIsDisplayed(contactUsPage.getSuccessMsg());
	}

	@When("user clicks home button")
	public void user_clicks_home_button() {
		BasePage.clickMenuBtn("home");
	}

}

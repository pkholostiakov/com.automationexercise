package com.automationexercise.stepDefinitions;

import org.openqa.selenium.WebDriver;

import com.automationexercise.pages.BasePage;
import com.automationexercise.pages.HomePage;
import com.automationexercise.pages.TestCasesPage;
import com.automationexercise.utils.Driver;

import io.cucumber.java.en.*;

public class HomePageSteps {
	
	private WebDriver driver = Driver.getDriver();
	private BasePage basePage = new BasePage(driver);
	private HomePage homePage = new HomePage(driver);
	private TestCasesPage testCasesPage = new TestCasesPage(driver);

	@When("user clicks Test Cases button")
	public void user_clicks_test_cases_button() {
		BasePage.clickMenuBtn("test");
	}

	@Then("user is navigated to Test Cases page")
	public void user_is_navigated_to_test_cases_page() throws InterruptedException {
		basePage.checkElementIsDisplayed(testCasesPage.getFeedBackDropDownMenu());
	}

	@Then("Test Cases page is visible successfully")
	public void test_cases_page_is_visible_successfully() {
		testCasesPage.verify();
	}
	
	@When("user completely scrolls down")
	public void user_completely_scrolls_down() {
		homePage.scroll("down");
	}

	@When("user clicks scroll up arrow button")
	public void user_clicks_scroll_up_arrow_button() {
		basePage.getScrollUpBtn().click();
	}

	@Then("user is lifted up at the very beginning of the home page")
	public void user_is_lifted_up_at_the_very_beginning_of_the_home_page() {
		homePage.getSliderCarousel().isDisplayed();
	}

	@When("user completely scrolls up")
	public void user_completely_scrolls_up() {
		homePage.scroll("up");
	}
	
	@When("user enters email address in subscription input field")
	public void user_enters_email_address_in_subscription_input_field() {
		homePage.fillOutSubscriptionField();
	}

	@When("user clicks subscribe button")
	public void user_clicks_subscribe_button() {
		basePage.getSubscribeBtn().click();
	}

	@Then("success message about subscription appears")
	public void success_message_about_subscription_appears() {
		homePage.userIsSubscribed();
	}
	
    @When ("user clicks cart button")
    public void user_clicks_cart_button() {
    	BasePage.clickMenuBtn("cart");
    }
	
}

package com.automationexercise.stepDefinitions;

import org.openqa.selenium.WebDriver;

import com.automationexercise.pages.BasePage;
import com.automationexercise.pages.LoginPage;
import com.automationexercise.utils.Driver;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginSteps {

	private WebDriver driver = Driver.getDriver();
	private BasePage basePage = new BasePage(driver);
	private LoginPage loginPage = new LoginPage(driver);

	@When ("user enters valid credentials below login to your accout")
	public void user_enters_valid_credentials_below_login_to_your_accout() {
		loginPage.enterCredentials("login");
	}
    @When ("user enters invalid credentials below login to your accout")
    public void user_enters_invalid_credentials_below_login_to_your_accout() {
    	loginPage.enterCredentials("login invalid");
	}
    @And ("user clicks login button")
    public void user_clicks_login_button() {
		loginPage.getLoginBtn().click();
	}
    @Then ("invalid credentials message is appears")
    public void invalid_credentials_message_is_appears() {
		basePage.checkElementIsDisplayed(loginPage.getInvalidCredentialsMsg());
	}

}

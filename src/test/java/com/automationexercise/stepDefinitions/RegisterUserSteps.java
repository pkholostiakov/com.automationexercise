package com.automationexercise.stepDefinitions;

import org.openqa.selenium.WebDriver;

import com.automationexercise.pages.AccountCreatedPage;
import com.automationexercise.pages.AccountDeletedPage;
import com.automationexercise.pages.BasePage;
import com.automationexercise.pages.HomePage;
import com.automationexercise.pages.LoginPage;
import com.automationexercise.pages.SignUpPage;
import com.automationexercise.utils.Driver;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class RegisterUserSteps {

	private WebDriver driver = Driver.getDriver();
	private BasePage basePage = new BasePage(driver);
	private HomePage homePage = new HomePage(driver);
	private LoginPage loginPage = new LoginPage(driver);
	private SignUpPage signUpPage = new SignUpPage(driver);
	private AccountDeletedPage accountDeletedPage = new AccountDeletedPage(driver);
	private AccountCreatedPage accountCreatedPage = new AccountCreatedPage(driver);

	@When("browser is open")
	public void browser_is_open() {
		driver = Driver.getDriver();
	}

	@When("user is on the home page")
	public void user_is_on_the_home_page() {
		basePage.navigateTo("homepage");
	}

	@When("home page is visible successfully")
	public void home_page_is_visible_successfully() {
		homePage.verify();
	}

	@When("user clicks on Signup or Login button")
	public void user_clicks_on_signup_or_login_button() {
		BasePage.clickMenuBtn("signup");
	}

	@Then("user is navigated to login page")
	public void user_is_navigated_to_login_page() throws InterruptedException {
		basePage.checkElementIsDisplayed(loginPage.getSignUpbtn());
	}

	@Then("login page is visible successfully")
	public void login_page_is_visible_successfully() {
		loginPage.verify();
	}

	@When("user enters name and email address below new user signup message")
	public void user_enters_name_and_email_address_below_new_user_signup_message() {
		loginPage.enterCredentials("Sign Up");
		signUpPage.setEmailforSugnUp(loginPage.getEmailForInput());
	}

	@When("user clicks signup button")
	public void user_clicks_signup_button() {
		loginPage.getSignUpbtn().click();
	}

	@Then("user is navigated to sign up page")
	public void user_is_navigated_to_sign_up_page() throws InterruptedException {
		basePage.checkElementIsDisplayed(signUpPage.getCreateAccountBtn());
	}

	@Then("sign up page is visible successfully")
	public void sign_up_page_is_visible_successfully() {
		signUpPage.verify();
	}

	@When("user fill details: Title, Name, Email, Password, Date of birth")
	public void user_fill_details_title_name_email_password_date_of_birth() {
		signUpPage.fillInnGenderNameEmailPasswordDOB();
	}

	@When("user select checkbox sign up for our newsletter")
	public void user_select_checkbox_sign_up_for_our_newsletter() {
		signUpPage.getCheckBoxNews().click();
	}

	@When("user select checkbox receive special offers from our partners")
	public void user_select_checkbox_receive_special_offers_from_our_partners() {
		signUpPage.getCheckBoxOffers().click();
	}

	@When("user fill details: First name, Last name, Company, Address, Address2, Country, State, City, Zipcode, Mobile Number")
	public void user_fill_details_first_name_last_name_company_address_address2_country_state_city_zipcode_mobile_number() {
		signUpPage.fillFirstAndLastNameCompanyAddressCountryStateCityPostalCodeMobileNumber();
	}

	@When("user clicks create account button")
	public void user_clicks_create_account_button() {
		signUpPage.getCreateAccountBtn().click();
	}

	@When("user is navigated to account created page")
	public void user_is_navigated_to_account_created_page() throws InterruptedException {
		basePage.checkElementIsDisplayed(accountCreatedPage.getContinueBtn());
	}

	@When("account created page is visible successfully")
	public void account_created_page_is_visible_successfully() {
		accountCreatedPage.verify();
	}

	@When("user clicks continue button")
	public void user_clicks_continue_button() {
		accountCreatedPage.getContinueBtn().click();
	}

	@When("user is navigated to the home page")
	public void user_is_navigated_to_the_home_page() throws InterruptedException {
		basePage.checkElementIsDisplayed(homePage.getSliderCarousel());
	}

	@When("user is logged in as new user")
	public void user_is_logged_in_as_new_user() {
		homePage.verifyAsNewUser();
	}

	@When("user is logged in as particular user")
	public void user_is_logged_in_as_particular_user() {
		homePage.verifyAsParticularUser();
	}

    @When ("user click delete account button")
    public void user_click_delete_account_button() {
		BasePage.clickMenuBtn("delete account");
	}
    @Then ("user is navigated to account deleted page")
    public void user_is_navigated_to_account_deleted_page() throws InterruptedException {
    	basePage.checkElementIsDisplayed(accountDeletedPage.getContinueBtn());
	}

    @And ("account deleted page is visible successfully")
    public void account_deleted_page_is_visible_successfully() {
    	accountDeletedPage.verify();
    }
    @And ("user is not logged in as particular user")
    public void user_is_not_logged_in_as_particular_user() {
    	basePage.checkElementIsDisplayed(homePage.getSliderCarousel());
	}

    @When ("user enters name and existing email address below new user signup message")
    public void user_enters_name_and_existing_email_address_below_new_user_signup_message() {
    	loginPage.enterCredentials("signup existing email");
    }
    @Then ("existing email message is appears")
    public void existing_email_message_is_appears() {
    	basePage.checkElementIsDisplayed(loginPage.getExistingEmailMsg());
    }
}

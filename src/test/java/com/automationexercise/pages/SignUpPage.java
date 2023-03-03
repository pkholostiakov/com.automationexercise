package com.automationexercise.pages;

import static com.automationexercise.utils.ConfigReader.getProperty;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class SignUpPage extends BasePage {

	@FindBy (xpath = "//h2[contains(@class,'text-center')]")
	private List<WebElement> headersMsg;

	@FindBy (xpath = "//div[@class='radio-inline']")
	private List<WebElement> genders ;

	@FindBy (id = "name")
	private WebElement nameInput;

	@FindBy (id = "email")
	private WebElement emailInput;

	@FindBy (id = "password")
	private WebElement passwordInput;

	@FindBy (id = "days")
	private WebElement dayDOB;

	@FindBy (id = "months")
	private WebElement monthDOB;

	@FindBy (id = "years")
	private WebElement yearDOB;

	@FindBy (id = "newsletter")
	private WebElement checkBoxNews;

	@FindBy (id = "optin")
	private WebElement checkBoxOffers;

	@FindBy (id = "first_name")
	private WebElement firstNameInput;

	@FindBy (id = "last_name")
	private WebElement lastNameInput;

	@FindBy (id = "company")
	private WebElement companyInput;

	@FindBy (id = "address1")
	private WebElement addressInput;

	@FindBy (id = "address2")
	private WebElement addressAddInput;

	@FindBy (id = "country")
	private WebElement countryInput;

	@FindBy (id = "state")
	private WebElement stateInput;

	@FindBy (id = "city")
	private WebElement cityInput;

	@FindBy (id = "zipcode")
	private WebElement postalCodeInput;

	@FindBy (id = "mobile_number")
	private WebElement mobileNumberInput;

	@FindBy (xpath = "//form[@action='/signup']//button[@type='submit']")
	private WebElement createAccountBtn;

	private final WebElement[] dob = {dayDOB,monthDOB,yearDOB};
	private final String[] dobData = {getProperty("dayDOB"),getProperty("monthDOB"),getProperty("yearDOB")};
	private String emailforSugnUp;
	private Select options;

	public SignUpPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	public String getEmailforSugnUp() {
		return emailforSugnUp;
	}

	public void setEmailforSugnUp(String emailforSugnUp) {
		this.emailforSugnUp = emailforSugnUp;
	}

	public WebElement getCheckBoxNews() {
		return checkBoxNews;
	}

	public WebElement getCheckBoxOffers() {
		return checkBoxOffers;
	}

	public WebElement getCreateAccountBtn() {
		return createAccountBtn;
	}

	@Override
	public void verify() {
		super.verify();
		checkHeaders();
		checkGendersRadios();
		Assert.assertTrue("Password input is not enabled", passwordInput.isEnabled());
		checkDOBDropdownMenus();
		checkChechBoxes();
		Assert.assertTrue("First name input is not enabled", firstNameInput.isEnabled());
		Assert.assertTrue("Last name input is not enabled", lastNameInput.isEnabled());
		Assert.assertTrue("Company name input is not enabled", companyInput.isEnabled());
		Assert.assertTrue("Address input is not enabled", addressInput.isEnabled());
		Assert.assertTrue("Adition address input is not enabled", addressAddInput.isEnabled());
		checkCountryDropdownMenu();
		Assert.assertTrue("State input is not enabled", stateInput.isEnabled());
		Assert.assertTrue("City input is not enabled", cityInput.isEnabled());
		Assert.assertTrue("Postal code input is not enabled", postalCodeInput.isEnabled());
		Assert.assertTrue("Mobile number input is not enabled", mobileNumberInput.isEnabled());
	}

	public void fillInnGenderNameEmailPasswordDOB() {
		for (WebElement option : genders) {
			if(option.getText().trim().equals(getProperty("gender")))
				option.click();
		}
		checkNameInput();
		checkEmailInput();
		passwordInput.sendKeys(getProperty("password"));

		for (int i = 0; i < dob.length; i++) {
			options = new Select(dob[i]);
			options.selectByVisibleText(dobData[i]);
		}
	}

	public void fillFirstAndLastNameCompanyAddressCountryStateCityPostalCodeMobileNumber() {
		firstNameInput.sendKeys(getProperty("firstName"));
		lastNameInput.sendKeys(getProperty("lastName"));
		companyInput.sendKeys(getProperty("company"));
		addressInput.sendKeys(getProperty("address"));
		addressAddInput.sendKeys(getProperty("addressAdd"));
		countryInput.sendKeys(getProperty("country"));
		stateInput.sendKeys(getProperty("state"));
		cityInput.sendKeys(getProperty("city"));
		postalCodeInput.sendKeys(getProperty("postalCode"));
		mobileNumberInput.sendKeys(getProperty("mobileNumber"));
	}

	private void checkHeaders() {
		List<String> headers = new ArrayList<>();
		headers.add("ENTER ACCOUNT INFORMATION");
		headers.add("ADDRESS INFORMATION");
		for (WebElement header : headersMsg)
			headers.remove(header.getText().trim().toUpperCase());
		Assert.assertTrue(headers.size()==0);
	}

	private void checkGendersRadios() {
		for (WebElement radioBtn : genders) {
			Assert.assertTrue(radioBtn.isEnabled());
		}
	}

	private void checkNameInput() {
		Assert.assertTrue(nameInput.getAttribute("value").equals(getProperty("usernameNew")));
	}

	private void checkEmailInput() {
		Assert.assertTrue(emailInput.getAttribute("value").equals(emailforSugnUp));
	}

	private void checkChechBoxes() {
		if (checkBoxNews.isSelected())
			checkBoxNews.click();
		if (checkBoxOffers.isSelected())
			checkBoxOffers.click();
		Assert.assertTrue("Chechbox news is not enabled", checkBoxNews.isEnabled());
		Assert.assertTrue("Chechbox offers is not enabled", checkBoxOffers.isEnabled());
	}

	private void checkCountryDropdownMenu() {
		Assert.assertTrue("Country field is not enabled",countryInput.isEnabled());	}

	private void checkDOBDropdownMenus() {
		Assert.assertTrue("Day of birth field is not enabled",dayDOB.isEnabled());
		Assert.assertTrue("Month of birth field is not enabled",monthDOB.isEnabled());
		Assert.assertTrue("Year of birth field is not enabled",yearDOB.isEnabled());
		}
}

package com.automationexercise.pages;

import static com.automationexercise.utils.ConfigReader.getProperty;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.automationexercise.utils.Utils;

public class LoginPage extends BasePage{

	@FindBy (xpath = "//form[@action='/signup']//input[@type='email']")
	private WebElement emailInputSignUp;

	@FindBy (xpath = "//form[@action='/login']//input[@type='email']")
	private WebElement emailInputLogin;

	@FindBy (xpath = "//form[@action='/login']//input[@type='password']")
	private WebElement passwordInputLogin;

	@FindBy (xpath = "//form[@action='/signup']//input[@type='text']")
	private WebElement nameInputSignUp;

	@FindBy (xpath = "//form[@action='/login']//button[@type='submit']")
	private WebElement loginBtn;

	@FindBy (xpath = "//form[@action='/signup']//button[@type='submit']")
	private WebElement signUpbtn;

	@FindBy (xpath = "//form[@action='/login']//p")
	private WebElement invalidCredentialsMsg;

	@FindBy (xpath = "//form[@action='/signup']//p")
	private WebElement existingEmailMsg;

	private String emailForInput;

	public LoginPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	public String getEmailForInput() {
		return emailForInput;
	}

	public WebElement getLoginBtn() {
		return loginBtn;
	}

	public WebElement getSignUpbtn() {
		return signUpbtn;
	}

	public WebElement getInvalidCredentialsMsg() {
		return invalidCredentialsMsg;
	}

	public WebElement getExistingEmailMsg() {
		return existingEmailMsg;
	}

	public void verifyer() {
		super.verify();
		Assert.assertTrue(emailInputLogin.getTagName() + " is not enabled", emailInputLogin.isEnabled());
		Assert.assertTrue(passwordInputLogin.getTagName() + " is not enabled", passwordInputLogin.isEnabled());
		Assert.assertTrue(loginBtn.getTagName() + " is not enabled", loginBtn.isEnabled());
		Assert.assertTrue(nameInputSignUp.getTagName() + " is not enabled", nameInputSignUp.isEnabled());
		Assert.assertTrue(emailInputSignUp.getTagName() + " is not enabled", emailInputSignUp.isEnabled());
		Assert.assertTrue(signUpbtn.getTagName() + " is not enabled", signUpbtn.isEnabled());
	}

	public void enterCredentials(String option) {
		switch (option.trim().toLowerCase()) {
		case "login":
			emailInputLogin.sendKeys(getProperty("email"));
			passwordInputLogin.sendKeys(getProperty("password"));
			break;
		case "login invalid":
			emailInputLogin.sendKeys(Utils.generateMail());
			passwordInputLogin.sendKeys(getProperty("password"));
			break;
		case "signup":
		case "sign up":
			emailForInput = Utils.generateMail();
			nameInputSignUp.sendKeys(getProperty("usernameNew"));
			emailInputSignUp.sendKeys(emailForInput);
			break;
		case "signup existing email":
		case "sign up existing email":
			nameInputSignUp.sendKeys(getProperty("usernameNew"));
			emailInputSignUp.sendKeys(getProperty("email"));
			break;
		default:
			System.out.println("OPTION IS NOT FOUND");
			break;
		}
	}
}

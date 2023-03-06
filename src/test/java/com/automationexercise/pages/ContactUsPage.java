package com.automationexercise.pages;

import java.io.File;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ContactUsPage extends BasePage{

	@FindBy (xpath = "//h2[contains(text(),'Get In Touch')]")
	private WebElement header;

	@FindBy (xpath = "//input[@name='name']")
	private WebElement nameInput;

	@FindBy (xpath = "//input[@name='email']")
	private WebElement emailInput;

	@FindBy (xpath = "//input[@name='subject']")
	private WebElement subjectInput;

	@FindBy (id = "message")
	private WebElement messageInput;

	@FindBy (xpath = "//input[@name='submit']")
	private WebElement submitBtn;

	@FindBy (xpath = "//input[@name='upload_file']")
	private WebElement uploadFile;
	
	@FindBy (xpath = "//div[@class='contact-form']//div[contains(@class,'alert-success')]")
	private WebElement successMsg;
	
	@FindBy (xpath = "//a[contains(@class,'btn-success')]")
	private WebElement homeBtn;

	public ContactUsPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	public WebElement getHeader() {
		return header;
	}
	
	public WebElement getSubmitBtn() {
		return submitBtn;
	}
	
	public WebElement getSuccessMsg() {
		return successMsg;
	}

	public void verify() {
		super.verify();
		Assert.assertTrue(nameInput.getAttribute("name") + " field is not enabled",nameInput.isEnabled());
		Assert.assertTrue(emailInput.getAttribute("name") + " field is not enabled",emailInput.isEnabled());
		Assert.assertTrue(subjectInput.getAttribute("name") + " field is not enabled",subjectInput.isEnabled());
		Assert.assertTrue(messageInput.getAttribute("name") + " field is not enabled",messageInput.isEnabled());
		Assert.assertTrue(uploadFile.getAttribute("name") + " field is not enabled",uploadFile.isEnabled());
		Assert.assertTrue(submitBtn.getAttribute("name") + " field is not enabled",submitBtn.isEnabled());
	}

	public void fillInnFeedbackForm(String name, String email, String subject, String message) {
		nameInput.sendKeys(name);
		emailInput.sendKeys(email);
		subjectInput.sendKeys(subject);
		messageInput.sendKeys(message);
	}
	
	public void uploadFile() throws InterruptedException {
		wait = new WebDriverWait(driver, 1);
		File file = new File(System.getProperty("user.dir") + "/src/test/resources/uploadingFIle.gif");
		uploadFile.sendKeys(file.getAbsolutePath());
//		Assert.assertTrue(driver.getPageSource().contains("uploadingFIle.gif"));
	}
	
	public void acceptAlert() {
		driver.switchTo().alert().accept();
	}
}

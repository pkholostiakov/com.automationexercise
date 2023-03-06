package com.automationexercise.hooks;

import static com.automationexercise.utils.ConfigReader.getProperty;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.automationexercise.pages.BasePage;
import com.automationexercise.utils.Driver;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Hooks {

	private WebDriver driver;

	@Before
	public void setUp() {
		driver = Driver.getDriver();
		driver.get(getProperty("url"));
	}

	@After
	public static void tearDown(Scenario scenario) {
		for (int i = 0; i < BasePage.getMenuBtns().size(); i++) {
			if(BasePage.getMenuBtns().get(i).getText().toLowerCase().contains("logout"))
				BasePage.clickMenuBtn("logout");
		}
		if (scenario.isFailed()) {
			String screenshotName = scenario.getName().replaceAll(" ", "_");
			String screenshotPath = "target/screenshots" + screenshotName + ".png";
			try {
				byte[] screenshot = ((TakesScreenshot)Driver.getDriver()).getScreenshotAs(OutputType.BYTES);
				scenario.attach(screenshot, "image/png", "Screenshot");
				FileUtils.copyFile(((TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.FILE),
						new File(screenshotPath));
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		Driver.quitDriver();
	}
}

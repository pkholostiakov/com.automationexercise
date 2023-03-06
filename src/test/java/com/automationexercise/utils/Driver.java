package com.automationexercise.utils;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Driver {

	public static WebDriver driver;

	private Driver() {}

	public static WebDriver getDriver() {
		if(driver == null) {
		String browser = ConfigReader.getProperty("browser");
        boolean headless = Boolean.parseBoolean(ConfigReader.getProperty("headless"));
        int pageLoadTime = Integer.parseInt(ConfigReader.getProperty("pageLoadTime"));
        int implicitWait = Integer.parseInt(ConfigReader.getProperty("implicitWait"));

        if (browser.trim().equalsIgnoreCase("chrome")) {
            ChromeOptions options = new ChromeOptions();
            if(ConfigReader.getProperty("headless").equals("true"))
            	options.addArguments("--headless");
            options.addArguments("--disable-gpu");
            options.addArguments("user-data-dir=C:\\Users\\pavel\\AppData\\Local\\Google\\Chrome\\User Data\\Profile 1");
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver(options);
        } else if (browser.trim().equalsIgnoreCase("edge")) {
        	EdgeOptions options = new EdgeOptions();
        	options.setCapability("headless", headless);
            WebDriverManager.edgedriver().setup();
            driver = new EdgeDriver();
        }else{
            throw new RuntimeException("NO DRIVER FOUND");
        }
        driver.manage().timeouts().pageLoadTimeout(pageLoadTime, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(implicitWait, TimeUnit.SECONDS);
        driver.manage().window().maximize();
		}
        return driver;
    }

    public static void quitDriver(){
        if(driver!=null){
            driver.quit();
            driver=null;
        }
    }
}

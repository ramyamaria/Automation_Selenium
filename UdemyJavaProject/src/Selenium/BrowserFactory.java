package Selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public  class BrowserFactory {
	
	public static WebDriver getDriver() {
	
		System.setProperty("webdriver.chrome.driver", "C:\\Webdrivers\\chromedriver.exe");
	    WebDriver driver =new ChromeDriver();
	    
	    return driver;
	}
	
	public static void openApplication(WebDriver driver) {
		
	
	driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
	}
	
	public static void quitDriver(WebDriver driver) {
		driver.quit();
		
	}
	
}

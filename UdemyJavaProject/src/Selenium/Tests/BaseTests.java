package Selenium.Tests;
import Selenium.BrowserFactory;
import org.testng.annotations.BeforeTest;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;

public class BaseTests {
	public WebDriver driver;
	
	  
  @BeforeTest
  public void setUp() {
	  System.out.println("beforeTest() method is executed");
	  driver = BrowserFactory.getDriver();
      BrowserFactory.openApplication(driver);
   }
  @AfterTest
  public void afterTest() {
	  BrowserFactory.quitDriver(driver);
  }

}

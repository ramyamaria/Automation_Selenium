import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Selenium {

	public static void main(String[] args) {
		System.setProperty("webdriver.gecko.driver","C:\\Webdrivers\\geckodriver.exe" );
		WebDriver driver= new FirefoxDriver();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
		String tittle= driver.getTitle();
		System.out.println(tittle);
		System.out.println(driver.getCurrentUrl());
		//driver.close();
		//driver.quit();

	}

}

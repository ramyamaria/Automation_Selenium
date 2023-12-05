package Selenium;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class PageMapClass {

	private WebDriver driver;

	public PageMapClass(WebDriver driver) {
		this.driver = driver;
	}

	public void clickRadioButton(String value) {

		try {
			WebElement radio = driver
					.findElement(By.xpath("//div[@id='radio-btn-example']//label//input[@value='radio1']"));
			radio.click();
		} catch (Exception e) {
			System.out.println("No such value for radio Button" + value);

		}

	}

	public void selectAutoSugDropDown(String country) {
		try {
			WebElement dropdown = driver.findElement(By.id("autosuggest"));
			dropdown.sendKeys(country);
			List<WebElement> lists = driver.findElements(
					By.xpath("//ul[@id=\"ui-id-1\"]//li[@class=\"ui-menu-item\"]/a[@class=\"ui-corner-all\"]"));
			if (lists.size() != 0) {
				for (WebElement list : lists) {
					String textValue = list.getText();
					System.out.println(textValue);
					if (textValue.equalsIgnoreCase(country)) {
						list.click();
						break;
					}
				}
			} else {
				System.out.println("No elements returned");
			}

		} catch (Exception e) {
			System.out.println("No such value for radio Button" + country);

		}

	}

	public void selectCheckBox() {

		WebElement checkBox = driver.findElement(By.xpath("//input[@id=\"ctl00_mainContent_chk_friendsandfamily\"]"));
		if (checkBox.isSelected()) {
			System.out.println("Dropdown is already Selected");
		} else {
			checkBox.click();
		}

	}

	public void alert() {
		WebElement text = driver.findElement(By.id("WebElement"));
		text.sendKeys("Ramya");
		WebElement button = driver.findElement(By.id("alertbtn"));
		button.click();
		String atertMessage = driver.switchTo().alert().getText();
		Assert.assertEquals(atertMessage, "Hello Ramya Rajan, share this practice page and share your knowledge");
		driver.switchTo().alert();
	}

	public void addToCart(String text[]) {

		List<WebElement> products = driver.findElements(By.cssSelector("div .product h4.product-name"));
		List<WebElement> buttons = driver.findElements(By.xpath("//button[text()='ADD TO CART']"));

		List<String> requiredProducts = Arrays.asList(text);

		for (int i = 0; i < products.size(); i++) {
			String productName = products.get(i).getText();

			if (requiredProducts.contains(productName)) {

				buttons.get(i).click();
			}
		}
		
	}
	
	public void windowHandler() {
		WebElement button = driver.findElement(By.xpath("//a[text()='Click Here']"));
		button.click();
		Set<String>handles= driver.getWindowHandles();
		Iterator<String> it=handles.iterator();
		
		String parentHandle = it.next();
		String childHandle=it.next();
		
		driver.switchTo().window(childHandle);
		String text=driver.findElement(By.xpath("//div/h3")).getText();
		Assert.assertEquals("New Window", text);
		driver.switchTo().window(parentHandle);
	
	}
	
	public void checkLinks() {
		List<String> tittlename = null;
		List<WebElement> elements = driver.findElements(By.xpath("//div[@id='gf-BIG']//table//td[1]//a"));
		for (WebElement list : elements) {
			list.sendKeys(Keys.chord(Keys.CONTROL,Keys.ENTER));
			Set<String> windows=driver.getWindowHandles();
		    Iterator< String> it= windows.iterator();
		    while(it.hasNext()) {
		    driver.switchTo().window(it.next());
		    System.out.println(driver.getTitle());
		    tittlename.add(driver.getTitle());
		    }
		 
		}
	}
}
package Selenium;

import org.openqa.selenium.WebDriver;

public class PageMainClass {
	
	public PageMapClass mapclass;
	
	public PageMainClass(WebDriver driver) {
		this.mapclass = new PageMapClass(driver);
	}
	
	public void selectRadioButton(String value) {
		mapclass.clickRadioButton(value);	
		
	}
	public void selectAutoDropdown()
	{
		mapclass.selectAutoSugDropDown("India");
	}

}
 
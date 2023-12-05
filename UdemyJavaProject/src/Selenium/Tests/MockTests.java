package Selenium.Tests;

import org.testng.annotations.Test;

import Selenium.PageMainClass;

public class MockTests extends BaseTests{
	
	public PageMainClass mainCLass;
	
	public MockTests() {
			
	  }
	
@Test
  public void verifyFirstSection() {
	  mainCLass = new PageMainClass(driver);
	  mainCLass.selectRadioButton(" Radio1");  
	  //mainCLass.selectAutoDropdown();
	  
  }
}

package com.example.tests;

import com.thoughtworks.selenium.Selenium;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.WebDriver;
import com.thoughtworks.selenium.webdriven.WebDriverBackedSelenium;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import java.util.regex.Pattern;
import static org.apache.commons.lang3.StringUtils.join;

public class Sub_User_Creation_WDBacked {
	private Selenium selenium;

	@Before
	public void setUp() throws Exception {
		WebDriver driver = new FirefoxDriver();
		String baseUrl = "http://nzdev/cgi/main";
		selenium = new WebDriverBackedSelenium(driver, baseUrl);
	}

	@Test
	public void testSub_User_Creation_WDBacked() throws Exception {
		selenium.open("/cgi/main");
		selenium.type("id=username", "kashifi");
		selenium.type("id=password", "Equifax@01");
		selenium.click("id=saveForm");
		selenium.waitForPageToLoad("30000");
		selenium.selectFrame("Work_Area");
		assertEquals("Equifax Release Update", selenium.getText("css=div.release"));
		selenium.selectWindow("name=Contents");
		selenium.click("link=User Administration");
		selenium.selectWindow("name=Work_Area");
		Thread.sleep(NaN);
		selenium.click("Link=Click here to add a new user");
		selenium.waitForPageToLoad("30000");
		selenium.type("id=operatorid", "auto06");
		selenium.type("name=username", "auto06");
		selenium.type("id=internetid", "auto06");
		selenium.type("id=emailaddress", "automation@veda.co.nz");
		selenium.type("id=password", "Equifax@01");
		selenium.type("name=notes", "Automation User");
		selenium.click("css=input[type=\"submit\"]");
		selenium.waitForPageToLoad("30000");
		assertTrue(selenium.isElementPresent("id=easyNotification"));
		assertEquals("User auto06 has been added to account 17557. X", selenium.getText("id=easyNotification"));
	}

	@After
	public void tearDown() throws Exception {
		selenium.stop();
	}
}

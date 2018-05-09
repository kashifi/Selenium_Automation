package com.example.tests;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class SubUserCreationJUnit4 {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  @Before
  public void setUp() throws Exception {
    driver = new FirefoxDriver();
    baseUrl = "http://nzdev/cgi/main";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test
  public void testSubUserCreationJUnit4() throws Exception {
    driver.get(baseUrl + "/cgi/main");
    driver.findElement(By.id("username")).clear();
    driver.findElement(By.id("username")).sendKeys("kashifi");
    driver.findElement(By.id("password")).clear();
    driver.findElement(By.id("password")).sendKeys("Equifax@01");
    driver.findElement(By.id("saveForm")).click();
    // ERROR: Caught exception [ERROR: Unsupported command [selectFrame | Work_Area | ]]
    assertEquals("Equifax Release Update", driver.findElement(By.cssSelector("div.release")).getText());
    // ERROR: Caught exception [ERROR: Unsupported command [selectWindow | name=Contents | ]]
    driver.findElement(By.linkText("User Administration")).click();
    // ERROR: Caught exception [ERROR: Unsupported command [selectWindow | name=Work_Area | ]]
    driver.findElement(By.linkText("Click here to add a new user")).click();
    driver.findElement(By.id("operatorid")).clear();
    driver.findElement(By.id("operatorid")).sendKeys("auto06");
    driver.findElement(By.name("username")).clear();
    driver.findElement(By.name("username")).sendKeys("auto06");
    driver.findElement(By.id("internetid")).clear();
    driver.findElement(By.id("internetid")).sendKeys("auto06");
    driver.findElement(By.id("emailaddress")).clear();
    driver.findElement(By.id("emailaddress")).sendKeys("automation@veda.co.nz");
    driver.findElement(By.id("password")).clear();
    driver.findElement(By.id("password")).sendKeys("Equifax@01");
    driver.findElement(By.name("notes")).clear();
    driver.findElement(By.name("notes")).sendKeys("Automation User");
    driver.findElement(By.cssSelector("input[type=\"submit\"]")).click();
    assertTrue(isElementPresent(By.id("easyNotification")));
    assertEquals("User auto06 has been added to account 17557. X", driver.findElement(By.id("easyNotification")).getText());
  }

  @After
  public void tearDown() throws Exception {
    driver.quit();
    String verificationErrorString = verificationErrors.toString();
    if (!"".equals(verificationErrorString)) {
      fail(verificationErrorString);
    }
  }

  private boolean isElementPresent(By by) {
    try {
      driver.findElement(by);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }

  private boolean isAlertPresent() {
    try {
      driver.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }

  private String closeAlertAndGetItsText() {
    try {
      Alert alert = driver.switchTo().alert();
      String alertText = alert.getText();
      if (acceptNextAlert) {
        alert.accept();
      } else {
        alert.dismiss();
      }
      return alertText;
    } finally {
      acceptNextAlert = true;
    }
  }
}

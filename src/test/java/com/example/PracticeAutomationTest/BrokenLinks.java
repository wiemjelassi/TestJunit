package com.example.PracticeAutomationTest;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
import org.apache.commons.io.FileUtils;
import java.io.File;
import java.time.Duration;

public class BrokenLinks {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();
  JavascriptExecutor js;
  @Before
  
  public void setUp() throws Exception {

		 System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\Java\\chromedriver.exe");
		    
		   ChromeOptions options = new ChromeOptions();
		   options.addArguments("start-maximized");
		   options.addArguments("--remote-allow-origins=*");
		    driver = new ChromeDriver(options);

		    baseUrl = "https://practice-automation.com/";
		    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		    js = (JavascriptExecutor) driver;
		  }


  @Test
  
  public void testBrokenLinks() {
      driver.get(baseUrl);
      JavascriptExecutor js = (JavascriptExecutor) driver;
      WebElement brokenLinksLink = driver.findElement(By.linkText("Broken Links"));
      js.executeScript("arguments[0].scrollIntoView(true);", brokenLinksLink);
      brokenLinksLink.click();
    //  driver.findElement(By.linkText("Broken Links")).click();
  
  
      // Vérification du titre de la page
      WebElement titleElement = driver.findElement(By.xpath("//div[@id='top-wrap']/section/div/h1"));
      assertEquals("Broken Links", titleElement.getText());

      // Vérification du lien cassé
      WebElement brokenLinkCell = driver.findElement(By.xpath("//article[@id='post-1267']/div/figure/table/tbody/tr/td"));
      assertEquals("missing-page.html", brokenLinkCell.getText());

      // Vérification du code de réponse HTTP attendu
      WebElement httpCodeCell = driver.findElement(By.xpath("//article[@id='post-1267']/div/figure/table/tbody/tr/td[2]"));
      assertEquals("404", httpCodeCell.getText());

      // Vérification du texte explicatif
      WebElement explanationText = driver.findElement(By.xpath("//article[@id='post-1267']/div/p[2]"));
      assertTrue(explanationText.getText().contains("In an ideal scenario a website should have no broken links"));
  }

  @After
  public void tearDown() throws Exception {
    driver.quit();
    String verificationErrorString = verificationErrors.toString();
    if (!"".equals(verificationErrorString)) {
      fail(verificationErrorString);
    }
  }


}

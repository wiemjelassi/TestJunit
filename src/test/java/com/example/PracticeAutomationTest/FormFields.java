package com.example.PracticeAutomationTest;

import org.junit.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import java.time.Duration;

public class FormFields {
    private WebDriver driver;
    private WebDriverWait wait;
    private String baseUrl;
    private JavascriptExecutor js;
    FromFieldsPage formFields; 
    private StringBuilder verificationErrors = new StringBuilder(); // Ajout de verificationErrors

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\Java\\chromedriver.exe");

        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        wait = new WebDriverWait(driver, Duration.ofSeconds(30)); // Utilisation d'une attente explicite

        baseUrl = "https://practice-automation.com/";
        js = (JavascriptExecutor) driver;

        formFields = new FromFieldsPage(driver); // Correction du nom de la variable
    }
    @Test
    public void testFormFields() throws Exception {
        driver.get("https://practice-automation.com/form-fields/");
        
        // Vérification du titre de la page
        assertEquals("Form Fields", formFields.getPageTitle().getText());
        
        // Vérification de la présence et du texte des champs
        assertEquals("Name",formFields.getNameInput().getText());
        
        
        formFields.getNameInput().clear();
        formFields.getNameInput().sendKeys("wiem");
        assertEquals("wiem", formFields.getNameInput().getAttribute("value"));
        
        
        assertEquals("Password", formFields.getPasswordInput().getText());
        
        formFields.getPasswordInput().clear();
        formFields.getPasswordInput().sendKeys("jelassi");
        assertEquals("jelassi", formFields.getPasswordInput().getAttribute("value"));
        
        assertTrue(driver.findElement(By.xpath("//form[@id='feedbackForm']/label[3]")).getText().matches("^What is your favorite drink[\\s\\S]$"));
        
        formFields.getFavoriteDrink().click();
        
        assertTrue(driver.findElement(By.xpath("//form[@id='feedbackForm']/label[9]")).getText().matches("^What is your favorite color[\\s\\S]$"));
        
        formFields.getFavoriteColor().click();
        
        assertTrue(driver.findElement(By.xpath("//form[@id='feedbackForm']/label[15]")).getText().matches("^Do you like automation[\\s\\S]$"));
        
        new Select(formFields.getAutomationDropdown()).selectByVisibleText("Yes");
        
        assertEquals("Email", driver.findElement(By.xpath("//form[@id='feedbackForm']/label[17]")).getText());
        
        formFields.getEmailInput().clear();
        formFields.getEmailInput().sendKeys("wiemjelassi12@gmail.com");
        assertEquals("wiemjelassi12@gmail.com", formFields.getEmailInput().getAttribute("value"));
        
        assertEquals("Message", driver.findElement(By.xpath("//form[@id='feedbackForm']/label[18]")).getText());
        
        driver.findElement(By.id("message")).clear();
        driver.findElement(By.id("message")).sendKeys("bonjour");
        assertEquals("bonjour", driver.findElement(By.id("message")).getAttribute("value"));
        
        assertEquals("Submit", formFields.getSubmitButton().getText());
        
        formFields.getSubmitButton().click();
        assertEquals("Message received!", closeAlertAndGetItsText());
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
    		        alert.accept();
    		        return alertText;
    		    } catch (NoAlertPresentException e) {
    		        return "No alert present";
    		    }
    		}
    	}

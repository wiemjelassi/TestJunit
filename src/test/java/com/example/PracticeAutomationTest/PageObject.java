package com.example.PracticeAutomationTest;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.bidi.log.Log;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
public class PageObject {
	protected WebDriver driver;
	   public Logger log;
	   protected WebDriverWait wait;
	  
	   Actions action;
	    public PageObject(WebDriver driver){
	        this.driver = driver;
	        PageFactory.initElements(driver, this);
	        log = Logger.getLogger(Log.class.getName());
		    log.setLevel(Level.INFO);
		    // wait=new WebDriverWait(driver, Duration.ofSeconds(20) );
	        action=new Actions(driver);
	   
	    }
}

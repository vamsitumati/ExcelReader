package com.automation.facebookPage.FacebookMaven;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.gargoylesoftware.htmlunit.ElementNotFoundException;
import com.google.common.base.Function;

public class WebDriverFactory {
	private static WebDriver driver= null;
	//private static final String HOTEL= "https://www.hotels.com/";
	private static final String FB ="https://www.facebook.com/";
	public static WebDriver getDriver() {
		return driver;
	}
	public void setDriver(WebDriver driver) {
		WebDriverFactory.driver = driver;
	}
	
	@BeforeClass
	
	public void webDriverInitialization(){
		System.setProperty("webdriver.chrome.driver", "C://Selenium//chromedriver.exe");
		driver= new ChromeDriver();
		/*System.setProperty("webdriver.gecko.driver", "C://Selenium//geckodriver.exe");
		driver= new FirefoxDriver();*/
		
		driver.get(FB);
		driver.manage().window().maximize();
		driver.navigate().back();
	}
    
	@AfterClass
	public void browserClose(){
		if(driver != null) {
            driver.manage().deleteAllCookies();
		    driver.close();
		}
	}
	 public static WebElement webDriverFluentWait(final By locator) {
	        Wait<WebDriver> wait = new FluentWait<WebDriver>(getDriver())
	                .withTimeout(10, TimeUnit.SECONDS)
	                .pollingEvery(1, TimeUnit.SECONDS)
	                .ignoring(NoSuchElementException.class)
	                .ignoring(StaleElementReferenceException.class)
	                .ignoring(ElementNotFoundException.class)
	                .ignoring(WebDriverException.class)
	                .withMessage(
	                        "Webdriver waited for 15 seconds but still could not find the element therefore Timeout Exception has been thrown: " + locator.toString());

	        WebElement element = wait.until(new Function<WebDriver, WebElement>() {
	            public WebElement apply(WebDriver driver) {
	                return driver.findElement(locator);
	            }
	        });

	        return element;
	    }
	public static void switchToWindow(int index) {
		List<String> list = new ArrayList<String>(getDriver().getWindowHandles());
		getDriver().switchTo().window(list.get(index));
	}

	public static void switchToRootCloseCurrent() {
		List<String> list = new ArrayList<String>(getDriver().getWindowHandles());
		for (int i = 1; i < list.size(); i++) {
			getDriver().switchTo().window(list.get(i));
			getDriver().close();
		}
		getDriver().switchTo().window(list.get(0));
	}
	
	public static String tomarrowDate()
	{
		Calendar calendar = Calendar.getInstance();
		Date today = calendar.getTime();
		
		calendar.add(Calendar.DATE, 1);
		Date tomorrow = calendar.getTime();
		DateFormat formatter = new SimpleDateFormat("MM/dd/YY");
		String tomarrowstring = formatter.format(tomorrow);
		System.out.println(tomarrowstring);
		return tomarrowstring;
	}
	public static String afterSevendayDate()
	{
		Calendar cal = Calendar.getInstance();
		Date today1 = cal.getTime();
		cal.add(Calendar.DATE, 8);
		Date aftersevendays = cal.getTime();
		DateFormat formatter = new SimpleDateFormat("MM/dd/YY");
		String seven = formatter.format(aftersevendays);
		System.out.println(seven);
		return seven;
	}
	

}

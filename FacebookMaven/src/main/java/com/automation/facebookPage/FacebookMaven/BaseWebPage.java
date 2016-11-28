package com.automation.facebookPage.FacebookMaven;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import com.google.common.base.Function;


public class BaseWebPage extends WebDriverFactory{

    /**
     * Waits for element for 15 seconds
     * @param locator
     * @return
     */
    public static WebElement webDriverFluentWait(final By locator) {
        Wait<WebDriver> wait = new FluentWait<WebDriver>(WebDriverFactory.getDriver())
                .withTimeout(15, TimeUnit.SECONDS)
                .pollingEvery(500, TimeUnit.MILLISECONDS)
                .ignoring(NoSuchElementException.class)
                .withMessage("Webdriver waited for 15 seconds but still could not find the element therefore Timeout Exception has been thrown");

        WebElement element = wait.until(new Function<WebDriver, WebElement>() {
            public WebElement apply(WebDriver driver) {
                return driver.findElement(locator);
            }
        });

        return element;
    }
    
    /**
     * Click on elements using By locator object 
     * @param locator
     */
    public void clickOn(By locator) {
        webDriverFluentWait(locator).click();
    }

    /**
     * Sendkeys to text field
     * @param locator
     * @param sendKey
     */
    public void sendKeys(By locator, String sendKey) {
        webDriverFluentWait(locator).sendKeys(sendKey);
    }
    
    public  void screen(String filename){
		try {
			
			TakesScreenshot ts=(TakesScreenshot)getDriver();
			File src = ts.getScreenshotAs(OutputType.FILE);
			
			String timeStamp = new SimpleDateFormat("MM_dd_yyyy HH_mm_ss").format(Calendar.getInstance().getTime());
			FileUtils.copyFile(src, new File( "./ScreenshotsStore/"+timeStamp + filename+".png"));
			
		} catch (IOException e) {
			
		System.out.println("Exception during screenshot capturing" +e.getMessage());
		} 
		}
}

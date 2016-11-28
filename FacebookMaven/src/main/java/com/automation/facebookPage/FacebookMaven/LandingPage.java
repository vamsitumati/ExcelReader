package com.automation.facebookPage.FacebookMaven;



import org.openqa.selenium.By;

import com.automation.facebookPage.FacebookMaven.BaseWebPage;
import ru.yandex.qatools.allure.annotations.Step;

public class LandingPage extends BaseWebPage{

    private By username = By.id("email");
    private By password = By.id("pass");
    private By loginButton = By.id("loginbutton");
    
    
    @Step("Enter username")
    public void enterUsername(String enterUsername) {
        sendKeys(username, enterUsername);
    }
    
    @Step("Enter Password")
    public void enterPassword(String enterPasword) {
        sendKeys(password, enterPasword);
    }
    
    @Step("Click on login button")
    public void clickOnLoginButton() {
        clickOn(loginButton);
    }
}
package com.automation.facebookPage.FacebookMaven;

import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Features;

public class LoginPageTest extends WebDriverFactory {
	
	@Test
	@Features("This is login page")
	public void login()
	{
		System.out.println("Test Me");
	}

}

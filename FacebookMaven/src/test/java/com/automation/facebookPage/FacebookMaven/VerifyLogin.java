package com.automation.facebookPage.FacebookMaven;

import org.testng.annotations.Test;

public class VerifyLogin extends WebDriverFactory {
	private LandingPage landingPage = new LandingPage();
	private BaseWebPage baseWebPage = new BaseWebPage();
	
	@Test
	public void verifyInvalidLogin(){
		landingPage.enterUsername("vamsitumati@gmail.com");
		landingPage.enterPassword("654321");
		landingPage.clickOnLoginButton();
		baseWebPage.screen("screenshot");
	}

}

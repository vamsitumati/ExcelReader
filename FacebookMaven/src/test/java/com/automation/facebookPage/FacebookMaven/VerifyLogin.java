package com.automation.facebookPage.FacebookMaven;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class VerifyLogin extends WebDriverFactory {
	private LandingPage landingPage = new LandingPage();
	private BaseWebPage baseWebPage = new BaseWebPage();
	
	@Test(dataProvider="multi-credentials")
	public void verifyInvalidLogin(String username, String password){
		landingPage.enterUsername(username);
		landingPage.enterPassword(password);
		landingPage.clickOnLoginButton();
		baseWebPage.screen("screenshot");
		
	}
	
	@DataProvider(name="multi-credentials")
	public Object[][] passData(){	
		Object[][] data = new Object[3][2];
		data[0][0]="vamsi";
		data[0][1]="123";
		data[1][0]="tumati";
		data[1][1]="321";
		data[2][0]="vamsi.tumati";
		data[2][1]="4321";
		
		return data;
		
	}
	

}

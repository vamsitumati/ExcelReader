package com.automation.facebookPage.FacebookMaven;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ExcelSheetReader  {
	
	private LandingPage landingPage = new LandingPage();
	private BaseWebPage baseWebPage = new BaseWebPage();
	private ExcelLib lib = new ExcelLib();
	@Test(dataProvider="multi-credentials")
	public void verifyLogin(String username, String password)
	{
		
			landingPage.enterUsername(username);
			landingPage.enterPassword(password);
			landingPage.clickOnLoginButton();
			baseWebPage.screen("screenshot");
	}
	
	@DataProvider(name="multi-credentials")
	public Object[][] passData(){
        lib.excelLib("C://Selenium//ExcelSheet.xlsx");
		int rows = lib.getRowCount(0);
	    
    	Object[][] data = new Object[rows][3];
    	for(int i=0;i<rows;i++){
    		data[i][0]=lib.getdata(0, i, 0);
    		data[i][1] = lib.getdata(0, i, 1);
    		data[i][2] = lib.getdata(0, i, 2);
    	}  
    	return data;
		
	
	}

}

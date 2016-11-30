package com.automation.facebookPage.FacebookMaven;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


public class dataProvider {
	@Test(dataProvider="multi-param")
    public void multiParameter(String a, int i, long l, boolean b) {
        System.out.println("String: " + a + ", int: " + i + ", long: " + l + ", boolean: " + b);
    }
     
    @DataProvider(name="multi-param")
    public Object[][] dpMultiParam() {
        return new Object[][]{
                {"a", 1, 10L, true},
                {"b", 2, 20L, false},
                {"c", 3, 30L, true},
                {"d", 4, 40L, false}};
    }
	
	
}

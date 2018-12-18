package com.selenium.testcase;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.selenium.Base.TestBase;

public class BankmanagerLoginTest extends TestBase 
{
	@Test
	public void bankmangerLoginTest(){
		
		click("bmlBtn_CSS");
		Assert.assertTrue(isElementPresent(By.cssSelector(OR.getProperty("addCustBtn_CSS"))),"Login Not Success");
		//log.debug("Login Success");
	}
	
	

}

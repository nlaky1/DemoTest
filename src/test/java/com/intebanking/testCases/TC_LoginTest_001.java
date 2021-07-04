package com.intebanking.testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.inetbanking.pageObjects.LoginPage;

public class TC_LoginTest_001 extends BaseClass {

	
	@Test
	public void loginTest() throws InterruptedException, IOException {
		
		driver.manage().window().maximize();		
		logger.info("Maximised");
		
		Thread.sleep(3000);
		LoginPage lp=new LoginPage(driver);
		lp.setUserName(username);
		logger.info("Entered username");
		Thread.sleep(3000);
		
		lp.setPassword(password);
		logger.info("Entered password");
		Thread.sleep(3000);
		lp.clickSubmit();
		
		if(driver.getTitle().equals("Guru99 Bank Manager HomePage"))
		{
			Assert.assertTrue(true);
			logger.info("Login test passed");
		}
		else
		{
			captureScreen(driver, "loginTest");
			Assert.assertTrue(false);
			logger.info("Login test failed");
		}
				
		
	}
	
}

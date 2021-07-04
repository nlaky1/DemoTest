package com.intebanking.testCases;

import java.io.IOException;

import org.apache.commons.lang3.RandomStringUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.inetbanking.pageObjects.AddCustomerPage;
import com.inetbanking.pageObjects.LoginPage;

public class TC_AddCustomerTest_003 extends BaseClass{
	
	@Test
	public void addNewCustomer() throws InterruptedException, IOException {
		LoginPage lp = new LoginPage(driver);
		
		lp.setUserName(username);
		logger.info("User name is provided");
		lp.setPassword(password);
		logger.info("Passsword is provided");
		lp.clickSubmit();
		Thread.sleep(3000);
		
		AddCustomerPage addcust = new AddCustomerPage(driver);
		
		addcust.clickAddNewCustomer();
		
		addcust.custName("Nikhil");
		addcust.custgender("Male");
		addcust.custdob("11", "19", "1990");
		Thread.sleep(3000);
		
		logger.info("providing customer details....");
		addcust.custaddress("India");
		addcust.custcity("India");
		addcust.custstate("MP");
		addcust.custpinno("452010");
		addcust.custtelephoneno("8120237855");
		addcust.custemailid(randomString()+"@gmail.com");
		addcust.custpassword("abcdef");
		addcust.custsubmit();
		Thread.sleep(3000);
		logger.info("validation started....");
		
		boolean res =driver.getPageSource().contains("Customer Registered Successfully!!!");
		
		if(res==true) {
			Assert.assertTrue(true);		
			logger.info("test case passed....");
		}
		else {
			logger.info("test case failed....");
			captureScreen(driver, "addNewCustomer");
			Assert.assertTrue(false);			
		}
	}
	
	

}

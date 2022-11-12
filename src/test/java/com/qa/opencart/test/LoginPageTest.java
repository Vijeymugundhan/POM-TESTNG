package com.qa.opencart.test;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.opencart.base.BaseTest;
import com.qa.opencart.constants.Appconstant;


public class LoginPageTest extends BaseTest 
{
	
	@Test(priority=1)
	public void loginPageTitleTest()
	{
		
		String actualTitle=loginPage.getLoginPageTitle();// here we use inhertitance 
		Assert.assertEquals(actualTitle, Appconstant.LOGIN_PAGE_TITLE);
		
	}
	
	@Test(priority=2)
	public void loginPageUrlTest ()
	{
		Assert.assertTrue(loginPage.getLoginPageUrl());
		
	}
	
	@Test(priority=3)
	public void isForgotPwdLinkExistTest()
	{
		Assert.assertTrue(loginPage.isForgotPwdLinkExist());
		//or
		//Assert.assertEquals(loginPage.isForgotPwdLinkExist(), true);
		// boolean assertion can be done in the both ways.
		 
	}
	
	@Test(priority=4)
	public void loginTest()
	{
		accPage=loginPage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
		Assert.assertTrue(accPage.isLogoutLinkExist());
		
	}
	
	
	
	

}

package com.qa.opencart.test;

import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.opencart.base.BaseTest;
import com.qa.opencart.constants.Appconstant;
import com.qa.opencart.utils.ElementUtil;
import com.qa.opencart.utils.ExcelUtil;


public class RegisterTest extends BaseTest
{
	
	
	
	@BeforeClass
	public void regSetup()
	{
		registerPage=loginPage.navigateToRegisterPage();
	}
	
	
	public String getRandomEmail()
	{
		Random random=new Random();
		String email="automationtest"+random.nextInt(10000)+"@gmail.com";
		return email;
	}
	
	@DataProvider
	public Object[][] getRegTestData()
	{
		Object regData[][]=ExcelUtil.getTestData(Appconstant.REGISTER_SHEET_NAME);
		return regData;
	}
	
	
	
//	@Test()
//	public void registerUserTest(String firstname,String lastname,String email,String telephoe,String passsword,String subscribe)
//	{
//		String actual=registerPage.userRegister("aarthi","sharma","arthi@gmail.com", "98765455678","aarthi123", "yes");
//		Assert.assertEquals(actual, Appconstant.ACC_CREATE_SUCC_MESSG);
//	}
	
	

	
	
	@Test(dataProvider = "getRegTestData")
	public void registerUserTest(String firstname,String lastname,String telephone,String passsword,String subscribe)
	{
		String actual=registerPage.userRegister(firstname,lastname,getRandomEmail(),telephone,passsword,subscribe);
		Assert.assertEquals(actual, Appconstant.ACC_CREATE_SUCC_MESSG);
	}
	
	

}

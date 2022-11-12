package com.qa.opencart.pages;

import org.apache.log4j.Logger;
import org.bouncycastle.math.ec.ScaleYPointMap;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.opencart.constants.Appconstant;
import com.qa.opencart.factory.DriverFactory;
import com.qa.opencart.utils.ElementUtil;

public class A_LoginPage 
{
	private WebDriver driver;
	private ElementUtil eleUtil;
	
	private By emailId=By.id("input-email");
	private By password=By.id("input-password");
	private By loginBtn=By.xpath("//input[@type='submit']");
	private By logo=By.xpath("//img[@title='naveenopencart']");
	private By forgotPwdLink=By.linkText("Forgotten Password");
	private By registerLink=By.linkText("Register");
	
	private static final Logger LOG=Logger.getLogger(A_LoginPage.class);
	
	public A_LoginPage(WebDriver driver)
	{
		this.driver=driver;// this is encapsulation
		eleUtil=new ElementUtil(driver);
	}
	
	
	public String getLoginPageTitle()
	{
		String Title=eleUtil.waitForTitleIs(Appconstant.DEFAULT_TIME_OUT, Appconstant.LOGIN_PAGE_TITLE);
		System.out.println("login page title :" +Title);
		LOG.info("login page title :" +Title);
		return Title;
		
//		String title=driver.getTitle();
//		System.out.println("login page title :" +title);
//		return title;
	}
	
	public boolean getLoginPageUrl()
	{
		String url=eleUtil.waitForUrlContains(Appconstant.DEFAULT_TIME_OUT,Appconstant.LOGIN_PAGE_URL_PARAM);
		System.out.println("login page url :" + url);
		LOG.info("login page url :" + url);
		if(url.contains(Appconstant.LOGIN_PAGE_URL_PARAM))
		{
			return true;
		}
		return false;
		
		
		
		
		
//		String url=driver.getCurrentUrl();
//		System.out.println("login page url :" + url);
//		if(url.contains(Appconstant.LOGIN_PAGE_URL_PARAM))
//		{
//			return true;
//		}
//		return false;
	}
	
	public boolean isForgotPwdLinkExist()
	{
		return eleUtil.doEleIsDisplayed(forgotPwdLink);
		
		//return driver.findElement(forgotPwdLink).isDisplayed();
	}
	
	public B_AccountsPage doLogin(String username,String Pwd)
	{
		System.out.println("user creds are :" +username + "  "+Pwd);
		LOG.info("user creds are :" +username + "  "+Pwd);
		eleUtil.doSendKeysWithWait(emailId, Appconstant.DEFAULT_LARGE_TIME_OUT, username);
		eleUtil.doSendKeysWithWait(password, Appconstant.DEFAULT_LARGE_TIME_OUT, Pwd);
		//eleUtil.doSendKeys(password, Pwd);
		eleUtil.doClick(loginBtn);
		return new B_AccountsPage(driver);
		
		
		
//		System.out.println("user creds are :" +username + "  "+Pwd);
//		driver.findElement(emailId).sendKeys(username);
//		driver.findElement(password).sendKeys(Pwd);
//		driver.findElement(loginBtn).click();
//		return new B_AccountsPage(driver);
	}
	
	public RegisterPage navigateToRegisterPage()
	{
		System.out.println("navigating to regisgter page");
		LOG.info("navigating to regisgter page");
		eleUtil.doClick(registerLink);
		return new RegisterPage(driver);
	}
	
	

}

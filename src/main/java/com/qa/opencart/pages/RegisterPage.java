package com.qa.opencart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.opencart.constants.Appconstant;
import com.qa.opencart.utils.ElementUtil;

public class RegisterPage 
{
	private WebDriver driver;
	private ElementUtil eleUtil;
	
	private By firstName = By.id("input-firstname");
	private By lastName=By.id("input-lastname");
	private By email=By.id("input-email");
	private By telephone=By.id("input-telephone");
	private By password=By.id("input-password");
	private By confirmpassword=By.id("input-confirm");
	private By agreeCheckBox=By.xpath("//input[@type='checkbox']");
	private By continueButton=By.xpath("//input[@value=\"Continue\"]");
	private By subscribeYes=By.xpath("//label[@class=\"radio-inline\"]//input[@type=\"radio\" and @value=\"1\"]");
	private By subscribeNo=By.xpath("//label[@class=\"radio-inline\"]//input[@type=\"radio\" and @value=\"0\"]");
	
	private By registerSucessMesg=By.cssSelector("div#content h1");
	private By logoutLink= By.linkText("Logout");
	private By registerLink=By.linkText("Register");
	


	public RegisterPage(WebDriver driver) 
	{
		this.driver=driver;
		eleUtil=new ElementUtil(driver);
		
	}


	public String userRegister(String firstName,String lastname,String email,String telephone,String password,String subscribe )
	{
		eleUtil.doSendKeysWithVisibleElement(this.firstName, Appconstant.DEFAULT_TIME_OUT,firstName);
		eleUtil.doSendKeys(this.lastName, lastname);
		eleUtil.doSendKeys(this.email, email);
		eleUtil.doSendKeys(this.telephone, telephone);
		eleUtil.doSendKeys(this.password, password);
		eleUtil.doSendKeys(this.confirmpassword, password);
		
		if(subscribe.equalsIgnoreCase("yes"))
		{
			eleUtil.doClick(subscribeYes);
		}
		else
		{
			eleUtil.doClick(subscribeNo);
		}
		
		eleUtil.doClick(agreeCheckBox);
		eleUtil.doClick(continueButton);
		
		String succMesg=eleUtil.waitForElementVisible(registerSucessMesg, Appconstant.DEFAULT_TIME_OUT).getText();
		System.out.println("Success Message is"+succMesg);
		
		eleUtil.doClick(logoutLink);
		eleUtil.doClick(registerLink);
		return succMesg;
	}

}

package com.qa.opencart.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.opencart.constants.Appconstant;
import com.qa.opencart.utils.ElementUtil;

public class B_AccountsPage 
{
	private WebDriver driver;
	private ElementUtil eleUtil;
	 
	private By logoutLink=By.linkText("Logout");
	private By search=By.name("search");
	private By searchIcon=By.cssSelector(".input-group-btn");
	private By accSecheaders=By.cssSelector("div#content h2");
	
	public B_AccountsPage(WebDriver driver)
	{
		this.driver=driver;
		eleUtil=new ElementUtil(driver);
	}
	
	public String getAccPageTitle()
	{
		String title=eleUtil.waitForTitleIs(Appconstant.DEFAULT_TIME_OUT, Appconstant.ACC_PAGE_TITLE);;
		System.out.println("Account page title :" +title);
		return title;
	}
	public boolean getAccPageUrl()
	{
		String url=eleUtil.waitForUrlContains(Appconstant.DEFAULT_TIME_OUT,Appconstant.ACC_PAGE_URL_PARAM);
		System.out.println("login page url :" + url);
		if(url.contains(Appconstant.ACC_PAGE_URL_PARAM))
		{
			return true;
		}
		return false;
		
		
		
//		String url=driver.getCurrentUrl();
//		System.out.println("Account page url :" + url);
//		if(url.contains(Appconstant.ACC_PAGE_URL_PARAM))
//		{
//			return true;
//		}
//		return false;
		
	}
	
	public boolean isLogoutLinkExist()
	{
		
		return eleUtil.doEleIsDisplayed(logoutLink);
	}
	
	public boolean isSearchExist()
	{
		return eleUtil.doEleIsDisplayed(search);
		
	}
	
	public 	ArrayList<String> getAccSecHeadersList()
	{
		List<WebElement> secList=eleUtil.waitForElementsToBeVisible(accSecheaders,Appconstant.DEFAULT_TIME_OUT );
		
		
		
		System.out.println("total sections headers:" + secList.size());
		ArrayList<String> actsecTextList=new ArrayList<String>();
		for(WebElement e:secList)
		{
			String text=e.getText();
			actsecTextList.add(text);
			
		}
		return actsecTextList;
	}
	
	public SearchResultsPage performSearch(String productKey)
	{
		System.out.println("Product name is : " + productKey);
		if(isSearchExist())
		{
			eleUtil.doSendKeys(search, productKey);
			eleUtil.doClick(searchIcon);
			return new SearchResultsPage(driver);
			
			
		}
		else
		{
			System.out.println("search field is not present on the page");
			return null;
			 
		}
		
	}
	
	
	
	

}

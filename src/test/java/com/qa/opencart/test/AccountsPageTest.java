package com.qa.opencart.test;

import java.util.ArrayList;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.opencart.base.BaseTest;
import com.qa.opencart.constants.Appconstant;

public class AccountsPageTest  extends BaseTest
{
	@BeforeClass
	public void accSetup()
	{
		accPage=loginPage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	@Test
	public void accPageTitleTest()
	{
		String actAccPageTitle=accPage.getAccPageTitle();
		Assert.assertEquals(actAccPageTitle, Appconstant.ACC_PAGE_TITLE);
	}
	
	@Test
	public void accPageUrlTest ()
	{
		Assert.assertTrue(accPage.getAccPageUrl());
		
	}
	
	@Test
	public void searchExistTest()
	{
		Assert.assertTrue(accPage.isSearchExist());
	}
	
	@Test
	public void LogoutLinkExistTest()
	{
		Assert.assertTrue(accPage.isLogoutLinkExist());
	}
	
	@Test
	public void accHeadersTest()
	{
		ArrayList<String> actHeadersList=accPage.getAccSecHeadersList();
		System.out.println("Actual AccPage Headers" + actHeadersList);
		Assert.assertEquals(actHeadersList, Appconstant.ACC_PAGE_SECTIONS_HEADERS);
	}
	
	@DataProvider
	public Object[][] getProductKey()
	{
		return new Object[][]
				{
				{"Macbook"},
				{"Macbook"},
				{"iMac"},
				{"Samsung"}
				};
	}
	
	
	
	
	
	
	@Test(dataProvider = "getProductKey")
	public void searchCheckTest(String productKey)
	{
		searchResultsPage=accPage.performSearch(productKey);
		Assert.assertTrue(searchResultsPage.isSearchSucessful());
	}
	
	@DataProvider
	public Object[][] getProductData()
	{
		return new Object[][]
				{
				{"Macbook","MacBook Pro"},
				{"Macbook","MacBook Air"},
				{"iMac","iMac"},
				{"Samsung","Samsung Galaxy Tab 10.1"}
				};
	}
	
	
	
	@Test(dataProvider = "getProductData")
	public void searchTest(String searchKey,String mainProductName)
	{
		searchResultsPage=accPage.performSearch(searchKey);
		if(searchResultsPage.isSearchSucessful())
		{
			productInfoPage=searchResultsPage.selectProduct(mainProductName);
			String actual=productInfoPage.getProductHeader(mainProductName);
			Assert.assertEquals(actual,mainProductName);
		}
	}
	
	
	

}

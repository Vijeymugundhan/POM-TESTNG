package com.qa.opencart.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.opencart.constants.Appconstant;
import com.qa.opencart.utils.ElementUtil;

public class SearchResultsPage 
{
	private WebDriver driver;
	private ElementUtil eleUtil;
	
	private By productSearchLayout=By.cssSelector("div.product-layout");

	public SearchResultsPage(WebDriver driver)
	{
		this.driver=driver;
		eleUtil= new ElementUtil(driver);
		
	}
	
	public boolean isSearchSucessful()
	{
		List<WebElement> searchList=eleUtil.waitForElementsToBeVisible(productSearchLayout, Appconstant.DEFAULT_TIME_OUT);
		if(searchList.size()>0)
		{
			System.out.println("Search is sucessfully done....");
			return true;
		}
		else
		{
			System.out.println("search is not done");
			return false;
		}
	
	
	}
	
	public ProductInfoPage selectProduct(String mainProductName)
	{
		By mainPrName=By.linkText(mainProductName);
		//eleUtil.doClick(productSearchLayout);
		eleUtil.doClick(mainPrName);
		return new ProductInfoPage(driver);
		
	}
	

}

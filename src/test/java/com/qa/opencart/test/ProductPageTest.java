package com.qa.opencart.test;

import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.opencart.base.BaseTest;
import com.qa.opencart.constants.Appconstant;

public class ProductPageTest extends BaseTest 
{
	@BeforeClass
	public void prodInfoSetup()
	{
		accPage=loginPage.doLogin(prop.getProperty("username"),prop.getProperty("password"));
	}
	
	@DataProvider
	public Object[][] getProductInfoKey()
	{
		return new Object[][]
				{
				{"Macbook","MacBook Pro"},
				{"Macbook","MacBook Air"},
				{"iMac","iMac"},
				};
	}
	
	
	
	@Test(dataProvider ="getProductInfoKey")
	public void productHeaderTest(String product1Key,String product2Key)
	{
		searchResultsPage=accPage.performSearch(product1Key);
		productInfoPage=searchResultsPage.selectProduct(product2Key);
		String actProdHeader=productInfoPage.getProductHeader(product2Key);
		Assert.assertEquals(actProdHeader, product2Key);
	
	}
	
	@DataProvider
	public Object[][] getProductInfoData()
	{
		return new Object[][]
				{
				{"Macbook","MacBook Pro",Appconstant.MACBOOK_PRO_IMAGES_COUNT},
				{"Macbook","MacBook Air",Appconstant.MACBOOK_AIR_IMAGES_COUNT},
				{"iMac","iMac",Appconstant.IMAC_IMAGES_COUNT}
				};
	}
	
	@Test(dataProvider = "getProductInfoData")
	public void productImagesCountTest(String searchKey,String mainProductName,int ImagesCount)
	{
		searchResultsPage=accPage.performSearch(searchKey);
		productInfoPage=searchResultsPage.selectProduct(mainProductName);
		int actProductImages=productInfoPage.getProductImagesCount();
		System.out.println("actual product images :" +actProductImages);
		Assert.assertEquals(actProductImages,ImagesCount);
		
	}
	
	@Test
	public void productMetaDataTest()
	{
		searchResultsPage=accPage.performSearch("Macbook");
		productInfoPage=searchResultsPage.selectProduct("MacBook Pro");
		Map<String,String> actMetaDataMap=productInfoPage.getProductMetaData();
		Assert.assertEquals(actMetaDataMap.get("Brand"), "Apple");
		Assert.assertEquals(actMetaDataMap.get("Product Code"), "Product 18");
		Assert.assertEquals(actMetaDataMap.get("Reward Points"), "800");
		Assert.assertEquals(actMetaDataMap.get("Availability"), "In Stock");
	}

}

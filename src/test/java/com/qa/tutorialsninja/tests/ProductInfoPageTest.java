package com.qa.tutorialsninja.tests;

import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.tutorialsninja.base.BaseTest;
import com.qa.tutorialsninja.utils.Constant;

public class ProductInfoPageTest extends BaseTest {

	@BeforeClass
	public void accountPagesetUp() {

		accountsPage = loginPage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	@Test(priority = 1)
	public void productHeaderTest()
	{
		searchResultPage = accountsPage.doSearch("MacBook");
		productInfopage = searchResultPage.selectproductFromResults("MacBook Pro");
	    Assert.assertEquals(productInfopage.getProductheader(), "MacBook Pro");
	}
	
	
	@Test(priority = 2)
	public void productImagesCountTest()
	{

		searchResultPage = accountsPage.doSearch("iMac");
		productInfopage = searchResultPage.selectproductFromResults("iMac");
		int actImagesCount = productInfopage.getProductImagesCount();
		Assert.assertEquals(actImagesCount, Constant.IMAC_IMAGES_COUNT);
	}
	
	@DataProvider
	public Object[][] selectProductData() {
		return new Object[][] {
//			{"MacBook","MacBook Pro"},
			{"iMac","iMac"},
//			{"Samsung","Samsung SyncMaster 941BW"},
//			{"Apple","Apple Cinema 30\""}
			
		};
	}
	
	@Test(priority = 3,dataProvider = "selectProductData")
	public void productInfoTest(String productName,String mainProductName) {
//		Brand:Apple
//		Availability:In Stock
//		:Ex Tax: $100.00
//		Price:$122.00
//		name:iMac
//		exTax:Ex Tax: $100.00
		searchResultPage = accountsPage.doSearch(productName);
		productInfopage = searchResultPage.selectproductFromResults(mainProductName);
		Map<String,String> actProductInfoMap =  productInfopage.getProductInfoMap();
		actProductInfoMap.forEach((k,v) -> System.out.println(k+":"+v));
		Assert.assertEquals(actProductInfoMap.get("Brand"), "Apple");
		Assert.assertEquals(actProductInfoMap.get("Availability"), "In Stock");
		Assert.assertEquals(actProductInfoMap.get("Price"), "$122.00");
		Assert.assertEquals(actProductInfoMap.get("name"), "iMac");
		Assert.assertEquals(actProductInfoMap.get("exTax"), "Ex Tax: $100.00");
	}
}

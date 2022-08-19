package com.qa.tutorialsninja.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.tutorialsninja.base.BaseTest;
import com.qa.tutorialsninja.utils.Constant;

public class AccountsPageTest extends BaseTest {
	
   @BeforeClass
   public void accountPagesetUp() {
	   
	   accountsPage = loginPage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
   }
  
   @Test(priority =1)
   public void accountsPageTitleTest() 
   {
	  String title = accountsPage.AcountpageTitle();
	  System.out.println("Accounts Page title is : " +title);
	  Assert.assertEquals(title, Constant.ACCOUNT_PAGE_TITLE); 
	  
   }
   
   @Test(enabled = false)
   public void verifyAccountsPageHeaderTest() 
   {
	   String accountHeader = accountsPage.getAccountpageHeader();
	   System.out.println("Account Header name : " +accountHeader);
	   Assert.assertEquals(accountHeader, Constant.ACCOUNT_PAGE_HEADER);
   }
   
   @Test(priority =4)
   public void verifyAccountsSectionsListTest() {
	   Assert.assertEquals(accountsPage.getAccountSectionsList(), Constant.getAccountSectionsList());
   }
   
   @Test(priority = 3)
   public void verifyAccountsSectionsTest() 
   {
	   Assert.assertTrue(accountsPage.getAccountSectionsCount()== Constant.ACCOUNT_SECTIONS);
   }
   
   @DataProvider
   public Object[][] productData()
   {
	   return new Object[][]{
			    {"Macbook"},
			    {"Samsung"},
			    {"Apple"},
			   
	   };
   }
   
   @Test(priority =5,dataProvider="productData")
   public void SearchTest(String productName)
   {
	 
	   searchResultPage = accountsPage.doSearch(productName);
	   Assert.assertTrue(searchResultPage.getSearchProductCount()>0);
	   
   }
	
   @DataProvider
   public Object[][] productSelectData()
   {
	   return new Object[][]{
			    {"MacBook","MacBook Pro"},
			    {"Samsung","Samsung SyncMaster 941BW"},
			    {"Apple","Apple Cinema 30\""},
			   
	   };
   }
   @Test(priority =6,dataProvider="productSelectData")
   public void selectProductTest(String productName,String mainProductName)
   {
	   searchResultPage = accountsPage.doSearch(productName);
	   productInfopage = searchResultPage.selectproductFromResults(mainProductName);
	   String productHeaderName = productInfopage.getProductheader();
	   System.out.println("product header name :"+productHeaderName);
	   Assert.assertEquals(productHeaderName, mainProductName);
   }
   
   
   
}

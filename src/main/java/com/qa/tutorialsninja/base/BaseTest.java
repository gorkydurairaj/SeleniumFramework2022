package com.qa.tutorialsninja.base;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import com.qa.tutorialsninja.pages.AccountsPage;
import com.qa.tutorialsninja.pages.LoginPage;
import com.qa.tutorialsninja.pages.ProductInfoPage;
import com.qa.tutorialsninja.pages.RegisterPage;
import com.qa.tutorialsninja.pages.SearchResultPage;



public class BaseTest {

	public WebDriver driver;
	public BasePage basePage;
	public Properties prop;
	public LoginPage loginPage;
	public AccountsPage accountsPage;
	public SearchResultPage searchResultPage;
	public ProductInfoPage productInfopage;
	public RegisterPage registerPage;
	

	@BeforeTest
	public void setUp() {

		basePage = new BasePage();
		prop = basePage.init_prop();
		String browser = prop.getProperty("browser");
		driver = basePage.init_driver(prop);
		loginPage = new LoginPage(driver);
		driver.get(prop.getProperty("url"));
	}
	
	@AfterTest
	public void tearDown()
	{
		driver.quit();
	}

}

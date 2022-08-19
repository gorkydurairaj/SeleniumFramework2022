package com.qa.tutorialsninja.tests;

import java.util.Random;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.tutorialsninja.base.BaseTest;
import com.qa.tutorialsninja.utils.ExcelUtils;

public class RegistrationPageTest extends BaseTest {

	
	@BeforeClass
	public void registrationSetup()
	{
		registerPage = loginPage.navigateToRegister();
	}
	
	@DataProvider
	public Object[][] registrationData()
	{
		return ExcelUtils.getTestData("registration");
	}
	
	@Test
	public String randomGenerator()
	{
		Random randomGeneration= new Random();
		String email = "ourfamily"+randomGeneration.nextInt(1000)+"@gmail.com";
		return email;
	}
	
	@Test(dataProvider ="registrationData")
	public void registrationTest(String fname,String lname,String telephone,
			String password,String subscribe)
	{
		
	Assert.assertTrue(registerPage.accountRegistration(fname,lname,randomGenerator(),telephone,
			password,subscribe));
	}
}

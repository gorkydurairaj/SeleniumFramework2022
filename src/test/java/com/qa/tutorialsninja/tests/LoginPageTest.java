package com.qa.tutorialsninja.tests;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.qa.tutorialsninja.base.BaseTest;
import com.qa.tutorialsninja.testlisteners.ExtentReportListener;
import com.qa.tutorialsninja.testlisteners.TestAllureListener;
import com.qa.tutorialsninja.utils.Constant;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;


@Listeners(TestAllureListener.class)
public class LoginPageTest extends BaseTest{
	
	
	@Description("Login page title test")
	@Severity(SeverityLevel.MINOR)
	@Test(priority =1)
	public void verifyLoginPagetitletest() 
	{
	  String title = loginPage.getLoginPageTitle();
	  System.out.println("Login page title is :" +title);
	  Assert.assertEquals(title, Constant.LOGIN_PAGE_TITLE);
	}
	@Description("forgot password link test")
	@Severity(SeverityLevel.CRITICAL)
	@Test(priority =2)
	public void verifyForgotPasswordLinkTest() {
		Assert.assertTrue(loginPage.isForgotPasswordLinkExist());
	}
	
	@Test(priority =3)
	public void loginTest() { 
		loginPage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
	
	}
	

}

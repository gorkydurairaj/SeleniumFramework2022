package com.qa.tutorialsninja.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.tutorialsninja.base.BasePage;
import com.qa.tutorialsninja.utils.Constant;
import com.qa.tutorialsninja.utils.ElementUtil;

import io.qameta.allure.Step;

public class LoginPage extends BasePage {
	public WebDriver driver;
	public ElementUtil elementUtil;

	// 1.By locator: OR(object repo)
	private By emailId = By.xpath("//input[@name='email' and @id='input-email']");
	private By pasword = By.xpath("//input[@name='password' and @id='input-password']");
	private By login_button = By.xpath("//input[@type='submit' and @value='Login']");
	private By forgot_password_link = By.xpath("(//a[text()='Forgotten Password'])[1]");
//	private By register_link = By.xpath("//a[text()='Register']");
	private By register_link = By.linkText("Register");
	


   //2.Constructors of the page class
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		elementUtil = new ElementUtil(driver);
	}

	// 3.Page Actions: Features of the page in the form of methods
	@Step("getting login page title value...")
	public String getLoginPageTitle() 
	{
	   
    //       return  driver.getTitle();
		return elementUtil.waitForTitleToBePresent(Constant.LOGIN_PAGE_TITLE, 10);
	}
	@Step("checking forgot link is exist or not...")
	public boolean isForgotPasswordLinkExist() {
	  
//	  return driver.findElement(forgot_password_link).isDisplayed();
		return elementUtil.getElement(forgot_password_link).isDisplayed();
	}
	@Step("Login with username:{0} and password:{1}")
	public AccountsPage doLogin(String un,String pwd)
	{
		System.out.println("Login with " +un+ " and " +pwd);
//		driver.findElement(emailId).sendKeys(un);
//		driver.findElement(pasword).sendKeys(pwd);
//		driver.findElement(login_button).click();
		
		elementUtil.doSendKeys(emailId, un);
		elementUtil.doSendKeys(pasword, pwd);
		elementUtil.doClick(login_button);
	
		return new AccountsPage(driver);
	}
	@Step("navigating to register page...")
	public RegisterPage navigateToRegister()
	{
		elementUtil.doClick(register_link);
		
		return new RegisterPage(driver);
	}
	
	
}

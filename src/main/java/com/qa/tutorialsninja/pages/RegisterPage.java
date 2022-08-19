package com.qa.tutorialsninja.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.tutorialsninja.base.BasePage;
import com.qa.tutorialsninja.utils.Constant;
import com.qa.tutorialsninja.utils.ElementUtil;

public class RegisterPage extends BasePage{
	
	ElementUtil elementUtil;
	
	private By first_name = By.xpath("//input[@id='input-firstname' and @name ='firstname']");
	private By last_name = By.xpath("//input[@id='input-lastname' and @name ='lastname']");
	private By email = By.xpath("//input[@id='input-email' and @name ='email']");
	private By telephone = By.xpath("//input[@id='input-telephone' and @name ='telephone']");
	private By password = By.xpath("//input[@id='input-password' and @name ='password']");
	private By confirm_pwd = By.xpath("//input[@id='input-confirm' and @name ='confirm']");
	private By subscribe_yes = By.xpath("//input[@name='newsletter' and @value='1']");
	private By subscribe_no = By.xpath("//input[@name='newsletter' and @value='0']");
	private By agree_checkbox = By.xpath("//input[@name='agree' and @type ='checkbox']");
	private By continue_button = By.xpath("//input[@value='Continue' and @type ='submit']");
	private By account_success_msg = By.cssSelector("#content h1");
	private By logout_link = By.linkText("Logout");
	private By register_link = By.linkText("Register");
	
public RegisterPage(WebDriver driver)
{
	this.driver = driver;
	elementUtil = new ElementUtil(this.driver);
	
}

public boolean accountRegistration(String fname,String lname,String email,String telephone,String password,String subscribe)
{
	elementUtil.doSendKeys(this.first_name, fname);
	elementUtil.doSendKeys(this.last_name, lname);
	elementUtil.doSendKeys(this.email, email);
	elementUtil.doSendKeys(this.telephone, telephone);
	elementUtil.doSendKeys(this.password, password);
	elementUtil.doSendKeys(this.confirm_pwd, password);
	if(subscribe.equals("yes"))
	{
		elementUtil.doClick(subscribe_yes);
	}else {
		elementUtil.doClick(subscribe_no);
	}
	
	elementUtil.doClick(agree_checkbox);
	elementUtil.doClick(continue_button);
	
	String text = elementUtil.doGetText(account_success_msg);
	if(text.contains(Constant.ACCOUNT_SUCCESS_MSG))
	{
		elementUtil.doClick(logout_link);
		elementUtil.doClick(register_link);
		
		return true;
	}
	return false;
}

}

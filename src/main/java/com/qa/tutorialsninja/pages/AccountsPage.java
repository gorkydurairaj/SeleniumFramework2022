package com.qa.tutorialsninja.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.tutorialsninja.base.BasePage;
import com.qa.tutorialsninja.utils.Constant;
import com.qa.tutorialsninja.utils.ElementUtil;

public class AccountsPage extends BasePage {
	
	private WebDriver driver;
	private ElementUtil elementUtil;

	private By header = By.xpath("//a[text()='Your Store']");
	private By account_headers = By.xpath("//div[@id='content']/h2");
	private By search_text = By.xpath("// input[@name='search' and @type='text']");
	private By search_button = By.xpath("// span[@class='input-group-btn' ]/button[@type='button']");
	
	
	
public AccountsPage(WebDriver driver)
{
	this.driver = driver;
	elementUtil = new ElementUtil(this.driver);
}

public String AcountpageTitle() 
{
//	return driver.getTitle();
	return elementUtil.waitForTitleToBePresent(Constant.ACCOUNT_PAGE_TITLE,10);
}

public String getAccountpageHeader()
{
//	if(driver.findElement(header).isDisplayed())
//	{
//	  return driver.findElement(header).getText();
//	}
//	return null;
	
	if(elementUtil.getElement(header).isDisplayed())
	{
		return elementUtil.doGetText(header);
	}
	return null;
	
}
public int getAccountSectionsCount() 
{
//	return driver.findElements(account_headers).size();
	return elementUtil.getElements(account_headers).size();
}

public List<String> getAccountSectionsList()
{
	List<String> accountsList = new ArrayList<>();
//	List<WebElement> accsectionsList = driver.findElements(account_headers);
	List<WebElement> accsectionsList = elementUtil.getElements(account_headers);
	for(WebElement e: accsectionsList)
	{
		accountsList.add(e.getText());
	}
	
	return accountsList;
}
public SearchResultPage doSearch(String productName)
{
   System.out.println("searching the product name : "+productName);
	elementUtil.doSendKeys(search_text, productName);
	elementUtil.doClick(search_button);
	
	return new SearchResultPage(driver);

}


}

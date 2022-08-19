package com.qa.tutorialsninja.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.tutorialsninja.utils.ElementUtil;

public class SearchResultPage {
    private WebDriver driver;
    private ElementUtil eleUtil;
    
   
	private By results_Items = By.cssSelector("div.caption a");
    
	
	public SearchResultPage(WebDriver driver)
	{
		this.driver = driver;
		eleUtil = new ElementUtil(driver);
	}
	
	public int getSearchProductCount() {
		int searchResultCount = eleUtil.waitForVisibilityOfElements(results_Items, 10).size();
		System.out.println("search results count : "+searchResultCount);
		return searchResultCount;
	}
	
	public ProductInfoPage selectproductFromResults(String mainProductName)
	{
		System.out.println("searching the main product name : " +mainProductName);
		List<WebElement> resultItemsList = eleUtil.waitForVisibilityOfElements(results_Items, 10);
		for(WebElement e :resultItemsList )
		{
			String text = e.getText();
			if(text.equals(mainProductName))
			{
				e.click();
				break;
			}
			

			
		}
		
		return new ProductInfoPage(driver);
	}

	
}

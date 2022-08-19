package com.qa.tutorialsninja.pages;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.tutorialsninja.utils.ElementUtil;

public class ProductInfoPage {
	private WebDriver driver;
	private ElementUtil eleUtil;

	private By productHeader = By.cssSelector("div#content h1");
	private By productImages = By.cssSelector("ul.thumbnails img");
	private By productMetadata = By.cssSelector("div#content ul.list-unstyled:nth-of-type(1) li");
	private By productPrice = By.cssSelector("div#content ul.list-unstyled:nth-of-type(2) li");

	public ProductInfoPage(WebDriver driver) {
		this.driver = driver;
		eleUtil = new ElementUtil(driver);
	}

	public Map<String,String> productInfoMap;

	public String getProductheader() {

		String productHeaderText = eleUtil.doGetText(productHeader);
		System.out.println("Product header name : " + productHeaderText);
		return productHeaderText;
	}

	public int getProductImagesCount() {
		int imagesCount = eleUtil.waitForVisibilityOfElements(productImages, 10).size();
		System.out.println("product images count :" + imagesCount);
		return imagesCount;
	}

	public Map<String,String> getProductInfoMap() {
		productInfoMap = new HashMap<String, String>();
		productInfoMap.put("name", getProductheader());
		getProductMetaData();
		getProductPrice();
		
		return productInfoMap;
	}

	public void getProductMetaData() {
		List<WebElement> productMetaDataList = eleUtil.getElements(productMetadata);
		for (WebElement e : productMetaDataList) {
			String text = e.getText();
			String meta[] = text.split(":");
			String metaKey = meta[0].trim();
			String metavalue = meta[1].trim();

			productInfoMap.put(metaKey, metavalue);

		}

	}

	public void getProductPrice() {
		
	List<WebElement> productPriceList =	eleUtil.getElements(productPrice);
	String price =   productPriceList.get(0).getText();
    String exTaxPrice =productPriceList.get(1).getText();
    
    productInfoMap.put("Price", price);
    productInfoMap.put("exTax", exTaxPrice);
    
	}

}

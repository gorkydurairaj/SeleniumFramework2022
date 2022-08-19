package com.qa.tutorialsninja.utils;

import java.util.Properties;

import org.apache.poi.util.SystemOutLogger;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;

public class OptionsManager {

	Properties prop;
	ChromeOptions co;
	FirefoxOptions fo;

	public OptionsManager(Properties prop) {
		this.prop = prop;
	}
	
	
	public ChromeOptions getChromeOptions() {
		
		ChromeOptions co = new ChromeOptions();
		
		if(prop.getProperty("headless").trim().equals("true"))
		{
			System.out.println("Running on headless mode");
			co.addArguments("--headless");
		}
		
		if(prop.getProperty("incognito").trim().equals("true"))
		{
			co.addArguments("--incognito");
		}
		
		return co;
	}
	
	public FirefoxOptions getFirefoxOptions() {
		
		FirefoxOptions fo = new FirefoxOptions();
		
		if(prop.getProperty("headless").trim().equals("true"))
		{
			fo.addArguments("--headless");
		}
		
		if(prop.getProperty("incognito").trim().equals("true"))
		{
			fo.addArguments("--incognito");
		}
		
		return fo;
	}

}

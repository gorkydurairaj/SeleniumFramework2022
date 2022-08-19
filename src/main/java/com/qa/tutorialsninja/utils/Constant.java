package com.qa.tutorialsninja.utils;

import java.util.ArrayList;
import java.util.List;

public class Constant {
	
	public static final String LOGIN_PAGE_TITLE ="Account Login";
	public static final String ACCOUNT_PAGE_TITLE ="My Account";
	public static final String ACCOUNT_PAGE_HEADER ="Your Store";
	public static final int ACCOUNT_SECTIONS = 4;
	public static final String REGISTER_SHEET_NAME ="Register";
	public static final String ACCOUNT_SUCCESS_MSG ="";
	public static final int  IMAC_IMAGES_COUNT = 3;
	
	
	public static List<String> getAccountSectionsList() {
		
		List<String> accountSections = new ArrayList<>();
		accountSections.add("My Account");
		accountSections.add("My Orders");
		accountSections.add("My Affiliate Account");
		accountSections.add("Newsletter");
		
		return accountSections;
		
		
	}

}

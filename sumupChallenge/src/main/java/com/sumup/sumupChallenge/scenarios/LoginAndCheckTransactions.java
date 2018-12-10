package com.sumup.sumupChallenge.scenarios;

import org.openqa.selenium.WebDriver;

import com.sumup.sumupChallenge.pages.HomePage;
import com.sumup.sumupChallenge.singleton.WebDriverSingleton;

public class LoginAndCheckTransactions {

	private WebDriver driver = null;
	
	private HomePage home;
	
	public LoginAndCheckTransactions() {
		//Test for NPE
		driver = WebDriverSingleton.getInstance().driver();
		home = new HomePage(driver);
		
	}
	
	public void LoginAndCheckTransactios() {
				
		home.clickLoginLink();
	}
	
	
}

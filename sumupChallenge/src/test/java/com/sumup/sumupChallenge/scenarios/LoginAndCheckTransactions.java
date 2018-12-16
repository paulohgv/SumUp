package com.sumup.sumupChallenge.scenarios;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.sumup.sumupChallenge.pages.DashBoardPage;
import com.sumup.sumupChallenge.pages.LoginPage;
import com.sumup.sumupChallenge.pages.TransactionsPage;
import com.sumup.sumupChallenge.singleton.WebDriverSingleton;

public class LoginAndCheckTransactions {

	private WebDriver driver = null;
		
	private LoginPage login;
		
	private DashBoardPage dash;
	
	private TransactionsPage transactions;
	
	public LoginAndCheckTransactions() {
		driver = WebDriverSingleton.getInstance().driver();
	}
	
	@BeforeTest
	public void setUp() {
		login = new LoginPage(driver);
		dash = new DashBoardPage(driver);
		transactions = new TransactionsPage(driver);

	}
	
	
	@Test(description="Access Login page and access transaction page")
	@Parameters({"email", "pass", "userName", "msgResultFilter", "msgAdvice"})
	public void LoginAndCheckTransaction(String email, String pass, String userName,
			String msgResultFilter, String msgAdvice) {
			
		login.DoLogin(email, pass);
		dash.verifyUserNameLoggedIn(userName);
		dash.accessTransactions();
		transactions.validateTransactions(msgResultFilter, msgAdvice);
	
	}
	
	
	
	@AfterSuite
	public void tearDonw(){
		driver.quit();
		
	}
	
}

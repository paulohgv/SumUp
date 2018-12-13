package com.sumup.sumupChallenge.scenarios;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.sumup.sumupChallenge.pages.DashBoardPage;
import com.sumup.sumupChallenge.pages.LoginPage;
import com.sumup.sumupChallenge.pages.TransactionsPage;
import com.sumup.sumupChallenge.singleton.WebDriverSingleton;

public class LoginAndCheckTransactions {

	private WebDriver driver = null;
		
	private LoginPage login;
		
	private static String URL;
	
	private DashBoardPage dash;
	
	private TransactionsPage transactions;
	
	public LoginAndCheckTransactions() {
		driver = WebDriverSingleton.getInstance().driver();
		
		//TODO get url by system property
		URL = "https://me.sumup.com/login";

	}
	
	@BeforeTest
	public void setUp() {
		login = new LoginPage(driver);
		dash = new DashBoardPage(driver);
		transactions = new TransactionsPage(driver);
		driver.get(URL);
	}
	
	
	@Test(description="Access Login page and access transaction page")
	//@Parameters({"email", "pass", "userName", "msgResultFilter", "msgAdvice"})
	public void LoginAndCheckTransactios(/*@Optional String email, @Optional String pass, @Optional String userName,
			@Optional String msgResultFilter, @Optional String msgAdvice*/) {
	
		String email = "paulohgv@gmail.com";
		String pass = "phgv191188";
		String userName = "Paulo Vicente";
		String msgResultFilter = "We couldn’t find anything that matches your search.";
		String msgAdvice = "Please try another search";
		

		
		
		login.DoLogin(email, pass);
		dash.verifyUserNameLoggedIn(userName);
		dash.accessTransactions();
		transactions.validateTransactions(msgResultFilter, msgAdvice);
			
	}
	
	@AfterTest
	public void tearDown(){
		driver.close();
	}
	
/*	public static void main(String[] args) {
		
		String email = "paulohgv@gmail.com";
		String pass = "phgv191188";
		String userName = "Paulo Vicente";
		String msgResultFilter = "We couldn’t find anything that matches your search.";
		String msgAdvice = "Please try another search";
		
		LoginAndCheckTransactions abc = new LoginAndCheckTransactions();
		abc.setUp();
		abc.LoginAndCheckTransactios(email, pass, userName, msgResultFilter, msgAdvice);
		

	}*/
	
}

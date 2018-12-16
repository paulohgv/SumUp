package com.sumup.sumupChallenge.scenarios;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.sumup.sumupChallenge.pages.LoginPage;
import com.sumup.sumupChallenge.singleton.WebDriverSingleton;

public class LoginWithWrongUserPass {

	private WebDriver driver = null;
	
	private LoginPage login;
		
	public  LoginWithWrongUserPass() {
		driver = WebDriverSingleton.getInstance().driver();
	}
	
	
	@BeforeTest
	public void setUp() {
		login = new LoginPage(driver);
	}
	
	
	@Test(description = "Login with wrong user or password")
	@Parameters({"email","pass", "message"})
	public void LoginWithWrongUserAndPass(String email, String pass, String message){
		login.DoLogin(email, pass);
		login.validateMessageWrongUserPass(message);
	}
	
	@AfterSuite
	public void tearDown(){
		driver.quit();
	}
	
}

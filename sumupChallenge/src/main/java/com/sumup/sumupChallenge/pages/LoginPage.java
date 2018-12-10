package com.sumup.sumupChallenge.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.sumup.sumupChallenge.utils.SeleniumUtils;

public class LoginPage extends SeleniumUtils{

	private WebDriver driver;
	
	@FindBy(id = "username")
	private WebElement fldEmail;
	
	@FindBy(id="password")
	private WebElement fldPass;
	
	//TODO refactoring
	@FindBy(xpath="//*[@id=\"root\"]/ui-view/login/div/section/div[2]/form/ul/li[4]/button")
	private WebElement btnLogin;
	
	public LoginPage(WebDriver driver) {
		driver = this.driver;
		PageFactory.initElements(driver, this.getClass());
		
	}
	
	public void DoLogin(String userName, String pass) {
		
		
	}
	
	
}

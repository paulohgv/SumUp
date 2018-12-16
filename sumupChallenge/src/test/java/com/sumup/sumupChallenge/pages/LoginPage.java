package com.sumup.sumupChallenge.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.sumup.sumupChallenge.utils.SeleniumUtils;

public class LoginPage extends SeleniumUtils{

	private WebDriver driver;
	
	@FindBy(id = "username")
	public WebElement fldEmail;
	
	@FindBy(id="password")
	public WebElement fldPass;
	
	@FindBy(how = How.XPATH , using="//*[@id=\"root\"]/ui-view/login/div/section/div[2]/form/ul/li[4]/button")
	public WebElement btnLogin;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"root\"]/ui-view/login/div/section/div[2]/form/ul/li[3]/ul/li[1]")
	public WebElement errorMessage;
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(this.driver, this);
		
	}
	
	public void DoLogin(String userName, String pass) {
		waitElement(driver, fldEmail);
		waitElement(driver, fldPass);
		waitElement(driver, btnLogin);
		
		fldEmail.clear();
		fldEmail.sendKeys(userName);
		
		fldPass.clear();
		fldPass.sendKeys(pass);
		btnLogin.click();
		
	}
	
	public void validateMessageWrongUserPass(String message){
		errorMessage = waitElementPresent(driver, errorMessage);
		Assert.assertEquals(message, errorMessage.getText(), "Error message");
		
	}
	
	
	
		
			
	
	
}

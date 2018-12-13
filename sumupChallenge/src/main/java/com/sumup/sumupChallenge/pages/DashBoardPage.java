package com.sumup.sumupChallenge.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.sumup.sumupChallenge.utils.SeleniumUtils;

import junit.framework.Assert;

public class DashBoardPage extends SeleniumUtils{
	
	private WebDriver driver;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"root\"]/div[1]/div[1]/div/div[1]/div/div[2]/div[1]/p" )
	public WebElement name;

	@FindBy(how = How.XPATH, using = "//*[@id=\"root\"]/div[1]/div[1]/div/ul/a[2]/p")
	public WebElement transactionOption;
	
	
	public DashBoardPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	 
	
	public void accessTransactions() {
		transactionOption = waitElementPresent(driver, transactionOption);
		transactionOption.click();
	}
	
	
	public void verifyUserNameLoggedIn(String userName) {
		Assert.assertEquals("Username wrong: ", waitElementPresent(driver, name).getText(), userName);	
	}
	
	
	

}

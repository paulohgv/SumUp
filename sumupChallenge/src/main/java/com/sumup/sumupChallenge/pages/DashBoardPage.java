package com.sumup.sumupChallenge.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.sumup.sumupChallenge.utils.SeleniumUtils;

public class DashBoardPage extends SeleniumUtils{
	
	private WebDriver driver;
	
	// TODO think about a better way to get user name logged in
	@FindBy(xpath = "//*[@id=\"root\"]/ui-view/layout/div/sidenav/div/div/div[1]/div/div[2]/div[1]/p")
	public WebElement userName;
	
	@FindBy(xpath = "//*[@id=\"root\"]/div[1]/div[1]/div/ul/a[2]")
	public WebElement transactionLink;
	
	public DashBoardPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(this.driver, this);
		
	}
	
	
	public void accessTransactions() {
		waitElement(driver, transactionLink);
		transactionLink.click();
		
	}
	
	
	public void verifyUserNameLoggedIn(String userName) {
		waitElement(driver, this.userName);
		Assert.assertEquals("Username wrong: ",this.userName.getText(), userName);	
		
		
	}
	
	
	

}

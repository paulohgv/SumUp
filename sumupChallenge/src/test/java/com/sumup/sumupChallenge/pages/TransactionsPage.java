package com.sumup.sumupChallenge.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.sumup.sumupChallenge.utils.SeleniumUtils;

public class TransactionsPage extends SeleniumUtils{

	private WebDriver driver;
	
	@FindBy(how = How.XPATH , using = "//*[@id=\"root\"]/div[1]/div[2]/div/div/div/div[5]/div[3]/div/*[1]")
	public WebElement imageWithoutTransactions;
	
	@FindBy(how = How.XPATH , using  = "//*[@id=\"root\"]/div[1]/div[2]/div/div/div/div[5]/div[3]/div/h2")
	public WebElement msgResultFilter;
	
	@FindBy(how = How.XPATH , using = "//*[@id=\"root\"]/div[1]/div[2]/div/div/div/div[5]/div[3]/div/p")
	public WebElement msgAdvice;
	
	
	public TransactionsPage(WebDriver driver) {
		
		this.driver = driver;
		PageFactory.initElements(this.driver, this);
		
	}
	
	
	public void validateTransactions(String msgDescripitionResultFilter, String msgDescriptionAdvice) {
		imageWithoutTransactions = waitElementPresent(driver, imageWithoutTransactions);
		msgResultFilter = waitElementPresent(driver, this.msgResultFilter);
		msgAdvice = waitElementPresent(driver, this.msgAdvice);
		
		
		Assert.assertEquals(msgResultFilter.getText(), msgDescripitionResultFilter, "Message is wrong: " );
		Assert.assertEquals(msgAdvice.getText(), msgDescriptionAdvice, "Message is wrong: ");
		
	}
	
	
	
	
}

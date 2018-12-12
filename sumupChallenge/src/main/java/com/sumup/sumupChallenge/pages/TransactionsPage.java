package com.sumup.sumupChallenge.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.sumup.sumupChallenge.utils.SeleniumUtils;

public class TransactionsPage extends SeleniumUtils{

	private WebDriver driver;
	
	@FindBy(xpath = "//*[@id=\"root\"]/div[1]/div[2]/div/div/div/div[5]/div[3]/div/svg/g")
	public WebElement imageWithoutTransactions;
	
	@FindBy(xpath = "//*[@id=\"root\"]/div[1]/div[2]/div/div/div/div[5]/div[3]/div/h2")
	public WebElement msgResultFilter;
	
	@FindBy(xpath = "//*[@id=\"root\"]/div[1]/div[2]/div/div/div/div[5]/div[3]/div/p")
	public WebElement msgAdvice;
	
	
	public TransactionsPage(WebDriver driver) {
		
		this.driver = driver;
		PageFactory.initElements(this.driver, this);
		
	}
	
	
	public void validateTransactions(String msgDescripitionResultFilter, String msgDescriptionAdvice) {
		waitElementVisible(driver, imageWithoutTransactions);
		waitElement(driver, this.msgResultFilter);
		waitElement(driver, this.msgAdvice);
		
		
		Assert.assertEquals("Message is wrong: ", msgResultFilter.getText(), msgDescripitionResultFilter);
		Assert.assertEquals("Message is wrong: ", msgAdvice.getText(), msgDescriptionAdvice);
		
	}
	
	
	
	
}

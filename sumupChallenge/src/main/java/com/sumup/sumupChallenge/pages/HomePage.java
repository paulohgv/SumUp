package com.sumup.sumupChallenge.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.sumup.sumupChallenge.utils.SeleniumUtils;

@Deprecated
public class HomePage extends SeleniumUtils{

	//TODO create Get and Set Methods
	private WebDriver driver;
	
	
	@FindBy(linkText = "Login")
	public WebElement loginLink;
	

	public HomePage(WebDriver driver) {
		driver = this.driver;
		PageFactory.initElements(driver, this.getClass());
	}
	
	
	public void clickLoginLink() {
		waitElement(driver, loginLink);
		loginLink.click();
		
	}
	
	
}

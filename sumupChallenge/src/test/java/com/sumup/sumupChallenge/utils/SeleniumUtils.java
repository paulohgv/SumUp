	package com.sumup.sumupChallenge.utils;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SeleniumUtils {

	private static final int TIMEOUT = 30;

	
	public static WebElement waitElement(WebDriver driver,
			final WebElement elementFind) {
		WebElement element = null;
		try {
			element = (new WebDriverWait(driver, TIMEOUT))
					.until(new ExpectedCondition<WebElement>() {

						public WebElement apply(WebDriver d) {
							return elementFind;
						}
					});
		} catch (Exception e) {
			e.printStackTrace();
		}
		return element;
	}

	
	public static WebElement waitElementPresent(WebDriver driver, final WebElement e){
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
			    .withTimeout(TIMEOUT, TimeUnit.SECONDS)
			    .pollingEvery(3, TimeUnit.SECONDS)
			    .ignoring(NoSuchElementException.class, ElementNotVisibleException.class);
		
		WebElement element = wait.until(new ExpectedCondition<WebElement>() {
			@Override
			public WebElement apply(WebDriver driver){
				try {
	                if (e.isDisplayed())
	                    return e;
	                return null;
	            } catch (final ElementNotVisibleException e) {
	                return null;
	            }
			}
			
		});
		return element;
		
	}
		
	public static WebElement waitElementVisible(WebDriver driver, final WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, TIMEOUT);
		WebElement elementWait = wait.until(visibilityOfElementLocated(element));
		return elementWait;
	}

	public static WebElement waitElementNotVisible(WebDriver driver,
			final WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, TIMEOUT);
		WebElement elementWait = wait.until(unvisibilityOfElementLocated(element));
		return elementWait;
	}

	private static ExpectedCondition<WebElement> visibilityOfElementLocated(
			final WebElement locator) {
		return new ExpectedCondition<WebElement>() {
			public WebElement apply(WebDriver driver) {
				WebElement toReturn = locator;
				if (toReturn.isDisplayed()) {
					return toReturn;
				}
				return null;
			}
		};
	}

	private static ExpectedCondition<WebElement> unvisibilityOfElementLocated(
			final WebElement locator) {
		return new ExpectedCondition<WebElement>() {
			public WebElement apply(WebDriver driver) {
				WebElement toReturn = locator;
				if (!toReturn.isDisplayed()) {
					return toReturn;
				}
				return null;
			}
		};
	}

	public static void acceptAlert(WebDriver driver) {
		Alert alert = driver.switchTo().alert();
		alert.accept();
	}

	public static Alert waitForAlert(WebDriver driver) {
		FluentWait<WebDriver> wait = new WebDriverWait(driver, TIMEOUT)
				.ignoring(NullPointerException.class);
		return wait.until(new AlertAvailable());
	}
	
	private static class AlertAvailable implements ExpectedCondition<Alert> {
		public Alert apply(WebDriver driver) {
			Alert alert = driver.switchTo().alert();
			alert.getText();
			return alert;
		}
	}
}

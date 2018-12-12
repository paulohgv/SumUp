	package com.sumup.sumupChallenge.utils;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SeleniumUtils {

	private static int sec = 10;
	private static int timeout = 30;

	
	public static WebElement waitElement(WebDriver driver, final By elementFind) {

		WebElement element = null;
		try {
			element = (new WebDriverWait(driver, sec))
					.until(new ExpectedCondition<WebElement>() {
						public WebElement apply(WebDriver d) {
							return d.findElement(elementFind);
						}
					});

		} catch (Exception e) {
			e.printStackTrace();
		}
		return element;
	}
	
	public static int getIndexFromSelectOptions(Select selectfile, String option) {
		int index = 0;
		for (WebElement w : selectfile.getOptions()) {
			if (!w.getText().equalsIgnoreCase(option)) {
				index++;
			} else {
				break;
			}
		}
		return index;
	}
	

	public static WebElement waitElement(WebDriver driver,
			final WebElement elementFind) {
		WebElement element = null;
		try {
			element = (new WebDriverWait(driver, sec))
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

	public static WebElement waitElementVisible(WebDriver driver, final WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, timeout);
		WebElement elementWait = wait.until(visibilityOfElementLocated(element));
		return elementWait;
	}

	public static WebElement waitElementNotVisible(WebDriver driver,
			final WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, timeout);
		WebElement elementWait = wait.until(unvisibilityOfElementLocated(element));
		return elementWait;
	}

	public static String getValueFromSelectField(WebDriver driver,
			WebElement 	element) {
		Select selectBox = new Select(element);
		String select = selectBox.getFirstSelectedOption().getText();

		return select;
	}

	public static Select selectValueFromSelectFieldByValueOption(
			WebDriver driver, By locator, String value) {
		Select selectBox = new Select(driver.findElement(locator));
		selectBox.getOptions();
		selectBox.selectByVisibleText(value);

		return selectBox;
	}

	public static Select selectValueFromSelectFieldByindex(WebDriver driver,
			By locator, int index) {
		Select selectBox = new Select(driver.findElement(locator));
		selectBox.getOptions();
		selectBox.selectByIndex(index);
		return selectBox;
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
		FluentWait<WebDriver> wait = new WebDriverWait(driver, timeout)
				.ignoring(NullPointerException.class);
		return wait.until(new AlertAvailable());
	}
	
	public boolean existsElement(WebDriver driver, By element) {
		if(driver.findElements(element).size() != 0){
			return true;
		}else{
			return false;
		}
	}

	private static class AlertAvailable implements ExpectedCondition<Alert> {

		public Alert apply(WebDriver driver) {
			Alert alert = driver.switchTo().alert();
			alert.getText();
			return alert;
		}
	}

	
	
}

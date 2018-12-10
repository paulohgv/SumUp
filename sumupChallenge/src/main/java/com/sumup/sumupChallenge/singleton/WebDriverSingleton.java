package com.sumup.sumupChallenge.singleton;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebDriverSingleton {

	private static WebDriver driver;

	private static WebDriverSingleton instance = null;

	private WebDriverSingleton() {

		System.setProperty("webdriver.chrome.driver", "");
		driver = new ChromeDriver();
	}

	public static WebDriverSingleton getInstance() {

		if (instance == null) {
			instance = new WebDriverSingleton();
		}

		return instance;

	}

	public WebDriver driver() {
		return driver;
	}

}

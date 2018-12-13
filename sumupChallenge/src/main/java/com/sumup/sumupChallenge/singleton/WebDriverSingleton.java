package com.sumup.sumupChallenge.singleton;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class WebDriverSingleton {

	private static WebDriver driver;

	private static WebDriverSingleton instance = null;

	private WebDriverSingleton() {

		System.setProperty("webdriver.chrome.driver", "./resources/chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		// TODO implement propertie file to get parans and browsers add firefox driver and logs
		options.addArguments("--lang=en-US");
		driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
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

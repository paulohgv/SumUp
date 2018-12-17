package com.sumup.sumupChallenge.singleton;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class WebDriverSingleton {

	private static WebDriver driver;

	private static WebDriverSingleton instance = null;

	private WebDriverSingleton() {
		
		String browser = getBrowser().toLowerCase();		
		// TODO Create ENUM value for browsers
		switch (browser) {
		case "firefox":
			firefoxDriver();
			break;
		default: case "chorme":
			chromeDriver();
			break;
		}
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

	
	private String getBaseURL(){
		String url = "https://me.sumup.com/login";
		try {
			if(!System.getProperties().getProperty("host").isEmpty()  || System.getProperties().getProperty("host") != null){
				url = System.getProperties().getProperty("host");
				System.out.println("new host was defined: " + url);
			}
		} catch (NullPointerException e) {
			System.out.println("using default host: " + url);
			return url;
		}
		
		return url;
	}
	
	private String getBrowser(){
		String browserProp = "chrome";
		try {
			if (!System.getProperties().getProperty("browser").isEmpty()  || System.getProperties().getProperty("browser") != null){
				browserProp = System.getProperties().getProperty("browser");
				System.out.println("New browser has been defined: " + browserProp);
				return browserProp;
			}
		} catch (NullPointerException e) {
			System.out.println("using default browser: " + browserProp);
			return browserProp;
		}
		
		return browserProp;
	}
	
	private String getLanguageBrowser(){
		String language  ="en-US";
				
		try {
			if(System.getProperties().getProperty("lang") != null && !System.getProperties().getProperty("lang").isEmpty()){
				language = System.getProperties().getProperty("lang");
				System.out.println("a new language has been defined: " + language);
				return language;
			}
		} catch (NullPointerException e) {
			System.out.println("using default language: " + language);
			return language;
		}
		
		return language;
	}
	
	// TODO Remove duplicate code
	public void chromeDriver(){
		System.setProperty("webdriver.chrome.driver", "./resources/chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--lang=".concat(getLanguageBrowser()));
		driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.get(getBaseURL());
		
	}
	
	// TODO Remove duplicate code	
	private void firefoxDriver() {
		System.setProperty("webdriver.gecko.driver", "./resources/geckodriver.exe");
		FirefoxOptions profile = new FirefoxOptions();
		profile.addPreference("intl.accept_languages", getLanguageBrowser());
		driver = new FirefoxDriver(profile);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.get(getBaseURL());
		
	}

}

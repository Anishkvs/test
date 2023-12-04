package com.saucedemo.base;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AutomationBase { 	

	public WebDriver driver;
		
	/**
	 * Method to start Browser session Chrome/Firefox/Edge
	 * 
	 * @author Anish
	 * @since 03/October/2023
	 * @param browserName
	 * @return
	 * @throws IOException
	 */
	public WebDriver startBrowserSession(String browserName) throws IOException {
	
		
		if (browserName.equalsIgnoreCase("chrome") || browserName.equalsIgnoreCase("Chrome_headless")) {

			ChromeOptions options = new ChromeOptions();

			if (browserName.equalsIgnoreCase("Chrome_headless")) {
				options.addArguments("--headless");
			}
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver(options);

		} else if (browserName.equalsIgnoreCase("firefox") || browserName.equalsIgnoreCase("Firefox_headless")) {

			FirefoxOptions options = new FirefoxOptions();

			if (browserName.equalsIgnoreCase("Firefox_headless")) {
				options.addArguments("--headless");
			}
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver(options);

		} else if (browserName.equalsIgnoreCase("edge") || browserName.equalsIgnoreCase("Edge_headless")) {

			EdgeOptions options = new EdgeOptions();

			if (browserName.equalsIgnoreCase("Edge_headless")) {
				options.addArguments("--headless");
			}
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver(options);

		} else {
			System.out.println("Unsupport browser: " + browserName);
		}
		

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		return driver;

	}
	

	


}

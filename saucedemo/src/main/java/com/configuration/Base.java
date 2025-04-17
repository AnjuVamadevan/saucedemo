package com.configuration;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.safari.SafariOptions;

import com.utitlities.Utilities;

public class Base {
	
	public static WebDriver driver;
	public static ChromeOptions chromeOptions;
	public static FirefoxOptions firefoxOptions;
	public static SafariOptions safariOptions;

	
	public static void initialisation() throws IOException 
	{
		
		//String browser = System.getProperty("browsername","chrome");
		String browser = System.getProperty("browsername",Utilities.getPropertiesFileValue("browser"));
		
		if(browser.equalsIgnoreCase("chrome"))
		{
	        // Add command-line arguments
			chromeOptions = new ChromeOptions();
			chromeOptions.addArguments("--incognito");
			chromeOptions.addArguments("--disable-password-manager");
		
			driver = new ChromeDriver(chromeOptions);
		}
		else if(browser.equalsIgnoreCase("firefox"))
		{
			driver = new FirefoxDriver();
		}
		else if(browser.equalsIgnoreCase("safari"))
		{
			driver = new SafariDriver();
		}


		else
		{
			System.out.print("Browser not supported");
		}
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		//driver.get("https://www.saucedemo.com/");
		driver.get(Utilities.getPropertiesFileValue("url"));
        driver.manage().window().maximize();
	}
	
}

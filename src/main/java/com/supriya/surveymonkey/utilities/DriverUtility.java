package com.supriya.surveymonkey.utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverUtility {
	
	private static WebDriver driver;

	
	public static WebDriver getDriver() throws Exception {
		
		 if (driver == null) {
			 String browser  = ConfigReader.readProperty("browser");
			 if (browser == null) {
				 throw new RuntimeException("Browser property not set in configuration.properties");
             }
			 
			 
			 
			 switch (browser.toLowerCase()) {
             case "chrome":

                 WebDriverManager.chromedriver().setup();

                 ChromeOptions options = new ChromeOptions();
                 

                 String headless = System.getProperty("headless");

                 if ("true".equalsIgnoreCase(headless)) {
                     System.out.println("Running in HEADLESS mode (Jenkins)");
                     options.addArguments("--headless=new");
                     options.addArguments("--no-sandbox");
                     options.addArguments("--disable-dev-shm-usage");
                 } else {
                     System.out.println("Running in NORMAL mode (Local)");
                 }

                 options.addArguments("--disable-gpu");
                 options.addArguments("--window-size=1920,1080");

                 driver = new ChromeDriver(options);
                 break;
             case "firefox":
                 WebDriverManager.firefoxdriver().setup();
                 driver = new FirefoxDriver();
                 break;

             default:
                 throw new RuntimeException("Unsupported browser: " + browser);
         }

         driver.manage().window().maximize();
         driver.manage().deleteAllCookies();
     }

     return driver;
 }


 public static void quitDriver() {
     if (driver != null) {
         driver.quit();
         driver = null;
     }
 }
		
}

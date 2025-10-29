package com.supriya.surveymonkey.hooks;

import org.openqa.selenium.WebDriver;

import com.supriya.surveymonkey.pages.HomePage;
import com.supriya.surveymonkey.utilities.DriverUtility;
import com.supriya.surveymonkey.utilities.ScreenshotUtils;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Hooks {

	
public static WebDriver driver;
	
	@Before
    public void setup() throws Exception {
        driver = DriverUtility.getDriver();
        
       
        HomePage homePage = new HomePage(driver);
       
    }

    @After
    public void tearDown(Scenario scenario) {
        if (scenario.isFailed()) {
            try {
                String screenshotPath = ScreenshotUtils.captureScreenshot(driver,scenario.getName().replaceAll(" ", "_"));
                System.out.println("Screenshot saved at: " + screenshotPath);
            } catch (Exception e) {
                System.out.println("Failed to capture screenshot: " + e.getMessage());
            }
        }

    DriverUtility.quitDriver();
    }
}

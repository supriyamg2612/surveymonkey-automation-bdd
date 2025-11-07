package com.supriya.surveymonkey.hooks;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import com.supriya.surveymonkey.pages.HomePage;
import com.supriya.surveymonkey.pages.SignUpPage;
import com.supriya.surveymonkey.utilities.DriverUtility;
import com.supriya.surveymonkey.utilities.ScreenshotUtils;
import com.supriya.surveymonkey.utilities.WaitUtils;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Hooks {

	
	public static WebDriver driver;
    public static HomePage homepage;
    public static SignUpPage signUpPage ;
    public static WaitUtils waitUtils;	
	@Before
    public void setup() throws Exception {
		driver = DriverUtility.getDriver();

        // Initialize page objects and utilities
        homepage = new HomePage(driver);
        waitUtils = new WaitUtils(driver, 10);
        signUpPage =new SignUpPage(driver);

        if (driver == null) {
            throw new RuntimeException("❌ Driver is not initialized in Hooks!");
        }

        Assert.assertTrue("❌ Browser window was not opened or is not visible.",
                driver.getWindowHandles().size() > 0);

        System.out.println("✅ Browser launched successfully.");
    
       
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

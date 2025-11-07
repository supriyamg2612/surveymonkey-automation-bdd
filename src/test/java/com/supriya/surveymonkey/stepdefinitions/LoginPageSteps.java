package com.supriya.surveymonkey.stepdefinitions;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;

import org.openqa.selenium.WebDriver;

import com.supriya.surveymonkey.hooks.Hooks;
import com.supriya.surveymonkey.pages.HomePage;
import com.supriya.surveymonkey.pages.LoginPage;
import com.supriya.surveymonkey.utilities.ConfigReader;
import com.supriya.surveymonkey.utilities.WaitUtils;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginPageSteps {
	
	
	private WebDriver driver = Hooks.driver;
	private WaitUtils waitUtils = Hooks.waitUtils;
	 private HomePage homepage = Hooks.homepage;
	  private LoginPage loginPage = Hooks.loginPage;
	  
	  
	  @Given("the user navigates to the Login Page")
	  public void the_user_navigates_to_the_login_page() throws Exception {
			driver.get(ConfigReader.readProperty("url"));
			homepage.dismissCookiesBanner();
			loginPage=homepage.openLoginPage();
			System.out.println("🌐 Navigated to: " + driver.getCurrentUrl());
			
	  }

	  @When("the user enters a valid login email from configuration file")
	  public void the_user_enters_a_valid_login_email_from_configuration_file() throws Exception {
		  String Useremail = ConfigReader.readProperty("ValidLoginEmail");
		  loginPage.enterEmail(Useremail);
	  }
	  
	  @When("the user clicks on the {string} button from the login page")
	    public void the_user_clicks_on_the_button_from_the_login_page(String buttonName) {
	        if (buttonName.equalsIgnoreCase("Next")) {
	            loginPage.clickNextButton();
	        } else if (buttonName.equalsIgnoreCase("Login")) {
	            loginPage.clickLoginButton();
	        } else {
	            throw new RuntimeException("Button not found: " + buttonName);
	        }
	    }
	  
	  @Then("the user should be navigated to the password entry page")
	  public void the_user_should_be_navigated_to_the_password_entry_page() {
		  boolean isPasswordVisible = loginPage.waitUtils.waitForVisibility(loginPage.userPasswordElement).isDisplayed();
		    assertTrue("Password field is not displayed. Navigation to password page failed.", isPasswordVisible);
		    String actualTitle = driver.getTitle();
		    assertEquals("Password page title mismatch", "SurveyMonkey - Enter password", actualTitle);
		   
	    }
	  
	  @When("the user enters a valid login password from config in the Password field")
	    public void the_user_enters_a_valid_login_password_from_config_in_the_password_field() throws Exception {
	        String Userpassword = ConfigReader.readProperty("ValidLoginPassword");
	        loginPage.enterPassword(Userpassword);
	    }
	  @Then("the title of the page should be {string} this")
	    public void the_title_of_the_page_should_be_this(String expectedTitle) {
		  waitUtils.waitForTitleContains(expectedTitle);
	        String actualTitle = driver.getTitle();
	        assertEquals(expectedTitle, actualTitle);
	    }



}

package com.supriya.surveymonkey.stepdefinitions;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import com.supriya.surveymonkey.hooks.Hooks;
import com.supriya.surveymonkey.pages.HomePage;
import com.supriya.surveymonkey.pages.SignUpPage;
import com.supriya.surveymonkey.utilities.ConfigReader;
import com.supriya.surveymonkey.utilities.WaitUtils;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SignUpPageSteps {
	
	
	private WebDriver driver = Hooks.driver;
    private HomePage homepage = Hooks.homepage;
    private SignUpPage signUpPage = Hooks.signUpPage; // SignUpPage should be initialized in Hooks
    private WaitUtils waitUtils = Hooks.waitUtils;
    
    
    @Given("the user navigates to the Sign Up page")
    public void the_user_navigates_to_the_sign_up_page() throws Exception {
    	driver.get(ConfigReader.readProperty("url"));
    	homepage.dismissCookiesBanner();
    	signUpPage =homepage.openSignUpPage();
    	System.out.println("🌐 Navigated to: " + driver.getCurrentUrl());

    }
    
    @When("the user enters a valid SignUp email from config")
    public void the_user_enters_a_valid_sign_up_email_from_config() throws Exception {
        String baseEmail = ConfigReader.readProperty("signUpEmail");
        String uniqueEmail = signUpPage.generateUniqueEmail(baseEmail);
        signUpPage.enterEmail(uniqueEmail);
        System.out.println("📧 Using unique email for signup: " + uniqueEmail);

        
    }
    

   @When("the user agrees to the Terms of Use and Privacy Notice")
    public void the_user_agrees_to_terms_of_use() {
        signUpPage.checkTermsCheckbox();
    }
    
    @When("the user clicks on the {string} button")
    public void the_user_clicks_on_the_button(String buttonName) {
        if (buttonName.equalsIgnoreCase("Next")) {
            signUpPage.clickNextButton();
        } else if (buttonName.equalsIgnoreCase("Create Account")) {
            signUpPage.clickCreateAccountButton();
        } else {
            throw new RuntimeException("Button not found: " + buttonName);
        }
    }
    
    @Then("the password creation page should be displayed in the same window")
    public void the_password_creation_page_should_be_displayed_in_the_same_window() {
    	String passwordPageTitle = "SurveyMonkey - Create password" ;
    	waitUtils.waitForTitleContains(passwordPageTitle);
    	String expectedPasswordPageTitle= driver.getTitle();
        Assert.assertEquals(passwordPageTitle, expectedPasswordPageTitle);
           
    }
    
    @When("the user enters a valid SignUp password from config in the Password field")
    public void the_user_enters_a_valid_sign_up_password_from_config_in_the_password_field() throws Exception {
    	  String password = ConfigReader.readProperty("signUpPassword");
          signUpPage.enterPassword(password);
    }

    @When("the user re-enters the same SignUp password from config in the Confirm Password field")
    public void the_user_re_enters_the_same_sign_up_password_from_config_in_the_confirm_password_field() throws Exception {
    	 String password = ConfigReader.readProperty("signUpPassword");
         signUpPage.enterConfirmPassword(password);
    }

    

    @Then("the user should be redirected to the page {string}")
    public void the_user_should_be_redirected_to_the_page(String expectedUrl) {
    	System.out.println("⏳ Waiting for redirect to: " + expectedUrl);
    	
    	
    	try {
            // Step 1: Wait for the intermediate profile page
            waitUtils.waitForUrlContains("profile/default");
            System.out.println("🔁 Intermediate redirect detected: " + driver.getCurrentUrl());
            // Step 2: Extend wait time for the final /home redirect
            WaitUtils extendedWait = new WaitUtils(driver, 40); // 40 seconds max wait
            boolean redirected = extendedWait.waitForUrlContains("home");
            Assert.assertTrue(
                    "❌ Expected redirect to /home, but current URL is: " + driver.getCurrentUrl(),
                    redirected
                );

                System.out.println("✅ Successfully redirected to home page: " + driver.getCurrentUrl());
            } catch (Exception e) {
                e.printStackTrace();
                Assert.fail("❌ Redirect to " + expectedUrl + " failed. Current URL: " + driver.getCurrentUrl());
            }
    }

    @Then("the title of the page should be {string}")
    public void the_title_of_the_page_should_be(String expectedTitle) {
    	 waitUtils.waitForTitleContains(expectedTitle);
    	  Assert.assertEquals("❌ Page title mismatch!", expectedTitle, driver.getTitle());
          System.out.println("✅ Page title verified: " + driver.getTitle());
    }




}
	
	
	
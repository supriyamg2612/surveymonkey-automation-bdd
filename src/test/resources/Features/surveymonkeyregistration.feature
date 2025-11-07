# Project: surveymonkey application testing
# Application: surveymonkey
# Module: Sign Up Page
# Feature: Sign Up Page Validation
# Author: [Supriya Ghuge]
# Description: Verify that the surveymonkey Sign Up Page loads correctly with all essential UI components and navigation links.

Feature: Account Registration and Compliance
  As a new user seeking to create surveys,
  I want a smooth and compliant registration experience,
  So that I can quickly access the SurveyMonkey platform.
  
 
  Background: 
    Given user has opened the browser
    And the user navigates to the Sign Up page
  

  Scenario: Account creation using email (valid)
    When the user enters a valid SignUp email from config
    And the user agrees to the Terms of Use and Privacy Notice
    And the user clicks on the "Next" button
    Then the password creation page should be displayed in the same window
    When the user enters a valid SignUp password from config in the Password field
    And the user re-enters the same SignUp password from config in the Confirm Password field
    And the user clicks on the "Create Account" button
    Then the user should be redirected to the page "https://www.surveymonkey.com/home"
    And the title of the page should be "Welcome to SurveyMonkey!"

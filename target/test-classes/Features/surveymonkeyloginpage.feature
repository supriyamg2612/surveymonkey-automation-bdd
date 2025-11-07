# Project: surveymonkey application testing
# Application: surveymonkey
# Module: Login Page
# Feature: Login Up Page Validation
# Author: [Supriya Ghuge]
# Description: Verify that the surveymonkey Login Page loads correctly with all essential UI components and navigation links.

Feature: SurveyMonkey Login  
  In order to access their surveys and dashboard  
  As a registered user  
  Users should be able to log in to their SurveyMonkey account
  
 
  Background: 
    Given user has opened the browser
    And the user navigates to the Login Page

  Scenario: Successful login with valid credentials
	  When the user enters a valid login email from configuration file
    And the user clicks on the "Next" button from the login page
    Then the user should be navigated to the password entry page
    When the user enters a valid login password from config in the Password field
 		And the user clicks on the "Login" button from the login page
    And the title of the page should be "Home Page - Projects" this

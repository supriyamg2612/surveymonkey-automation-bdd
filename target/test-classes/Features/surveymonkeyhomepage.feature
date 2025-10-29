# Project: surveymonkey application testing
# Application: surveymonkey
# Module: Home Page
# Feature: Home Page Validation
# Author: [Supriya Ghuge]
# Description: Verify that the surveymonkey home page loads correctly with all essential UI components and navigation links.
Feature: SurveyMonkey Homepage
  As a user
  I want to verify the homepage elements and navigation
  So that I can access SignUp, Login, and other pages properly

  Background: 
    Given user has opened the browser

  # Functional Positive Test Scenarios
  Scenario: Verify Home Page loads successfully
    When the user navigates to Home Page
    Then the page should load without errors

  Scenario: Verify navigation to SignUp page
    Given the user is on the SurveyMonkey homepage
    When the user clicks the SignUp button
    Then verify the user is redirected to the registration page

  Scenario: Verify navigation to Login page
    Given the user is on the SurveyMonkey homepage
    When the user clicks the Login button
    Then verify the user is redirected to the login page

  Scenario: Verify clicking the SurveyMonkey logo redirects to homepage
    Given the user is on any page of the website
    When the user clicks the SurveyMonkey logo
    Then verify the user is redirected to the homepage

  #Functional Negative Test Scenarios
  Scenario: Verify homepage has no broken links
    Given the user is on the SurveyMonkey homepage
    Then verify no broken pages or 404 errors appear

  Scenario: Verify non-interactive elements are not clickable
    Given the user is on the SurveyMonkey homepage
    When the user tries to click non-interactive elements
    Then verify nothing happens
    
      # UI Test Scenarios
		Scenario: Verify SurveyMonkey logo is visible
    Given the user is on the SurveyMonkey homepage
    Then verify the SurveyMonkey logo is visible
package com.supriya.surveymonkey.runners;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)

@CucumberOptions(
		features = "src/test/resources/Features",      // path to feature files
		glue = {"com.supriya.surveymonkey.stepdefinitions", "com.supriya.surveymonkey.hooks"},// packages for step defs and hooks
		plugin = {"pretty", "junit:target/JUnitReports/report.xml",
						"json:target/JSONReport/report.json",
						"html:target/HtmlReports"},
	 monochrome = true,
	 dryRun = false,
	 tags = "@Logo"
	
				)
				
				
		

public class TestRunner {
	
	
}

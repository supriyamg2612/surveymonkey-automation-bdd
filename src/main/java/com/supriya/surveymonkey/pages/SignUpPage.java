package com.supriya.surveymonkey.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.supriya.surveymonkey.utilities.WaitUtils;

public class SignUpPage {
	
	
	WebDriver driver ;
    WaitUtils waitUtils;
    
    public SignUpPage(WebDriver driver) {
		this.driver=driver;
		this.waitUtils = new WaitUtils(driver, 10);
		PageFactory.initElements(driver, this);

	}
    

}

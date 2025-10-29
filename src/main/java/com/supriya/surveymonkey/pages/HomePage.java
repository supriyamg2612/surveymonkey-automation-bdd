package com.supriya.surveymonkey.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.supriya.surveymonkey.utilities.WaitUtils;

public class HomePage {
	
	WebDriver driver ;
    WaitUtils waitUtils;
	
    public HomePage(WebDriver driver) {
		this.driver=driver;
		this.waitUtils = new WaitUtils(driver, 10);
		PageFactory.initElements(driver, this);

	}
	
	
	@FindBy(css = "div.fides-banner-button-group.fides-banner-primary-actions") 
	private WebElement primaryButtonGroup;
	
	@FindBy(css = "#fides-banner-container button#fides-reject-all-button")
	private WebElement rejectCookiesButton;
	
	
	@FindBy(css = "#fides-banner-container button#fides-accept-all-button") 
	private WebElement acceptCookiesButton;
	
	@FindBy(linkText = "Sign up free")
	private WebElement signUpFreeLink;
	
	@FindBy(linkText = "Log in")
	private WebElement loginLink;
	
	@FindBy(css = "svg[fill='none'][height='290']")
	private WebElement surveymonkeyLogo;
	
	@FindBy(tagName = "a")
	private List<WebElement> allPageLinks;
	
	@FindBy(xpath = "//*[not(self::a or self::button or self::input or self::textarea)]")
	public List<WebElement> nonInteractiveElements;
	
	
	 
	 
	 public void dismissCookiesBanner() {
	        // Wait for the primary button group to be visible
	        WebElement group = waitUtils.waitForVisibility(primaryButtonGroup);
	        // Then wait for Reject All button to be clickable and click
	        WebElement rejectButton = waitUtils.waitForClickable(rejectCookiesButton);
	        rejectCookiesButton.click();
	    }

	 public void clickOnLoginLink() {
		 waitUtils.waitForClickable(loginLink).click();	    }
	 
	 
	 public void clickOnSignUpFreeLink() {
		 waitUtils.waitForClickable(signUpFreeLink).click();	    }
	 
	 public void clickSurveyMonkeyLogo() {
		 waitUtils.waitForClickable(surveymonkeyLogo).click();
	    }
	 
	 public List<WebElement> getAllPageLinks() {
	        return allPageLinks;
	    }
	 
	 public LoginPage openLoginPage() {
		 waitUtils.waitForClickable(loginLink).click();
		return  new LoginPage(driver);
	 }
	 
	 public SignUpPage openSignUpPage() {
		 waitUtils.waitForClickable(signUpFreeLink).click();	    
	 return  new SignUpPage(driver);
	 
}
}


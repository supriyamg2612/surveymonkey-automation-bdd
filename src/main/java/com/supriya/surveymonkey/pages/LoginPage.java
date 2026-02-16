package com.supriya.surveymonkey.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.supriya.surveymonkey.utilities.WaitUtils;

public class LoginPage {
	
	WebDriver driver ;
    public WaitUtils waitUtils;
    
    public LoginPage(WebDriver driver) {
		this.driver=driver;
		this.waitUtils = new WaitUtils(driver, 10);
		PageFactory.initElements(driver, this);

	}
    
    @FindBy(id = "username")
	private WebElement userEmailElement;
    
    @FindBy(id = "password")
	public WebElement userPasswordElement;
    
    @FindBy(css = "button[type='submit']")
	private WebElement nextButtonElement;
    
    @FindBy(xpath =  "//button[text()='Log in']")
   	private WebElement loginButtonElement;
    
    
    public void enterEmail(String email) {
   	 waitUtils.waitForVisibility(userEmailElement).clear();
   	userEmailElement.sendKeys(email);
   }
    
    public void enterPassword(String password) {
      	 waitUtils.waitForVisibility(userPasswordElement).clear();
      	userPasswordElement.sendKeys(password);
      }
    
    public void clickNextButton() {
    	waitUtils.waitForClickable(nextButtonElement).click();
    	
    }
    
    
    
    
    
    public void clickLoginButton() {
    	waitUtils.waitForClickable(loginButtonElement).click();
    	
    }
    
    public DashboardPage validLogin(String email,String password ) {
    	 enterEmail(email);
	     enterPassword(password);
		return new DashboardPage(driver);
    }
    
    
    

}

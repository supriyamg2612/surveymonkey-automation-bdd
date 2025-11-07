package com.supriya.surveymonkey.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
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
    
    @FindBy(id = "username")
	private WebElement emailElement;
    
    @FindBy(xpath = "//input[@id='tou-checkbox']")
    private WebElement termsCheckbox;
    
    @FindBy(xpath   = "//input[@id='privacy-checkbox']")
    private WebElement promotionsCheckbox;
    
    @FindBy(xpath  =  "//button[text() = 'Next']")
	private WebElement nextButtonElement;
    
    @FindBy(xpath = "//button[text() = 'Create account']")
	private WebElement createAccountButtonElement;
    
    @FindBy(id = "password")
	private WebElement passwordElement;
    
    @FindBy(id = "input1")
   	private WebElement confirmPasswordElement;
    
   
    
    
    public void enterEmail(String email) {
    	 waitUtils.waitForVisibility(emailElement).clear();
    	 emailElement.sendKeys(email);
    }
    public void enterPassword(String password) {
    	waitUtils.waitForVisibility(passwordElement).clear();
    	passwordElement.sendKeys(password);
    }
    public void enterConfirmPassword(String comfirmpassword) {
    	waitUtils.waitForVisibility(confirmPasswordElement).clear();
    	confirmPasswordElement.sendKeys(comfirmpassword);
    }
    
    
    
    public void checkTermsCheckbox() {
    	((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", termsCheckbox);
        if (!termsCheckbox.isSelected()) {
            try {
                waitUtils.waitForClickable(termsCheckbox).click();
            } catch (Exception e) {
                ((JavascriptExecutor) driver).executeScript("arguments[0].click();", termsCheckbox);
            }
            System.out.println("☑️ Checked Terms of Use and Privacy Notice");
        }
    }
    
    public void clickNextButton() {
    	
    	((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", nextButtonElement);
    	if (!nextButtonElement.isSelected()) {
            try {
                waitUtils.waitForClickable(nextButtonElement).click();
            } catch (Exception e) {
                ((JavascriptExecutor) driver).executeScript("arguments[0].click();", nextButtonElement);
            }
           
        
        System.out.println("➡️ Clicked on 'Next' button");
    }
    }

    public void clickCreateAccountButton() {
    	((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", createAccountButtonElement);
    	if (!createAccountButtonElement.isSelected()) {
            try {
                waitUtils.waitForClickable(createAccountButtonElement).click();
            } catch (Exception e) {
                ((JavascriptExecutor) driver).executeScript("arguments[0].click();", createAccountButtonElement);
            }
          
        
        System.out.println("➡️ Clicked on 'Next' button");
        
    }
    }
    
    public String generateUniqueEmail(String baseEmail) {
        if (!baseEmail.contains("@")) {
            throw new IllegalArgumentException("Invalid base email: " + baseEmail);
        }
        String[] parts = baseEmail.split("@");
        String timestamp = String.valueOf(System.currentTimeMillis());
        return parts[0] + "_" + timestamp + "@" + parts[1];
    }
    
}
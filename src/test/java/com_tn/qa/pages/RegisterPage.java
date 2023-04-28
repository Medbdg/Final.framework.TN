package com_tn.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterPage {

	public WebDriver driver;
	
	@FindBy (xpath = "//input[@id = 'input-firstname']")
	private WebElement firstName;
	
	@FindBy(xpath = "//input[@id = 'input-lastname']")
	private WebElement lastName;
	
	@FindBy (xpath = "//input[@id = 'input-email']")
	private WebElement emailAddress;
	
	@FindBy(xpath = "//input[@id = 'input-telephone']")
	private WebElement phoneNumber;
	
	@FindBy (xpath = "//input[@id = 'input-password']")
	private WebElement password;
	
	@FindBy(xpath = "//input[@id = 'input-confirm']")
	private WebElement confirmPassword;
	
	@FindBy (xpath = "//input[@name = 'agree']")
	private WebElement agreementCheckBox;
	
	@FindBy(xpath = "//input[@class = 'btn btn-primary']")
	private WebElement submitButton;
	
	public RegisterPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void enterFirstName(String FirstName) {
		firstName.sendKeys(FirstName);
	}
	public void enterLastName(String LastName) {
		lastName.sendKeys(LastName);
	}		
	public void enterEmailAddress(String EmailAddress) {
		emailAddress.sendKeys(EmailAddress);
	}				
	public void enterPhoneNumber(String PhoneNumber) {
		phoneNumber.sendKeys(PhoneNumber);			
	}				
	public void enterPassword(String Password) {
		password.sendKeys(Password);
	}	
	public void enterPasswordConfirmation(String PasswordConfirmation ) {
		confirmPassword.sendKeys(PasswordConfirmation);
    }
	public void clickOnAgreementCheckBox(String AgreeCheckBox) {
	    agreementCheckBox.click();
	}
	public void clickOnSubmitButton(String SubmitButton) {
		submitButton.click();
		
	}
}

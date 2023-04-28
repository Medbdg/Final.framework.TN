package com_tn.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.internal.WebElementToJsonConverter;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	public WebDriver driver;
    
	@FindBy(id = "input-email")
	private WebElement usernameTextBox;
	
	@FindBy(id = "input-password")
	private WebElement passwordTextBox;
	
    @FindBy(xpath  = "//*[@id=\"content\"]/div/div[2]/div/form/input")
    private WebElement signinButton;
    
    @FindBy(linkText = "Logout")
    private WebElement logoutLink;
    
    @FindBy(xpath = "//*[@id=\"account-login\"]/div[1]")
    private WebElement temporaryWarningMessageInvalidInfo;

    
    public LoginPage(WebDriver driver) {
    this.driver = driver;
    PageFactory.initElements(driver, this);
    }
    
    
    public void enterUsername(String usernameText) {
    	usernameTextBox.sendKeys(usernameText);
    }	
    public void enterPassword(String passwordText) {
    	passwordTextBox.sendKeys(passwordText);
    }

	public void clickOnsigninButton() {
		signinButton.click();
}
    public boolean LogoutLinkIsDisplayedOrNot() {
    	boolean displayedstatut = logoutLink.isDisplayed();
		return displayedstatut;
    }
   
    public String RetrieveErrorMessageInvalidInfo() {
    	String TempErrorMessageInvalidInfo = temporaryWarningMessageInvalidInfo.getText();
		return TempErrorMessageInvalidInfo;
    }

}


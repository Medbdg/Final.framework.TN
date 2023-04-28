package com_tn.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LandingPage {
    public WebDriver driver;
	
	@FindBy(linkText = "My Account")
	private WebElement MyAccount;
	
	@FindBy(linkText =  "Login")
	private WebElement Login;
	
	@FindBy(linkText = "Register")
	private WebElement Register;
	
	public LandingPage(WebDriver driver) {
	this.driver = driver;
	PageFactory.initElements(driver, this);
	}
	
	public void clickOnMyAccountLink() {
	MyAccount.click();
	}
	
	public void clickOnLoginLink() {
	Login.click();
    }
     
	public void clickOnRegisterLink() {
	Register.click();
	}
}
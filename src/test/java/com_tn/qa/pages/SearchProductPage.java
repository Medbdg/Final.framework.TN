package com_tn.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchProductPage {

	public WebDriver driver;
	
	@FindBy(xpath = "//input[@name = 'search']")
	private WebElement productName;
	
	@FindBy(xpath = "//*[@id=\"search\"]/span/button")
	private WebElement searchButton;

    public SearchProductPage(WebDriver driver) {
	this.driver = driver;
	PageFactory.initElements(driver, this);
    }
    
    public void enterProductName(String ProductName) {
    	productName.sendKeys(ProductName);
    }	
    public void ClickOnSearchButton(String SearchButton) {
    	searchButton.click();
    }
	}
    



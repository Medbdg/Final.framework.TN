package com_TN_Frameeworkdesign;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import com.TN.qa.testbase.Testbase;
import com_tn.qa.pages.SearchProductPage;

public class SearchProductTest  extends Testbase{

	public SearchProductTest() throws Exception {
		super();
	}

	public WebDriver driver;
	public SoftAssert softassert = new SoftAssert();
	
	@BeforeMethod
	public void setUp() {
	driver = InitializeBrowserAndOpenApplication("chrome");
	}

	
	@Test(priority = 1)
	public void VerifySearchingMacBookLaptop() {
	SearchProductPage searchProductPage = new SearchProductPage(driver);
	searchProductPage.enterProductName(dataProp.getProperty("FirstProductName"));
	searchProductPage.ClickOnSearchButton(dataProp.getProperty("SearchButton"));
	softassert.assertTrue(driver.findElement(By.xpath("//*[@id=\"content\"]/h2")).isDisplayed());
    softassert.assertAll();
	}
	
	@Test(priority = 2)
	public void verifySearchingDellLaptop() {
	SearchProductPage searchProductPage = new SearchProductPage(driver);
	searchProductPage.enterProductName(dataProp.getProperty("SecondProductName"));
	searchProductPage.ClickOnSearchButton(dataProp.getProperty("SearchButton"));
	softassert.assertTrue(driver.findElement(By.xpath("//*[@id=\"content\"]/p[2]")).isDisplayed());
    softassert.assertAll();
	}	
	
	@Test(priority = 3)
	public void verifySearchingWithEmptyTextbox() {
	SearchProductPage searchProductPage = new SearchProductPage(driver);
	searchProductPage.ClickOnSearchButton(dataProp.getProperty("SearchButton"));
	softassert.assertTrue(driver.findElement(By.xpath("//*[@id=\"content\"]/p[2]")).isDisplayed());
    softassert.assertAll();
	}	
	
	@Test(priority = 4)
	public void verifySearchingExistingProductAfterUserLogin() {

	driver.findElement(By.xpath("//*[@id=\"top-links\"]/ul/li[2]/a/span[1]")).click();		
	driver.findElement(By.xpath("//*[@id=\"top-links\"]/ul/li[2]/ul/li[2]/a")).click();
    driver.findElement(By.id("input-email")).sendKeys("med.boudguig@gmail.com");
    driver.findElement(By.id("input-password")).sendKeys("Medbdg0707@");
    driver.findElement(By.cssSelector("input.btn.btn-primary")).click();
	driver.findElement(By.xpath("//input[@name = 'search']")).sendKeys("Macbook");
    driver.findElement(By.xpath("//*[@id=\"search\"]/span/button")).click();
    softassert.assertTrue(driver.findElement(By.xpath("//*[@id=\"content\"]/h2")).isDisplayed());
	softassert.assertAll();
	}
	
	@AfterMethod
	public void tearDown() {
	driver.quit();
}}


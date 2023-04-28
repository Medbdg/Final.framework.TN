package com_TN_Frameeworkdesign;


import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import com.TN.qa.testData.SupplyTestData;
import com.TN.qa.testbase.Testbase;
import com_tn.qa.pages.LandingPage;
import com_tn.qa.pages.LoginPage;

public class LoginTest extends Testbase{
	
	public LoginTest() throws Exception {
		super();
	}
	public  WebDriver driver;
	public SoftAssert softassert = new SoftAssert();
	
	@BeforeMethod
	public void setUp() {
	driver = InitializeBrowserAndOpenApplication(prop.getProperty("browsername"));
	LandingPage landingpage = new LandingPage(driver);
	landingpage.clickOnMyAccountLink();
	landingpage.clickOnLoginLink();
	}
	
	@Test(priority = 1, dataProvider = "TNExceldataWithDataProvider", dataProviderClass = SupplyTestData.class)
	public void verifyLoginTutorialninjaWithValidUserNameAndValidPassword(String username, String password){
		
	    LoginPage loginPage = new LoginPage(driver);
	    loginPage.enterUsername(username);
	    loginPage.enterPassword(password);
	    loginPage.clickOnsigninButton();  
	    softassert.assertTrue(loginPage.LogoutLinkIsDisplayedOrNot());
        softassert.assertAll();  
	}

	@Test(priority = 2)
	public void verifyLoginTutorialninjaWithInvalidUserNameAndInvalidPassword (){
	    LoginPage loginPage = new LoginPage(driver);
	    loginPage.enterUsername(dataProp.getProperty("InvalidUsername"));
	    loginPage.enterPassword(dataProp.getProperty("InvalidPassword"));
	    loginPage.clickOnsigninButton();
	    String actualWarningMessage = loginPage.RetrieveErrorMessageInvalidInfo();
        String expectedWarningMessage = dataProp.getProperty("ExpectedWarningMessage");
        softassert.assertTrue(actualWarningMessage.contains(expectedWarningMessage),dataProp.getProperty(actualWarningMessage));
        softassert.assertAll();    
	}       
	
	@Test(priority = 3) 
	public void verifyLoginTutorialninjaWithvalidUserNameAndInvalidPassword () {
	    LoginPage loginPage = new LoginPage(driver);
        loginPage.enterUsername("validusername");
        loginPage.enterPassword(dataProp.getProperty("InvalidPassword"));
        loginPage.clickOnsigninButton();
        String actualWarningMessage = loginPage.RetrieveErrorMessageInvalidInfo();
        String expectedWarningMessage = dataProp.getProperty("ExpectedWarningMessage");
        softassert.assertTrue(actualWarningMessage.contains(expectedWarningMessage),dataProp.getProperty(actualWarningMessage));
        softassert.assertAll();  
	}       
	
	@Test(priority = 4)
	public void verifyLoginTutorialninjaWithInvalidUserNameAndvalidPassword (){
		LoginPage loginPage = new LoginPage(driver);
        loginPage.enterUsername("InvalidUsername");
        loginPage.enterPassword("validPassword");
        loginPage.clickOnsigninButton();
        String actualWarningMessage = loginPage.RetrieveErrorMessageInvalidInfo();
        String expectedWarningMessage = dataProp.getProperty("ExpectedWarningMessage");
        softassert.assertTrue(actualWarningMessage.contains(expectedWarningMessage),dataProp.getProperty(actualWarningMessage));
        softassert.assertAll();     
	}
	
	@Test(priority = 5)
	public void verifyLoginTutorialninjaWithEmptyUserNameAndvalidPassword (){
		LoginPage loginPage = new LoginPage(driver);
		loginPage.enterPassword("validPassword");
		loginPage.clickOnsigninButton();
		String actualWarningMessage = loginPage.RetrieveErrorMessageInvalidInfo();
        String expectedWarningMessage = dataProp.getProperty("ExpectedWarningMessage");
        softassert.assertTrue(actualWarningMessage.contains(expectedWarningMessage),dataProp.getProperty(actualWarningMessage));
        softassert.assertAll(); 
}
	@Test(priority = 6)
	public void verifyLoginTutorialninjaWithValidUserNameAndEmptyPassword (){
		LoginPage loginPage = new LoginPage(driver);
		loginPage.enterPassword("validPassword");
		loginPage.clickOnsigninButton();
		String actualWarningMessage = loginPage.RetrieveErrorMessageInvalidInfo();
        String expectedWarningMessage = dataProp.getProperty("ExpectedWarningMessage");
        softassert.assertTrue(actualWarningMessage.contains(expectedWarningMessage),dataProp.getProperty(actualWarningMessage));
        softassert.assertAll(); 
	}
	@AfterMethod
	public void tearDown() {
	driver.quit();
	}
}
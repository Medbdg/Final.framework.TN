package com_TN_Frameeworkdesign;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import com.TN.qa.testbase.Testbase;
import com.tn.utili.TN_utili;
import com_tn.qa.pages.LandingPage;
import com_tn.qa.pages.RegisterPage;

public class RegisterTest extends Testbase{

	public RegisterTest() throws Exception {
		super();
	}
	public WebDriver driver;
	public SoftAssert softassert = new SoftAssert();
	
	@BeforeMethod
	public void setUp() {
	driver = InitializeBrowserAndOpenApplication("chrome");
	LandingPage landingpage = new LandingPage(driver);
	landingpage.clickOnMyAccountLink();
	landingpage.clickOnRegisterLink();
	}
	
    @Test(priority = 1)
    public void verifyRegisterAnAccountWithNewUserInfo () {
    
    RegisterPage registerPage = new RegisterPage(driver);
    registerPage.enterFirstName(dataProp.getProperty("FirstName"));
    registerPage.enterLastName(dataProp.getProperty("LastName"));
    registerPage.enterEmailAddress(TN_utili.generateEmailWithThisTimeStamp());
    registerPage.enterPhoneNumber(dataProp.getProperty("PhoneNumber"));
    registerPage.enterPassword(dataProp.getProperty("Password"));
    registerPage.enterPasswordConfirmation(dataProp.getProperty("PasswordConfirmation"));
    registerPage.clickOnAgreementCheckBox(dataProp.getProperty("AgreementCheckBox"));
    registerPage.clickOnSubmitButton(dataProp.getProperty("SubmitButton"));
	String actualCongratulationsMessage = driver.findElement(By.xpath("//*[@id=\"content\"]/h1")).getText();
    String expectedCongratulationsMessage = "Your Account Has Been Created!";
    softassert.assertTrue(actualCongratulationsMessage.contains(expectedCongratulationsMessage),"Account created Message is not Correct");
    softassert.assertAll();   
    }
    
    @Test(priority = 2)
    public void verifyRegisterAccountWithExistingUserInfo() {
    
    RegisterPage registerPage = new RegisterPage(driver);
    registerPage.enterFirstName(dataProp.getProperty("FirstName"));
    registerPage.enterLastName(dataProp.getProperty("LastName"));
    registerPage.enterEmailAddress(prop.getProperty("validusername"));
    registerPage.enterPhoneNumber(dataProp.getProperty("PhoneNumber"));
    registerPage.enterPassword(dataProp.getProperty("Password"));
    registerPage.enterPasswordConfirmation(dataProp.getProperty("PasswordConfirmation"));
    registerPage.clickOnAgreementCheckBox(dataProp.getProperty("AgreementCheckBox"));
    registerPage.clickOnSubmitButton(dataProp.getProperty("SubmitButton"));
    String actualWarningMessage = driver.findElement(By.xpath("//*[@id=\"account-register\"]/div[1]")).getText();
    String expectedWarningMessage = "Warning: E-Mail Address is already registered!";
    softassert.assertTrue(actualWarningMessage.contains(expectedWarningMessage),"Warning Message is not Correct");
    softassert.assertAll(); 
    }
    
    @Test(priority = 3)
    public void verifyRegisterAccountUsingOnlyNumbersAsPassword() {
    
    RegisterPage registerPage = new RegisterPage(driver);
    registerPage.enterFirstName(dataProp.getProperty("FirstName"));
    registerPage.enterLastName(dataProp.getProperty("LastName"));
    registerPage.enterEmailAddress(TN_utili.generateEmailWithThisTimeStamp());
    registerPage.enterPhoneNumber(dataProp.getProperty("PhoneNumber"));
    registerPage.enterPassword(dataProp.getProperty("OnlyNumbersAsPassword"));
    registerPage.enterPasswordConfirmation(dataProp.getProperty("ConfirmationOnlyNumbersAsPassword"));
    registerPage.clickOnAgreementCheckBox(dataProp.getProperty("AgreementCheckBox"));
    registerPage.clickOnSubmitButton(dataProp.getProperty("SubmitButton"));
   	String actualCongratulationsMessage = driver.findElement(By.xpath("//*[@id=\"content\"]/h1")).getText();
    String expectedCongratulationsMessage = "Your Account Has Been Created!";
    softassert.assertTrue(actualCongratulationsMessage.contains(expectedCongratulationsMessage),"Account created Message is not Correct");
    softassert.assertAll();   
}
    @Test(priority = 4)
    public void verifyRegisterAccountWithForeignPhoneNumber() {
    
	RegisterPage registerPage = new RegisterPage(driver);
    registerPage.enterFirstName(dataProp.getProperty("FirstName"));
    registerPage.enterLastName(dataProp.getProperty("LastName"));
    registerPage.enterEmailAddress(TN_utili.generateEmailWithThisTimeStamp());
    registerPage.enterPhoneNumber(dataProp.getProperty("foreignPhoneNumber"));
    registerPage.enterPassword(dataProp.getProperty("Password"));
    registerPage.enterPasswordConfirmation(dataProp.getProperty("PasswordConfirmation"));
    registerPage.clickOnAgreementCheckBox(dataProp.getProperty("AgreementCheckBox"));
    registerPage.clickOnSubmitButton(dataProp.getProperty("SubmitButton"));
    String actualCongratulationsMessage = driver.findElement(By.xpath("//*[@id=\"content\"]/h1")).getText();
    String expectedCongratulationsMessage = "Your Account Has Been Created!";
    softassert.assertTrue(actualCongratulationsMessage.contains(expectedCongratulationsMessage),"Account created Message is not Correct");
    softassert.assertAll();   
    }
    @Test(priority = 5)
    public void verifyRegisterAccountWithEmptyEmailTextbox() {
    	
    RegisterPage registerPage = new RegisterPage(driver);
    registerPage.enterFirstName(dataProp.getProperty("FirstName"));
    registerPage.enterLastName(dataProp.getProperty("LastName"));
    registerPage.enterPhoneNumber(dataProp.getProperty("PhoneNumber"));
    registerPage.enterPassword(dataProp.getProperty("Password"));
    registerPage.enterPasswordConfirmation(dataProp.getProperty("PasswordConfirmation"));
    registerPage.clickOnAgreementCheckBox(dataProp.getProperty("AgreementCheckBox"));
    registerPage.clickOnSubmitButton(dataProp.getProperty("SubmitButton"));
  	String actualWarningMessage = driver.findElement(By.xpath("//*[@id=\"account\"]/div[4]/div/div")).getText();
    String expectedWarningMessage = "E-Mail Address does not appear to be valid!";
    softassert.assertTrue(actualWarningMessage.contains(expectedWarningMessage),"Account created Message is not Correct");
    softassert.assertAll();   	
    }
    
    @Test(priority = 6)
  public void verifyRegisterAccountWithEmptyPasswordTextbox() {
    
  RegisterPage registerPage = new RegisterPage(driver);
  registerPage.enterFirstName(dataProp.getProperty("FirstName"));
  registerPage.enterLastName(dataProp.getProperty("LastName"));
  registerPage.enterEmailAddress(TN_utili.generateEmailWithThisTimeStamp());
  registerPage.enterPhoneNumber(dataProp.getProperty("PhoneNumber"));
  registerPage.enterPasswordConfirmation(dataProp.getProperty("PasswordConfirmation"));
  registerPage.clickOnAgreementCheckBox(dataProp.getProperty("AgreementCheckBox"));
  registerPage.clickOnSubmitButton(dataProp.getProperty("SubmitButton"));
  String actualWarningMessagefirstpasswordbox = driver.findElement(By.xpath("/html/body/div[2]/div/div/form/fieldset[2]/div[1]/div/div")).getText();
  String expectedWarningMessagefirstpasswordbox = "Password must be between 4 and 20 characters!";    softassert.assertTrue(actualWarningMessagefirstpasswordbox.contains(expectedWarningMessagefirstpasswordbox),"Account created Message is not Correct"); 
  softassert.assertAll();   	
    }
    
    @AfterMethod
	public void tearDown() {
	
	driver.quit();
}
}
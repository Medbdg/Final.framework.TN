package com.TN.qa.testbase;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.tn.utili.TN_utili;

public class Testbase {
	
	public WebDriver driver;
	public Properties prop;
	public Properties dataProp;
	public FileInputStream ip;
	public Testbase () throws Exception {
		prop = new Properties ();
		ip  = new FileInputStream(System.getProperty("user.dir") + "\\src\\main\\java\\com\\tn\\qa\\config\\config.properties");
        prop.load(ip);	
	
	    dataProp = new Properties();
	    ip = new FileInputStream(System.getProperty("user.dir")+ "\\src\\test\\java\\com\\TN\\qa\\testData\\testData.properties");
	    dataProp.load(ip);
	}    
	public WebDriver InitializeBrowserAndOpenApplication(String browserName) {
		
		if(browserName.equalsIgnoreCase("chrome")){
		ChromeOptions op= new ChromeOptions();
		op.addArguments("--remote-allow-origins=*"); 
		driver = new ChromeDriver(op);
	   }else if(browserName.equalsIgnoreCase("edge")) {
	    driver = new EdgeDriver();
	   }else if(browserName.equalsIgnoreCase("firefox")) {
		driver = new FirefoxDriver();
	   }
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(TN_utili.implitWaitTime));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(TN_utili.pageLoadTime));
		driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(TN_utili.scriptTime));
		driver.get(prop.getProperty("url"));
		
		return driver;
		
	}}

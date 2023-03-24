/**
 * 
 */
package com.swaglabs.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import com.swaglabs.actiondriver.Action;
import com.swaglabs.utility.ExtentManager;

import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * @author Dinesh
 *
 */
public class BaseClass {
	
	public static Properties prop;
	//public static WebDriver driver1;
	public static ThreadLocal<RemoteWebDriver> driver = new ThreadLocal<>();
	
	@BeforeSuite(groups= {"Smoke","Sanity","Regression"})
	public static void ReadConfig() {
		DOMConfigurator.configure("log4j.xml");
		ExtentManager.setExtent();
		

		try {
			prop = new Properties();
			FileInputStream ip = new FileInputStream(
					System.getProperty("user.dir")+"\\Configurations\\config.properties");
			//driver=new ChromeDriver();
			prop.load(ip);

		} catch (FileNotFoundException e) {
			e.printStackTrace(); 
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	public static WebDriver getDriver() {
		// Get Driver from threadLocalmap
		return driver.get();
	}



		
		
	
	
	public static void launchApp(String browserName)
	{
		WebDriverManager.chromedriver().setup();
		//String browserName=prop.getProperty("browser");
		
		if(browserName.contains("Chrome")) {
			WebDriverManager.chromedriver().setup();
			//System.setProperty("webdriver.chrome.driver", "C:/Users/Lenovo/Downloads/chromedriver_win32 (1)/chromedriver.exe");
			
			driver.set(new ChromeDriver());
		}else if (browserName.equalsIgnoreCase("FireFox")) {
			WebDriverManager.firefoxdriver().setup();
			// driver = new FirefoxDriver();
			driver.set(new FirefoxDriver());
		} else if (browserName.equalsIgnoreCase("IE")) {
			WebDriverManager.iedriver().setup();
			// driver = new InternetExplorerDriver();
			driver.set(new InternetExplorerDriver());
		}
		getDriver().manage().window().maximize();
		Action.implicitWait(getDriver(), 20);
		Action.pageLoadTimeOut(getDriver(), 30);
		getDriver().get(prop.getProperty("url"));	
	}
	
	@AfterSuite(groups= {"Smoke","Sanity","Regression"})
	public static void afterSuite() {
		ExtentManager.endReport();
	}
	
	
}

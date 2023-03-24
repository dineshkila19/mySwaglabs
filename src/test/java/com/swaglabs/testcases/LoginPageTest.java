/**
 * 
 */
package com.swaglabs.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.swaglabs.base.BaseClass;
import com.swaglabs.dataprovider.DataProviders;
import com.swaglabs.pageobjects.HomePage;
import com.swaglabs.pageobjects.LoginPage;
import com.swaglabs.utility.log;

/**
 * @author Dinesh
 *
 */
public class LoginPageTest extends BaseClass{
	LoginPage loginPage;
	HomePage homePage;
	
	@Parameters("browser")
	@BeforeMethod(groups= {"Smoke","Sanity","Regression"})
	public void setUp(String browser) {
		launchApp(browser);
	}
	
	
	@AfterMethod(groups= {"Smoke","Sanity","Regression"})
	public void tearDown() {
		getDriver().quit();
	}
	
	@Test(dataProvider="SwaglabsLoginData" , dataProviderClass=DataProviders.class , groups= {"Smoke","Sanity"})
	public void loginTest(String uname, String upwd) {
		log.startTestCase("loginTest");
		LoginPage loginPage=new LoginPage();
		log.info("User is going to enter username and password");
		//homePage=loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		homePage=loginPage.login(uname, upwd);
		log.info("User is successfully entered properties");
		String actURL=homePage.getCurrentURL();
		String expURL="https://www.saucedemo.com/inventory.html";
		Assert.assertEquals(actURL, expURL);
		log.info("User is successfully compare actual and expected URLs");
		log.info("loginTest is passed");
		log.endTestCase("loginTest");
		
	}
	

}

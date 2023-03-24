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
import com.swaglabs.pageobjects.HomePage;
import com.swaglabs.pageobjects.LoginPage;
import com.swaglabs.utility.log;

/**
 * @author Lenovo
 *
 */
public class HomePageTest extends BaseClass{
	
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
	
	@Test(groups="Smoke")
	public void verifyMyLogo() {
		log.startTestCase("verifyMyLogo");
		LoginPage loginPage=new LoginPage();
		homePage=loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		boolean reasult=homePage.validateMyLogo();
		Assert.assertTrue(reasult);
		log.info("User is successfully verify's the Logo");
		log.endTestCase("verifyMyLogo");
		
	}
	
	@Test
	public void selectJacketTest() {
		log.startTestCase("selectJacketTest");
		LoginPage loginPage=new LoginPage();
		homePage=loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		homePage.selectFleeceJacket();
		log.info("User successfully selected the Jacket");
		log.info("selectJacketTest is passed");
		log.endTestCase("selectJacketTest");
	}
	

}

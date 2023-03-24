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
import com.swaglabs.pageobjects.AddToCartPage;
import com.swaglabs.pageobjects.HomePage;
import com.swaglabs.pageobjects.LoginPage;
import com.swaglabs.utility.log;

/**
 * @author Dinesh
 *
 */
public class AddToCartPageTest extends BaseClass{
	
	LoginPage loginPage;
	HomePage homePage;
	AddToCartPage addToCartPage;
	
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
	public void verifyShoppingCart() {
		log.startTestCase("verifyShoppingCart");
		LoginPage loginPage=new LoginPage();
		homePage=loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		addToCartPage=homePage.selectFleeceJacket();
		boolean reasult=addToCartPage.validateShoppingCart();
		log.info("User successfully verifying the shopping cart");
		Assert.assertTrue(reasult);
		log.info("verifyShoppingCart is Passed");
		log.endTestCase("verifyShoppingCart");
	}
	
	@Test(groups= {"Smoke","Sanity"})
	public void AddToCartTest() {
		log.startTestCase("AddToCartTest");
		LoginPage loginPage=new LoginPage();
		homePage=loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		addToCartPage=homePage.selectFleeceJacket();
		addToCartPage.clickOnAddToCart();
		log.info("User is successfully clicking the AddtoCart");
		log.info("AddToCartTest is Passed");
		log.endTestCase("AddToCartTest");
	}
	
	
	

}

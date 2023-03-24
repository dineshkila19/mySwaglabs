/**
 * 
 */
package com.swaglabs.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.swaglabs.base.BaseClass;
import com.swaglabs.pageobjects.AddToCartPage;
import com.swaglabs.pageobjects.HomePage;
import com.swaglabs.pageobjects.LoginPage;
import com.swaglabs.pageobjects.ShoppingCartPage;
import com.swaglabs.utility.log;

/**
 * @author Dinesh
 *
 */
public class ShoppingCartPageTest extends BaseClass{
	
	LoginPage loginPage;
	HomePage homePage;
	AddToCartPage addToCartPage;
	ShoppingCartPage shoppingCartPage;
	
	@Parameters("browser")
	@BeforeMethod(groups= {"Smoke","Sanity","Regression"})
	public void setUp(String browser) {
		launchApp(browser);
	}
	
	@AfterMethod(groups= {"Smoke","Sanity","Regression"})
	public void tearDown() {
		getDriver().quit();
	}
	
	@Test(groups= {"Smoke","Sanity"})
	public void ShoppingCartPageTest() {
		log.startTestCase("ShoppingCartPageTest");
		LoginPage loginPage=new LoginPage();
		homePage=loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		addToCartPage=homePage.selectFleeceJacket();
		shoppingCartPage=addToCartPage.clickOnAddToCart();
		shoppingCartPage.clickOnCheckOut();
		log.info("User is successfully clicking the checkout");
		log.info("ShoppingCartPageTest is Passed");
		log.endTestCase("ShoppingCartPageTest");
	}
	
	
	
	

}

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
import com.swaglabs.pageobjects.AddressPage;
import com.swaglabs.pageobjects.HomePage;
import com.swaglabs.pageobjects.LoginPage;
import com.swaglabs.pageobjects.ShoppingCartPage;
import com.swaglabs.utility.log;

/**
 * @author Lenovo
 *
 */
public class AddressPageTest extends BaseClass{
	
	LoginPage loginPage;
	HomePage homePage;
	AddToCartPage addToCartPage;
	ShoppingCartPage shoppingCartPage;
	AddressPage addressPage;
	
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
	public void AddressPageTest() {
		log.startTestCase("AddressPageTest");
		LoginPage loginPage=new LoginPage();
		homePage=loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		addToCartPage=homePage.selectFleeceJacket();
		shoppingCartPage=addToCartPage.clickOnAddToCart();
		addressPage=shoppingCartPage.clickOnCheckOut();
		addressPage.addDetails("raja", "kila", "517667");
		log.info("User is successfully entered Address");
		log.info("AddressPageTest is Passed");
		log.endTestCase("AddressPageTest");
	}
	

}

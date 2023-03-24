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
import com.swaglabs.pageobjects.AddressPage;
import com.swaglabs.pageobjects.CheckOutPage;
import com.swaglabs.pageobjects.HomePage;
import com.swaglabs.pageobjects.LoginPage;
import com.swaglabs.pageobjects.ShoppingCartPage;
import com.swaglabs.utility.log;

/**
 * @author Lenovo
 *
 */
public class CheckOutPageTest extends BaseClass{
	
	LoginPage loginPage;
	HomePage homePage;
	AddToCartPage addToCartPage;
	ShoppingCartPage shoppingCartPage;
	AddressPage addressPage;
	CheckOutPage checkOutPage;
	
	@Parameters("browser")
	@BeforeMethod(groups= {"Smoke","Sanity","Regression"})
	public void setUp(String browser) {
		launchApp(browser);
	}
	
	@AfterMethod(groups= {"Smoke","Sanity","Regression"})
	public void tearDown() {
		getDriver().quit();
	}
	
	@Test(groups= "Regression")
	public void CheckOutPageTest() {
		log.startTestCase("CheckOutPageTest");
		LoginPage loginPage=new LoginPage();
		homePage=loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		log.info("User successfully entered the username and password");
		addToCartPage=homePage.selectFleeceJacket();
		log.info("User successfully selected the FleeceJacket");
		shoppingCartPage=addToCartPage.clickOnAddToCart();
		log.info("User clicking the AddToCart ");
		addressPage=shoppingCartPage.clickOnCheckOut();
		log.info("user successfully clickon the checkout");
		checkOutPage=addressPage.addDetails("raja", "kila", "517667");
		log.info("User is successfully entered the Address");
		checkOutPage.clickOnFinish();
		log.info("User is successfully click the finish");
		boolean reasult=checkOutPage.validateSuccessMsg();
		log.info("User is successfully verifying the successMSG");
		Assert.assertTrue(reasult);
		log.info("CheckOutPageTest is Passed");
		log.endTestCase("CheckOutPageTest");
	}
	
	

}

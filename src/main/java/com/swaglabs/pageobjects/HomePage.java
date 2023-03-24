/**
 * 
 */
package com.swaglabs.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.swaglabs.actiondriver.Action;
import com.swaglabs.base.BaseClass;

/**
 * @author Lenovo
 *
 */
public class HomePage extends BaseClass{
	
	@FindBy(xpath="//*[@class='primary_header']/div[2]/div")
	WebElement myLogo;
	
	@FindBy(xpath="//*[contains(text(),'Sauce Labs Fleece Jacket')]")
	WebElement fleeceJacket;
	
	public HomePage() {
		PageFactory.initElements(getDriver(), this);
	}
	
	public boolean validateMyLogo() {
		return Action.isDisplayed(getDriver(), myLogo);
	}
	
	public String getCurrentURL() {
		String currentURL=getDriver().getCurrentUrl();
		return currentURL;
	}
	
	public AddToCartPage selectFleeceJacket() {
		Action.click(getDriver(), fleeceJacket);
		return new AddToCartPage();
	}
	

}

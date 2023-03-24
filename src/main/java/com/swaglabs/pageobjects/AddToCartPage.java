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
 * @author Dinesh
 *
 */
public class AddToCartPage extends BaseClass{
	
	@FindBy(xpath="//*[@id='add-to-cart-sauce-labs-fleece-jacket']")
	WebElement addToCartBtn;
	
	@FindBy(xpath="//div[@class='primary_header']/div[3]/a")
	WebElement shoppingCart;
	
	public AddToCartPage() {
		PageFactory.initElements(getDriver(), this);
	}
	
	public ShoppingCartPage clickOnAddToCart() {
		Action.click(getDriver(), addToCartBtn);
		Action.click(getDriver(), shoppingCart);
		return new ShoppingCartPage();
	}
	
	public boolean validateShoppingCart() {
		return Action.isDisplayed(getDriver(), addToCartBtn);
	}
	
	
	

}

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
public class ShoppingCartPage extends BaseClass{
	
	@FindBy(id="checkout")
	WebElement checkOutBtn;
	
	public ShoppingCartPage() {
		PageFactory.initElements(getDriver(), this);
	}
	
	public AddressPage clickOnCheckOut() {
		Action.click(getDriver(), checkOutBtn);
		return new AddressPage();
	}

}

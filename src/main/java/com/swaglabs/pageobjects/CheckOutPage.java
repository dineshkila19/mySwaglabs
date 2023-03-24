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
public class CheckOutPage extends BaseClass{
	
	@FindBy(id="finish")
	WebElement finishBtn;
	
	@FindBy(xpath="//*[contains(text(),'Checkout: Complete!')]")
	WebElement successMsg;
	
	public CheckOutPage() {
		PageFactory.initElements(getDriver(), this);
	}
	
	public void clickOnFinish() {
		Action.click(getDriver(), finishBtn);
	}
	
	public boolean validateSuccessMsg() {
		return Action.isDisplayed(getDriver(), successMsg);
		
	}

}

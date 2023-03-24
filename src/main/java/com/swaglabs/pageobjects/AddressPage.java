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
public class AddressPage extends BaseClass{
	
	@FindBy(id="first-name")
	WebElement txtFirstName;
	
	@FindBy(id="last-name")
	WebElement txtLastName;
	
	@FindBy(id="postal-code")
	WebElement txtZipCode;
	
	@FindBy(xpath="//input[@id='continue']")
	WebElement continueBtn;
	
	public AddressPage() {
		PageFactory.initElements(getDriver(), this);
		}
	
	public CheckOutPage addDetails(String fname, String lname, String zcode) {
		Action.type(txtFirstName, fname);
		Action.type(txtLastName, lname);
		Action.type(txtZipCode, zcode);
		Action.click(getDriver(), continueBtn);
		return new CheckOutPage();
	}
	
	
	

}

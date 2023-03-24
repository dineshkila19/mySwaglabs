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
public class LoginPage extends BaseClass{
	
	@FindBy(xpath="//input[@id='user-name']")
	WebElement txtusername;
	
	@FindBy(xpath="//input[@id='password']")
	WebElement txtpassword;
	
	@FindBy(xpath="//input[@id='login-button']")
	WebElement loginBtn;
	
	public LoginPage() {
		PageFactory.initElements(getDriver(), this);
	}
	
	public HomePage login(String uname, String upwd) {
		Action.type(txtusername, uname);
		Action.type(txtpassword, upwd);
		Action.click(getDriver(), loginBtn);
		return new HomePage();
	}
	
	

}

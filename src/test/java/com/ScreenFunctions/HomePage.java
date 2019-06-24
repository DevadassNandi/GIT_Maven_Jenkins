package com.ScreenFunctions;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import com.GenericMethods.GenericMethods;

public class HomePage extends GenericMethods{
	
	// http://automationpractice.com/index.php?
	// Page Object Model
	// ****************Identify WebElements**************************
	// add contact us
	// add Signin

	@FindBy(how=How.XPATH, using="//a[text()='Contact us']")
	public WebElement lnk_ContactUs;
	
	@FindBy(how=How.XPATH, using="//a[normalize-space(text())='Sign in']")
	public WebElement lnk_SignIn;
	
	// Method Implementation
	// Method to verify contact as 

	// Method to verify contact us
	/*
	 * @methodName : click_ContactUs
	 * @purpose    : To click on Contact Us link
	 * @parameters : Not Applicable
	 * @return     : Boolean
	 * @author     : Prathap
	 */
	
	// Method to verify signin
	/*
	 * @methodName : click_SignIn
	 * @purpose    : To click on Signin link
	 * @parameters : Not Applicable
	 * @return     : Boolean
	 * @author     : Prathap
	 */
	
	public boolean click_SignIn() {
		boolean status = true;
		
		try {
			status = HoverAndClick("HomePage", "SingIn", lnk_SignIn);
			
			if (status) {
				
			}
			System.out.println("click sign in method");
			
		}catch (Exception e) {
			status = false;
			System.out.println(e.getMessage());
		}
		return status;
		
	}



}

	
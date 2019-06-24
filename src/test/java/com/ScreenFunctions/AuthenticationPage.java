package com.ScreenFunctions;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import com.GenericMethods.GenericMethods;

public class AuthenticationPage extends GenericMethods{
	
	public String email;
	// http://automationpractice.com/index.php?
	// Page Object Model
	// ****************Identify WebElements**************************
	// add contact us
	// add Signin

	@FindBy(how=How.XPATH, using="//h1[text()='Authentication']")
	public WebElement txt_Authentication_header;
	
	@FindBy(how=How.XPATH, using="//input[@id='email_create']")
	public WebElement edi_emailID_newUser;
	
	@FindBy(how=How.XPATH, using="//button[@id='SubmitCreate']")
	public WebElement btn_CreatAccount;
	
	//************     User Details ***************************************
	
	@FindBy(how=How.XPATH, using="//input[@id='id_gender1']")
	public WebElement rbn_gender_male;
	
	@FindBy(how=How.XPATH, using="//input[@id='id_gender2']")
	public WebElement rbn_gender_female;

	@FindBy(how=How.XPATH, using="//input[@id='customer_firstname']")
	public WebElement edi_FirstName;
	
	@FindBy(how=How.XPATH, using="//input[@id='customer_lastname']")
	public WebElement edi_LastName;
	
	@FindBy(how=How.XPATH, using="//input[contains(@id,'email')]")
	public WebElement edi_Email;
	
	
	@FindBy(how=How.XPATH, using="//input[@id='passwd']")
	public WebElement edi_PassWord;
	
	@FindBy(how=How.XPATH,using="//select[@id='days']")
	public WebElement slct_DOB_days;
	
	@FindBy(how=How.XPATH,using="//select[@id='months']")
	public WebElement slct_DOB_months;
	
	@FindBy(how=How.XPATH,using="//select[@id='years']")
	public WebElement slct_DOB_years;
	
	@FindBy(how=How.XPATH,using="//input[@id='firstname']")
	public WebElement txt_Address_firstname;
	
	@FindBy(how=How.XPATH,using="//input[@id='lastname']")
	public WebElement txt_Address_lasttname;
	
	@FindBy(how=How.XPATH,using="//input[@id='address1']")
	public WebElement txt_Address_Address1;
	
	@FindBy(how=How.XPATH,using="//input[@id='address2']")
	public WebElement txt_Address_Address2;
	
	@FindBy(how=How.XPATH,using="//input[@id='city']")
	public WebElement txt_Address_city;
	
	@FindBy(how=How.XPATH,using="//select[@id='id_state']")
	public WebElement slct_Address_state;
	
	@FindBy(how=How.XPATH,using="//input[@id='postcode']")
	public WebElement slct_Address_zip;
	
	@FindBy(how=How.XPATH,using="//select[@id='id_country']")
	public WebElement slct_Address_country;
	
	@FindBy(how=How.XPATH,using="//input[@id='phone_mobile']")
	public WebElement txt_Address_mobilenumber;
	
	@FindBy(how=How.XPATH,using="//input[@id='alias']")
	public WebElement txt_Address_aliasAddress;
	
	@FindBy(how=How.XPATH,using="//button[@id='submitAccount']")
	public WebElement btn_Register;

	//**************** Logout Section **********************
	
	@FindBy(how=How.XPATH,using="(//a[normalize-space(text())='Sign out'])[1]")
	public WebElement lnk_Signout;
	
	
	@FindBy(how=How.XPATH,using="//button[@id='SubmitLogin']")
	public WebElement btn_submitlogin;
	
	
	//*************************************** Methods Implementation ********************
	
	/*
	 * @methodName : verify_AuthenticationHeader
	 * @purpose    : To click on Contact Us link
	 * @parameters : Not Applicable
	 * @return     : Boolean
	 * @author     : Nandi
	 */
	
	public boolean verify_AuthenticationHeader() {
		boolean status = true;
		try {
			status = verify_ElementExist("Authentication", " Authentication_Section Header", txt_Authentication_header);
		}catch (Exception e) {
			status = false;
		}
		
		return status;
	}

	/*
	 * @methodName : newUser_EnterEmailId
	 * @purpose    : This method designed to register new user
	 * @parameters : Not Applicable
	 * @return     : Boolean
	 * @author     : Nandi
	 */
	
	public boolean newUser_EnterEmailId() {
		boolean status = true;
		
		try {
			// Create unique email id
			SimpleDateFormat sdf = new SimpleDateFormat("hhmmsss");
			Date d = new Date();
			
			String emailid = "abc.xyz@gmail.com";
			
			System.out.println(sdf.format(d));
			
			email = emailid.split("@")[0]+"_"+sdf.format(d)+"@"+emailid.split("@")[1];
			
			System.out.println(email);
			
			status = ClickAndSendData("Email Id", "Authentication", edi_emailID_newUser, email);
			
			// Check status of email id data entry and click on the register button
			
			if (status) {
				status = HoverAndClick("Authentication", "CreatAccount", btn_CreatAccount);
			}
			
		}catch(Exception e) {
			status = false;
		}
		return status;
	}


	
	/*
	 * @methodName : fill_UserDetails
	 * @purpose    : This method designed to register new user
	 * @parameters : Not Applicable
	 * @return     : Boolean
	 * @author     : Nandi
	 */
	
	public boolean fill_UserDetails() {
		boolean status = true;
		
		try {
	
			String firstname =getData("TestData", "FirstName");
			
			status = ClickAndSendData("Email Id", "Authentication", edi_emailID_newUser, email);
			
			// Check status of email id data entry and click on the register button
			
			if (status) {
				status = HoverAndClick("Authentication", "CreatAccount", btn_CreatAccount);
			}
			
		}catch(Exception e) {
			status = false;
		}
		return status;
	}
	
	
	
}

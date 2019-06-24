package com.TestCases;
// https://mvnrepository.com/

// import java.lang.reflect.Method;

import org.openqa.selenium.support.PageFactory;
// import org.testng.annotations.AfterMethod;
// import org.testng.annotations.AfterSuite;
// import org.testng.annotations.BeforeGroups;
// import org.testng.annotations.BeforeMethod;
// import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.GenericMethods.GenericMethods;
import com.Reporting.ExtentReports_Reporting;
import com.ScreenFunctions.AuthenticationPage;
import com.ScreenFunctions.HomePage;
import com.TestNGAnnotations.Annotations;

public class Tc_02_RegisterNewUser extends Annotations {
	
	@Test
	public void Tc_01_ValidataSignIn(){
		boolean status = true;
		GenericMethods gm = new GenericMethods();
		System.out.println("in Tc_02_ValidataSignIn ");
		status = gm.LaunchBrowser("chrome");
		
		// Check browser status and click on the sign in link
		if (status) {
		HomePage homepage = PageFactory.initElements(driver, HomePage.class);
		status = homepage.click_SignIn();
		
		// Check status of the signin link and proceed further
		if(status) {
			AuthenticationPage ap = PageFactory.initElements(driver, AuthenticationPage.class);
			status = ap.verify_AuthenticationHeader();
			
			// Check the status of Authentication header and proceed further
			
			ap.newUser_EnterEmailId();
		}
		}
	}
		
}

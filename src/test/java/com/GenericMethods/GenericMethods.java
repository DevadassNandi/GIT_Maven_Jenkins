package com.GenericMethods;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.Reporting.ExtentReports_Reporting;

public class GenericMethods extends ExtentReports_Reporting{
	
	public static WebDriver driver;
	public static String crntClass;
	
	/*
	 * @ Method Name : LaunchBrowser
	 * @ Input Parameters : browser name
	 * @ OutPut Parameters :boolean
	 * @ Author : Nandi
	 * @ Design Time : 3rd June 2019
	 */

	
	public boolean LaunchBrowser(String browserType) {
		boolean status = true;
		String url = getData("TestData",  "URL");
		
		try {
			switch (browserType.toLowerCase()) {
			
			case "FireFox" :
				driver = new FirefoxDriver();
				break;
			case "chrome" :
				// Step 1 : set up .exe path
				System.out.println("Launching Chrome Browser - Test 1");
				System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
				// Step 2 : Launch the browser
				driver = new ChromeDriver();
				System.out.println("Launching Chrome Browser - Test 2");
				break;
			default :
				break;
			}
			
			//Step 3 : Pass url
			System.out.println("Launching Application in the browser : " + browserType);
			driver.get(url);
			
			// Step 4 : maximize browser
			driver.manage().window().maximize();
			System.out.println("Launching application successfully");
			logEvent("PASS", "Chrome Browser Launched Successfully");
		}catch (Exception e) {
			status = false;
			logEvent("FAIL", "Chrome Browser NOT Launched");
		}
		
		return status;
	}

	/*
	 * @ Method Name : ClickAndSendData
	 * @ Input Parameters : WebElement, String
	 * @ OutPut Parameters :boolean
	 * @ Author : Nandi
	 * @ Design Time : 3rd June 2019
	 */
	
	public boolean ClickAndSendData(String elementName, String pageName, WebElement element, String data) {
		boolean status = true;
		
		try {
			element.clear();
			element.clear();
			element.sendKeys(data);
			element.sendKeys(Keys.TAB);
			logEvent("PASS", "Data " + data + " is entered sucessfully into field : " + elementName + " on Page : " + pageName);
		}
		catch (Exception e) {
			status = false;
			logEvent("FAIL", "Data NOT entered sucessfully into field : " + elementName + " on Page : " + pageName);
		}
		return status;
	}
	
	
	/*
	 * @ Method Name : ClickElement
	 * @ Input Parameters : String, WebElement, String 
	 * @ OutPut Parameters :boolean
	 * @ Author : Nandi
	 * @ Design Time : 3rd June 2019
	 */

	public boolean ClickElement(String PageName, String string, WebElement element) {
		boolean status = true;
		
		try {
			element.click();
            System.out.println("Element : " + string + " clicked successfully");
		}
		catch (Exception e) {
			System.out.println("Element : " + string + " NOT clicked");
			status = false;
		}
		return status;
		
	}
	
	/*
	 * @ Method Name : getText
	 * @ Input Parameters : WebElement
	 * @ OutPut Parameters :String
	 * @ Author : Nandi
	 * @ Design Time : 3rd June 2019
	 */
	
	public String getText(WebElement element) {
		String data = "";
		
		try {
			data = element.getText();
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return data;
		
	}
	
	
	/*
	 * @ Method Name : getAttribute
	 * @ Input Parameters : WebElement, String
	 * @ OutPut Parameters :String
	 * @ Author : Nandi
	 * @ Design Time : 3rd June 2019
	 */
	
	public String getAttribute(WebElement element, String attribute) {
		String data = "";
		
		try {
			data = element.getAttribute(attribute);
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return data;
		
	}
	
	/*
	 * @ Method Name : HoverAndClick
	 * @ Input Parameters : WebElement
	 * @ OutPut Parameters :boolean
	 * @ Author : Nandi
	 * @ Design Time : 3rd June 2019
	 */
	public boolean HoverAndClick(String PageName, String ElementName, WebElement element) {
		boolean status = true;
		
		try {
			Actions acc = new Actions(driver);
			acc.moveToElement(element).click(element).build().perform();
			logEvent("Pass", "The Element Name : " + ElementName + " Clicked on Page: " + PageName);
		}catch (Exception e) {
			System.out.println(e.getMessage());
			status = false;
			logEvent("Fail", "The Element Name : " + ElementName + " NOT Clicked on Page: " + PageName);
		}
		return status;
	}
	

	/*
	 * @ Method Name : verify_ElementExist
	 * @ Input Parameters : WebElement
	 * @ OutPut Parameters :boolean
	 * @ Author : Nandi
	 * @ Design Time : 15th June 2019
	 */
	public boolean verify_ElementExist(String PageName, String ElementName, WebElement element) {
		boolean status = true;
		try {
			
			new WebDriverWait(driver, 5).until(ExpectedConditions.visibilityOf(element));
			
			if (element.isDisplayed()) {
				logEvent("PASS", "Element : " + ElementName + " Displayed on Page");
			}else {
				logEvent("FAIL", "Element : " + ElementName + " NOT Displayed on Page");
			}
			
		}catch (Exception e) {
			status = false;
			logEvent("FAIL", "Element : " + ElementName + " NOT Displayed on Page");
		}
		return status;
	}
}

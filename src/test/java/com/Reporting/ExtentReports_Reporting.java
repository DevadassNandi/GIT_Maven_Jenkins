package com.Reporting;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.ExcelPlugin.ExcelPlugin;
import com.GenericMethods.GenericMethods;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class ExtentReports_Reporting extends ExcelPlugin{
	
	public static ExtentReports extent;
	
	public static ExtentTest test;
	
	/*
	 * Initialize the report
	 */
	
	public void intializeReport() {
		// extent = new ExtentReports("C:\\test\\temp\\TC_01.html");
		extent = new ExtentReports(check_CreateResultFolder()+"\\"+GenericMethods.crntClass+".html");
		extent.addSystemInfo("Sprint #", " Sprint 2")
		.addSystemInfo("Environment", " QA");
	}
	
	/*
	 * Start your Test
	 */
	
	public void startTest(String testCaseName)
	{
		test=extent.startTest(testCaseName);
		
	}

	/*
	 * Log your Event
	 */
	
	public void logEvent(String status, String description)
	{
		switch (status.toLowerCase()) {
		case "pass" :
			test.log(LogStatus.PASS, description);
			// test.log(LogStatus.PASS, description+test.addBase64ScreenShot(getScreenShot()));
			break;
		case "fail" :
			test.log(LogStatus.FAIL, description);
			// test.log(LogStatus.FAIL, description+test.addBase64ScreenShot(getScreenShot()));
			break;
		case "warning" :
			test.log(LogStatus.WARNING, description);
			break;
		}
		
	}
	
	/*
	 * close test case report
	 */
	
	public void closeReport() {
		extent.close();
	}
	
	/*
	 * Publish your report
	 */
	public void flushReport() {
		extent.flush();
	}
	
	public static String check_CreateResultFolder() {
		Date d=new Date();
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yy");
		
		System.out.println(sdf.format(d));
		
		String ResultPath = System.getProperty("user.dir")+"\\Results\\"+sdf.format(d);
		try
		{
			File f = new File(ResultPath);
			
			if (f.exists()) {
				System.out.println("No Folder Exist. Creating New Folder !");
				f.mkdirs();
			}
		}catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		
		
		return ResultPath;
	}
	
	/*
	public static String getScreenShot() {
		TakesScreenshot sht = (TakesScreenshot)GenericMethods.driver;
		String screenPrint=sht.getScreenShotAs(OutputType<T>.BASE64);
		return "data:image/png;base64,"+screenprint;
	}*/
}

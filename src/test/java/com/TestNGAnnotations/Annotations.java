package com.TestNGAnnotations;

import java.io.IOException;
import java.lang.reflect.Method;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import com.ExcelPlugin.ExcelPlugin;
import com.GenericMethods.GenericMethods;
import com.Reporting.ExtentReports_Reporting;

import net.bytebuddy.build.Plugin;

public class Annotations extends GenericMethods{
	
	@BeforeSuite
	/*
	 * @Purpose : Loading Excel Data Before Suite
	 * @Author : Nandi
	 * @throw IOException
	 */
	public void beforeSuite() throws IOException {
		System.out.println("Before Suite ++ Load Excel Data");
		// Load Excel Data
		ExcelPlugin plugin = new ExcelPlugin();
		plugin.intializeTestData();
	}
	
	@AfterSuite
	public void afterSuite() {
		System.out.println("After Suite ++ Close Excel Data");
	}
	
	@BeforeTest
	public void beforeTest() {
		System.out.println("Before Test ++ Intitalise Test Report");
	}
	
	@AfterTest
	public void afterTest(){
		System.out.println("After Test ++ Close Test Report");
		ExtentReports_Reporting extent = new ExtentReports_Reporting();
		extent.flushReport();
		
	}
	
	@BeforeMethod
	public void beforeMethod(Method method) {
		GenericMethods.crntClass = method.getName();
		System.out.println(GenericMethods.crntClass);
		ExtentReports_Reporting extent = new ExtentReports_Reporting();
		// Extent report will get initialized here
		extent.intializeReport();
		// Start test report
		extent.startTest(GenericMethods.crntClass);
	}
	
	@AfterMethod
	public void afterMethod() throws InterruptedException {
		Thread.sleep(2000);
		// GenericMethods.driver.close();
	}

}

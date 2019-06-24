package com.ExcelPlugin;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.GenericMethods.GenericMethods;

public class ExcelPlugin {
	
	public static XSSFWorkbook workbook;
	
	public void intializeTestData() throws IOException {
		// System.out.println("--- Loading Excel Workbook ---");
		// Get Path of the workbook
		String path = System.getProperty("user.dir") + "\\TestData\\MyExcelTest.xlsx";
		File f = new File(path);
		FileInputStream fis = new FileInputStream(f);
		workbook = new XSSFWorkbook(fis);
		System.out.println("--- Excel Workbook Loaded---");
	}
	
	// Get Row Count
	public int getRowCount(String SheetName) {
		XSSFSheet sheet = workbook.getSheet(SheetName);
		return sheet.getPhysicalNumberOfRows();
	}
	
	// Get Column Count
	public int getColCount(String SheetName) {
		return workbook.getSheet(SheetName).getRow(0).getPhysicalNumberOfCells();
	}
	
	public int SearchTestCase(String SheetName, String TestCase) {
		int TestCaseFound = 0;
		
		int rowCount = getRowCount(SheetName);
		
		for (int r = 1; r < rowCount - 1; r++) {
			 String cellVal = workbook.getSheet(SheetName).getRow(r).getCell(0).getStringCellValue();
			 if (cellVal.trim().equals(TestCase)){
				System.out.println("Test Case Found At the Row Nmber : " + r);
				TestCaseFound = r;
				break;
			 }
		}
		
		if (TestCaseFound == 0) {
			System.out.println("Test Case Not Found in Sheet : " + SheetName);
		}
		
		return TestCaseFound;
	}

	public int SearchColumn(String SheetName, String ColumnHeader) {
		int colFound = 0;
		
		int colCount = getColCount(SheetName);
		
		for (int c = 1; c < colCount - 1; c++) {
			 String cellVal = workbook.getSheet(SheetName).getRow(0).getCell(c).getStringCellValue();
			 if (cellVal.trim().equals(ColumnHeader)){
				System.out.println("Column Header Found At the Cell Number : " + c);
				colFound = c;
				break;
			 }
		}
		
		if (colFound == 0) {
			System.out.println("Column Header Not Found in Sheet : " + SheetName);
		}
		
		return colFound;
	}
	
	public String getData(String SheetName,  String ColumnHeader) {
		String data = "";
		
		int row = SearchTestCase(SheetName, GenericMethods.crntClass);
		int col = SearchColumn(SheetName, ColumnHeader);
		
		if (!(row == 0) && !(col == 0)) {
			XSSFSheet sheet = workbook.getSheet(SheetName);
			
			switch (sheet.getRow(row).getCell(col).getCellTypeEnum()) {
			case STRING:
				data = sheet.getRow(row).getCell(col).getStringCellValue();
				break;
			case NUMERIC:
				data = String.valueOf(sheet.getRow(row).getCell(col).getCellTypeEnum());
				break;
			}
		}
		
		return data;
	}

}

package com.webdriver.datadriven.exceldriven;

import org.testng.annotations.Test;

/**
* rathr1
**/
public class TestExcelReader {

	@Test
	public void testExcel(){
		ExcelReaderHelper excelReader = new ExcelReaderHelper("C:\\Users\\rathr1\\Desktop\\ExcelOne.xlsx");
		System.out.println(excelReader.getData("Sheet1", 1, 3));
		System.out.println(excelReader.getData("Sheet1", 4, 2));
		System.out.println(excelReader.getData("Sheet2", 1, 4));
		System.out.println(excelReader.getData("Sheet2", 2, 4));
	}
}

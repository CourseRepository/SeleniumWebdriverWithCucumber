package com.webdriver.excelreader;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcel {
	
	/*
	 * workbook -- sheet -- row -- col - value
	 * 
	 * */
	
	public static void main(String[] args) throws IOException {
		
		File xlFile = new File("D:\\Build\\Book1.xlsx");
		FileInputStream input = new FileInputStream(xlFile);
		XSSFWorkbook book = new XSSFWorkbook(input); // Read the workbook
		XSSFSheet sheet = book.getSheet("Sheet1");
		
		for(int row = sheet.getFirstRowNum(); row <= sheet.getLastRowNum(); row++){
			XSSFRow sheetrow = sheet.getRow(row);
			
			for(int col = sheetrow.getFirstCellNum(); col < sheetrow.getLastCellNum(); col++){
				XSSFCell cell = sheetrow.getCell(col);
				
				switch (cell.getCellTypeEnum()) {
				case BLANK:
					System.out.println("");
					break;
				case NUMERIC:
					System.out.println(cell.getNumericCellValue());
					break;
				case STRING : 
					System.out.println(cell.getStringCellValue());
				default:
					break;
				}
			}
		}
		
		book.close();
		
	}

}

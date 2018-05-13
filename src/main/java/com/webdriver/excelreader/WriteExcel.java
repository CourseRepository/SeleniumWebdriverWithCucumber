package com.webdriver.excelreader;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class WriteExcel {
	
	/*
	 * book -> sheet -> row - > col -> set value
	 * */
	
	public static void main(String[] args)  throws IOException{
		
		File xlFile = new File("D:\\Build\\newFile.xlsx");
		FileOutputStream out = new FileOutputStream(xlFile);
		XSSFWorkbook book = new XSSFWorkbook(); // Create the work book
		//Create the sheet
		
		XSSFSheet sheet = book.createSheet("Test Data Sheet");
		
		// Create the row
		
		XSSFRow sheetRow = sheet.createRow(0);
		
		// Create the Cell
		
		XSSFCell cel = sheetRow.createCell(0,CellType.STRING);
		
		cel.setCellValue("Test Data cell");
		
		book.write(out);
		
		book.close();
		out.close();
		
		
	}

}

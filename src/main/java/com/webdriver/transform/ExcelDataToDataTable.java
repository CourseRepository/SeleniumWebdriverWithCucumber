package com.webdriver.transform;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

import com.webdriver.excelreader.ExcelReader;
import com.webdriver.utils.ResourceUtils;

import cucumber.api.DataTable;
import cucumber.api.Transformer;
import cucumber.runtime.ParameterInfo;
import cucumber.runtime.table.TableConverter;
import cucumber.runtime.xstream.LocalizedXStreams;
import gherkin.formatter.model.Comment;
import gherkin.formatter.model.DataTableRow;

public class ExcelDataToDataTable extends Transformer<DataTable> {

	@Override
	public DataTable transform(String filename) {
		ArrayList<String> fileToken =  getFileTokes(filename);
		
		String path = getFilePath(fileToken.get(0));
		ExcelReader reader = new ExcelReader.ExcelReaderBuilder()
				.setFileLocation(path)
				.setSheet(Integer.parseInt(fileToken.get(1)))
				.build();
		
		List<List<String>> excelData = getExcelData(reader);
		
		List<DataTableRow> dataTableRows = getDataTableRows(excelData);
		
		DataTable table = getDataTable(dataTableRows);
		
		return table;
	}

	private ArrayList<String> getFileTokes(String filePath){
		return new ArrayList<>(Arrays.asList(filePath.split(";")));
	}

	private String getFilePath(String filename) {
		String path = ResourceUtils.getResourcePath(filename);
		
		if(null != path)
			return path;
		throw new RuntimeException("Invlaid File Name : " + filename);
	}


	private DataTable getDataTable(List<DataTableRow> dataTableRows) {
		ParameterInfo parameterInfo = new ParameterInfo(null, null, null, null);
	    TableConverter tableConverter = new TableConverter(new LocalizedXStreams(Thread.currentThread().getContextClassLoader()).get(Locale.getDefault()), parameterInfo);
		
		DataTable table = new DataTable(dataTableRows, tableConverter);
		return table;
	}

	private List<DataTableRow> getDataTableRows(List<List<String>> excelData) {
		List<DataTableRow> dataTableRows = new LinkedList<>();
		int line = 1;
		
		for(List<String> list : excelData){
			Comment commnet = new Comment("", line);
			DataTableRow tableRow = new DataTableRow(Arrays.asList(commnet), list, line++);
			dataTableRows.add(tableRow);
		}
		return dataTableRows;
	}

	private List<List<String>> getExcelData(ExcelReader reader) {
		List<List<String>> excelData = new LinkedList<>();
		
		try {
			excelData = reader.getSheetDataAt();
		} catch (InvalidFormatException | IOException e) {
			throw new RuntimeException(e.getMessage());
		}
		return excelData;
	}

}

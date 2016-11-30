package com.automation.facebookPage.FacebookMaven;

import java.io.File;
import java.io.FileInputStream;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelLib {
	XSSFWorkbook wb;
	XSSFSheet Sheet1;
	
	public  void excelLib(String path)
	{
           try {
			File src = new File("path");
			   FileInputStream fis = new FileInputStream(src);
			   wb = new XSSFWorkbook(fis);
			   
		} catch (Exception e) {
			
			e.printStackTrace();
		
		 }
	}
	
	public String getdata(int sheetnumber, int row, int column){
		Sheet1 = wb.getSheetAt(0);
		String data = Sheet1.getRow(row).getCell(column).getStringCellValue();
		return data;
	
	}
	public int getRowCount(int sheetIndex){
		int row = wb.getSheetAt(sheetIndex).getLastRowNum();
		row = row+1;
		return row;
	}

}

package com.comcast.crm.generic.fileutility;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Excelutility {

	public String getDataFromExcel(String Sheetname, int row, int cell) throws Exception {
		FileInputStream fis=new FileInputStream(ipath.exl_data);
		Workbook wb = WorkbookFactory.create(fis);
		String value = wb.getSheet(Sheetname).getRow(row).getCell(cell).getStringCellValue().toString();
		wb.close();
		return value;
	}
	
	public int getRowcoutn(String Sheetname) throws Exception {
		FileInputStream fis= new FileInputStream(ipath.exl_data);
		Workbook wb = WorkbookFactory.create(fis);
		int rownum=wb.getSheet(Sheetname).getLastRowNum();
		wb.close();
		return rownum;
	}
	
	public void setDataToExcel(String Sheetname, int row, int cell, String data) throws Exception {
		FileInputStream fis=new FileInputStream(ipath.exl_data);
		Workbook wb = WorkbookFactory.create(fis);
		wb.getSheet(Sheetname).createRow(row).createCell(cell).setCellValue(data);
		FileOutputStream fos= new FileOutputStream(ipath.exl_data);
		wb.write(fos);
		wb.close();
	}
	
}

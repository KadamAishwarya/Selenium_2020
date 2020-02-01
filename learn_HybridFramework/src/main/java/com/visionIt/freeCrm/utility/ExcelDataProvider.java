package com.visionIt.freeCrm.utility;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelDataProvider {
	public XSSFWorkbook workbook;
	
	//freeCrm_login:Excel name
	public ExcelDataProvider() 
	{
		try {
			FileInputStream fins=new FileInputStream(new File(".//TestData//TestData.xlsx"));
			workbook=new XSSFWorkbook(fins);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public String getStringCellData(String sheetname,int row,int colm)
	{
		return workbook.getSheet(sheetname).
		getRow(row).getCell(colm).getStringCellValue();
	}
	public String getStringCellData(int sheetindex,int row,int colm)
	{
		return workbook.getSheetAt(sheetindex).
		getRow(row).getCell(colm).getStringCellValue();
	}
	public int getNumericCellData(String sheetname,int row,int colm)
	{
		return(int) workbook.getSheet(sheetname).
		getRow(row).getCell(colm).getNumericCellValue();
	}
	public int getNumericCellData(int sheetindex,int row,int colm)
	{
		return(int) workbook.getSheetAt(sheetindex).
		getRow(row).getCell(colm).getNumericCellValue();
	}
	
	public Object[][] getExcelData(String sheetname)
	{
	XSSFSheet sheet=workbook.getSheet(sheetname);
	int rows=sheet.getLastRowNum();
	int colm=sheet.getRow(0).getLastCellNum();
	Object[][] data = new Object[rows][colm];
	for(int i=0;i<rows;i++)
	{
		for(int j=0;j<colm;j++)
		{
			data[i][j]=sheet.getRow(i+1).getCell(j).toString();
		}
	}
	return data;
	}
	
	public Object[][] getExcelData(int sheetIndex)
	{
	XSSFSheet sheet=workbook.getSheetAt(sheetIndex);
	int rows=sheet.getLastRowNum();
	int colm=sheet.getRow(0).getLastCellNum();
	Object[][] data = new Object[rows][colm];
	for(int i=0;i<rows;i++)
	{
		for(int j=0;j<colm;j++)
		{
			data[i][j]=sheet.getRow(i+1).getCell(j).toString();
		}
	}
	return data;
	}
}
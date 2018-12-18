package com.selenium.utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReader {
	
	public String path;
	public FileInputStream fis;
	public FileOutputStream fout;
	private static XSSFWorkbook workbook=null;
	private static XSSFSheet sheet=null;
	private static XSSFRow row=null;
	private static XSSFCell cell=null;
	
	public ExcelReader(String path) 
	{
		
		this.path=path;
		try{
		fis=new FileInputStream(path);
		workbook=new XSSFWorkbook(fis);
		sheet=workbook.getSheetAt(0);
		fis.close();
		}
		
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public static int getRowCount(String sheetname)
	{
		//System.out.println(sheetname);
		int index=workbook.getSheetIndex(sheetname);
		//System.out.println(workbook.getSheetIndex(sheetname));
		if (index==-1)
		{
			return 0;
		}
		else
		{
			sheet=workbook.getSheetAt(index);
			int number=sheet.getLastRowNum()+1;
			return number;
		}
	}
	
	public static String cellData(String sheetname,int colNum,int rowNum)
	{
		int index=workbook.getSheetIndex(sheetname);
		//System.out.println(workbook.getSheetIndex(sheetname));
		sheet=workbook.getSheetAt(index);
		//System.out.println(sheet);
		row=sheet.getRow(rowNum-1);
		cell=row.getCell(colNum);
		//System.out.println(row);
		//String cellText=cell.getStringCellValue();
		String cellText=sheet.getRow(rowNum).getCell(colNum).getStringCellValue();
		return cellText;
	}
	
	// returns number of columns in a sheet	
		public static int getColumnCount(String sheetName){
			// check if sheet exists
						
			sheet = workbook.getSheet(sheetName);
			row = sheet.getRow(0);
			
			if(row==null)
				return -1;
			
			return row.getLastCellNum();
			
			
			
		}

}

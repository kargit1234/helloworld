package org.elango;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.xmlbeans.impl.xb.xsdschema.Public;

public class Baseclass1 {
	
		
		private int rownum;
		public  String getExcelData(String sheetName, int rownum, int cellnum) throws IOException {
		String data = null;
			File file = new File("C:\\Users\\elgovan\\Selenium\\Framework\\Excel Sheets\\TEST1.xlsx");
			FileInputStream stream = new FileInputStream(file);
			Workbook workbook = new XSSFWorkbook(stream);
			Sheet sheet = workbook.getSheet(sheetName);
			Row row = sheet.getRow(rownum);
			Cell cell = row.getCell(cellnum);
			int type = cell.getCellType();

			if(type == 1) {
				data = cell.getStringCellValue();
					
			}
			if(type == 0) {
				
				if(DateUtil.isCellDateFormatted(cell)) {
					Date dateCellValue= cell.getDateCellValue(); 
			SimpleDateFormat dateFormat1 = new SimpleDateFormat("dd-MM-yy");
			String data3 = dateFormat1.format(dateCellValue);
			}
			else {
				
				double d = cell.getNumericCellValue();
				long l = (long)d;
				data = String.valueOf(l);
			
			}
			}
	return data;
	
		}	
	
		public  void updateData(String sheetName, int rownum, int cellnum,String oldname,String newname) throws IOException {

			File file = new File("C:\\Users\\elgovan\\Selenium\\Framework\\Excel Sheets\\TEST1.xlsx");
			FileInputStream stream = new FileInputStream(file);
			Workbook workbook = new XSSFWorkbook(stream);
			Sheet sheet = workbook.getSheet(sheetName);
			Row row = sheet.getRow(rownum);
			Cell cell = row.getCell(cellnum);
			String data = cell.getStringCellValue();
			if(data.equals(oldname)) {
				cell.setCellValue(oldname);
				FileOutputStream o = new FileOutputStream(file);
				workbook.write(o);
				
			}
		}
		public  void writeData1(int rownum1,int cellnum1,String sheetName1,String data) throws IOException {	
			File file = new File("C:\\Users\\elgovan\\Selenium\\Framework\\Excel Sheets\\TEST1.xlsx");
			FileInputStream stream = new FileInputStream(file);
			Workbook workbook = new XSSFWorkbook(stream);
			Sheet sheet = workbook.getSheet(sheetName1);
			Row row = sheet.getRow(rownum1);
			Cell cell7 = row.createCell(cellnum1);
			cell7.setCellValue(data);
				FileOutputStream o = new FileOutputStream(file);
				workbook.write(o);
		}	
}


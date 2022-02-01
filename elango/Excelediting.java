package org.elango;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Excelediting {

	public static void main(String[] args) throws IOException {
		File file = new File("C:\\Users\\elgovan\\Selenium\\Framework\\Excel Sheets\\TEST1.xlsx");
		
		FileInputStream stream = new FileInputStream(file);
		
		Workbook workbook = new XSSFWorkbook(stream);
		
		Sheet sheet = workbook.getSheet("Data1");

		Row row = sheet.getRow(3);
		//TO EDIT EXISTING VALUE IN A CELL
		Cell cell = row.getCell(0);
		
		String data = cell.getStringCellValue();
		//1.CHECK AND SET NEW VALUE
		if(data.equals("Sam")) {
			cell.setCellValue("SHEBIN");
		}
		
		//TO ENTER NEW CELL VALUE IN ALREADY CREATED ROW
		Cell cell7 = row.createCell(7);
		
		cell7.setCellValue("python");
		
		//2.TO CONVERT OBJECT INTO FILE
		FileOutputStream o = new FileOutputStream(file);
		
		//3.TO WRITE (OR) SAVE
		workbook.write(o);
		
	}

}

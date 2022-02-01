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

public class ExcelCreating {
	public static void main(String[] args) throws IOException {
		//1. create file location
File file = new File("C:\\Users\\elgovan\\Selenium\\Framework\\Excel Sheets\\TEST2.xlsx");
		
		
		Workbook workbook = new XSSFWorkbook();
		//to create workbook
		Sheet sheet = workbook.createSheet("Testt2");
		//to create row
		Row row = sheet.createRow(0);
		//to create cell
		Cell cell = row.createCell(1);
		//to set value
		cell.setCellValue("omr");
		
		FileOutputStream o = new FileOutputStream(file);
		
		workbook.write(o);
		
		
		
		
		
	}
}

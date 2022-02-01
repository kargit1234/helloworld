package org.elango;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FilterInputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelLoading {
public static void main(String[] args) throws IOException {
	//1.mention path of the excel sheet
	File file = new File("C:\\Users\\elgovan\\Selenium\\Framework\\Excel Sheets\\TEST1.xlsx");
	
	//2.get the object,bytes from file
	//FileInputStream(file) is a constructor in FileInputStream class
	//this is constructor overloading.
	FileInputStream stream = new FileInputStream(file);
	
	//3.create workbook---.collection of sheets
	Workbook workbook = new XSSFWorkbook(stream);
	//4.get the sheetname
	Sheet sheet = workbook.getSheet("Data1");
	//5.get the row
	Row row = sheet.getRow(3);//it will get values from row index 3
	//6.get the cell
	Cell cell = row.getCell(1);//it will get calues from row 3 & column index 1
	
	System.out.println(cell);
	
	//7.row count
	int rowcount = sheet.getPhysicalNumberOfRows();
	System.out.println(rowcount);
	
	//8.cell count(cells in each row)
	int cellcount = row.getPhysicalNumberOfCells();
	System.out.println(cellcount);
	
	//9.to get values in single row
//	for (int i = 0; i < row.getPhysicalNumberOfCells(); i++) {
//		Cell cell2 = row.getCell(i);
//		System.out.println(cell2);
//	}
	
	//10.to all values in excel
	for (int i = 0; i < sheet.getPhysicalNumberOfRows(); i++) {
		Row row2 = sheet.getRow(i);
		for (int j = 0; j < row2.getPhysicalNumberOfCells(); j++) {
			Cell cell2 = row2.getCell(j);
			
			//this check whether it has [number or text].1-text,0-number
			int type = cell2.getCellType();
			//it is used to covert number to string ,date and number to needed format
			if(type == 1) {
				String data = cell2.getStringCellValue();
				System.out.println(data);	
			}
			if(type == 0) {
				
				if(DateUtil.isCellDateFormatted(cell2)) {
					
//				  Date date=cell2.getDateCellValue();
//			SimpleDateFormat dateFormat1 = new SimpleDateFormat("dd-MM-yy");
//			String data3 = dateFormat1.format(date);
//			System.out.println(data3);
					
				// it is simple form of above code .....
					String data3 = new SimpleDateFormat("dd-MM-yy").format(cell2.getDateCellValue());
					System.out.println(data3);
			
			}
			else {
				
//				double d = cell2.getNumericCellValue();
//				long l = (long)d;
//				
//				String data1 = String.valueOf(l);
//				System.out.println(data1);	
				
				// it is simple form of above code .....
				String data3 = String.valueOf((long) cell2.getNumericCellValue());
				System.out.println(data3);
				
		}
	}	
	
}
	
}
}
}

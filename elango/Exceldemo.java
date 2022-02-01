package org.elango;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Exceldemo {
	public static void main(String[] args) throws IOException {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("http://demo.automationtesting.in/Register.html");
		driver.manage().window().maximize();
		WebElement skilldrop = driver.findElement(By.xpath("//select[@id= 'Skills']"));
		Select Se1 = new Select(skilldrop);
		List<WebElement> options = Se1.getOptions();
		int size = options.size();
		System.out.println(size);
		
		File file = new File("C:\\Users\\elgovan\\Selenium\\Framework\\Excel Sheets\\DEMO.xlsx");
		Workbook workbook = new XSSFWorkbook();
		// to create workbook
		Sheet sheet = workbook.createSheet("AUTODEMO");

		for (int i = 0; i < size; i++) {
			Row row = sheet.createRow(i);
			// to create cell
			Cell cell = row.createCell(0);
			WebElement ele = options.get(i);
			String text = ele.getText();
			cell.setCellValue(text);

		}
		FileOutputStream o = new FileOutputStream(file);
		workbook.write(o);

	}
}

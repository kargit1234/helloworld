package org.elango;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebDriver.Navigation;
import org.openqa.selenium.WebDriver.Options;
import org.openqa.selenium.WebDriver.TargetLocator;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClassS {
	//WebDriver:I
		public static WebDriver driver;
		
		public static WebDriver launchBrowser() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		return driver;
		}
		
		public static void get(String url) {
		        driver.get(url);
		}
	   
	    public void navigateBack() {
	    	Navigation navigate = driver.navigate();
	    	navigate.back();
	    }
	    public void navigateTo(String url) {
		    Navigation navigate1 = driver.navigate();
		    navigate1.to(url);
		}
	    public void navigateRefresh() {
			Navigation navigate2 = driver.navigate();
			navigate2.refresh();
		}
	    public void navigateForward() {
			Navigation navigate3 = driver.navigate();
			navigate3.forward();
		}	
	    public String getCurrentUrl() {
	    	String currentUrl = driver.getCurrentUrl();
	    	return currentUrl;
		}
	    public String getTitle() {
	    	String title1 = driver.getTitle();
	    	return title1;
		}

	    public Options manage() {
	    	Options manage = driver.manage();
	    	return manage;
		}
	    public TargetLocator switchTo() {
	    	TargetLocator switchTo = driver.switchTo();
	    	return switchTo;
		}
	    public void quiet() {
	    	driver.quit();
			
		}
	    public static void close() {
	    	driver.close();
		
		}
	    public void windowsHandle(int index) {
	 	   String parwindowHandle = driver.getWindowHandle();
	 	   Set<String> allwindowHandles = driver.getWindowHandles();
	 	   List<String>l= new LinkedList<String>();
	 	   l.addAll(allwindowHandles);
	 	   driver.switchTo().window(l.get(index));
	    }
	    
	    //WebElement:I
	    
	    public WebElement findElementByid(String atttributeName) {
			WebElement findElement= driver.findElement(By.id(atttributeName));
			return findElement;
	    }
	    public WebElement findElementByname(String attributeName) {
			WebElement findElement = driver.findElement(By.name(attributeName));
			return findElement;
		}
	    public WebElement findElementByClassName(String attributeName) {
			WebElement findElement = driver.findElement(By.className(attributeName));
	        return findElement;
	    }
	    public WebElement findElementByXpath(String path) {
			WebElement findElement = driver.findElement(By.xpath(path));
			return findElement;

		}
	    
	    public void sendKeys(WebElement weref, String data) {
	    	weref.sendKeys(data);
	  
		}
	    public void click(WebElement weref) {
	    	weref.click();

		}
	    public String getText(WebElement weref) {
	    	String text = weref.getText();
	    	return text;
			
		}
	    public String getAttribute(WebElement weref,String value) {
	    	String attribute = weref.getAttribute(value);
	    	return attribute;
		}
	   public boolean isDisplayed(WebElement weref) {
		   boolean displayed = weref.isDisplayed();
		   return displayed;
	   	}
	   public boolean isSelected(WebElement weref) {
		   boolean selected = weref.isSelected();
		   return selected;
	   	}
	   public boolean isEnabled(WebElement weref) {
		   boolean enabled = weref.isEnabled();
		   return enabled;	
	   	}
	   public void clear(WebElement weref) {
		    weref.clear();

	}
	   //Actions:C
	   
	   public void moveToElement(WebElement target) {
		   Actions a =  new Actions(driver);
		   a.moveToElement(target).perform();
	   	}
	   public void dragAndDrop(WebElement src,WebElement des) {
		   Actions a1 = new Actions(driver);
		   a1.dragAndDrop(src, des).perform();
		
	   	}
	   public void contextClick(WebElement rightclick) {
		   Actions a2 = new Actions(driver);
		   a2.contextClick().perform();	   	
	   	}
	   public void doubleClick(WebElement click) {
		   Actions a3 = new Actions(driver);
		   a3.doubleClick().perform();
		
	   	}
	   //Select:C
	   
	   public void selectByIndex(WebElement weref,int index) {
		   Select s= new Select(weref);
		   s.selectByIndex(1);
	   	}
	   public void selectByValue(WebElement weref,String value) {
		   Select s1= new Select(weref);
		   s1.selectByValue(value);
	   	}
	   public void selectByVisibleText(WebElement weref, String value) {
		   Select s2= new Select(weref);
		   s2.selectByVisibleText(value);
	   	}

	   public void deselectByIndex(WebElement weref,int index) {
		   Select ds= new Select(weref);
		   ds.selectByIndex(index);
	   	}
	   public void deselectByValue(WebElement weref,String value) {
		   Select ds1= new Select(weref);
		   ds1.selectByValue(value);
	   	}
	   public void deselectByVisibleText(WebElement weref, String value) {
		   Select ds2= new Select(weref);
		   ds2.selectByVisibleText(value);
		
	   	}
	   public void deSelectAll(WebElement weref) {
		   Select ds3= new Select(weref);
		   ds3.deselectAll(); 

	   	}
	   public WebElement getFirstElectedOption(WebElement weref) {
		   Select s3= new Select(weref);
		   WebElement firstSelectedOption = s3.getFirstSelectedOption();
		   return firstSelectedOption;
		   
	   	}
	   public boolean isMultiple(WebElement weref) {
		   Select s4 = new Select(weref);
		   boolean multiple = s4.isMultiple();
		   return multiple;
	   	}
	   public void allOptionsByVisibleText(WebElement weref) {
		   Select s = new Select(weref);
		   List<WebElement> options = s.getOptions();
		   for (WebElement element : options) {
			   String text = element.getText();
			   s.selectByVisibleText(text);
		}   
		}
		
	   public void SelectallOptionsByIndex(WebElement weref) {
			   Select s = new Select(weref);
			   List<WebElement> options = s.getOptions();
			   for (int i = 0; i < options.size(); i++) {
			   s.selectByIndex(i);	
		}
	    }
	   public void allOptionsByValue(WebElement weref,String value) {
		   Select s = new Select(weref);
		   List<WebElement> options = s.getOptions();
		   for (WebElement element : options) {
			          String attribute = element.getAttribute(value);
			          s.selectByValue(attribute);
		}              	   
		}
		
	    public void SelectallOptionsByValue(WebElement weref,String value) {
				Select s = new Select(weref);
				List<WebElement> options = s.getOptions();
				for (WebElement element : options) {
				String attribute = element.getAttribute(value);
				s.selectByValue(attribute);
	    }
	    }
	   public List<WebElement> getAllSelectedOptions(WebElement weref) {
		   Select s5 = new Select(weref);
		   List<WebElement> allSelectedOptions = s5.getAllSelectedOptions();
		   return allSelectedOptions;

	   	}
	   public WebElement getFirstSelectedOptions(WebElement weref) {
		   Select s6 = new Select(weref);
		   WebElement firstSelectedOption = s6.getFirstSelectedOption();
		   return firstSelectedOption;
		   
	   	}	

	   //Alert:I
	   
	   public void accept() {
		 Alert al = driver.switchTo().alert();
		 al.accept();
	   	}
	   public void dismiss() {
		Alert al = driver.switchTo().alert();
		al.dismiss();
	   	}
	   public String alertGettext() {
		Alert al = driver.switchTo().alert();
		String text = al.getText();
		return text;
	   	}
	   public void alertSendkeys(String value) {
		Alert a2 = driver.switchTo().alert();
	    a2.sendKeys(value);
	   	}
	   public void frame1(String id) {
		   driver.switchTo().frame(id);
		
	   	}
	   public void frame2(String name) {
		   driver.switchTo().frame(name);
	   
	   	}
	   public void frame2(WebElement weref) {
		   driver.switchTo().frame(weref);
	   	}
	   public void frame4(int index) {
		   driver.switchTo().frame(index);
	   	}
	   //JavascriptExecutor :I 
	   
	   public void jssendKeys (WebElement weref,String data) {
		   JavascriptExecutor exe = (JavascriptExecutor)driver;
		   exe.executeScript("arguments[0].setAttribute('value','"+data+"')", weref);

	   }
	   public void jsClick(WebElement weref) {
		   JavascriptExecutor exe = (JavascriptExecutor)driver;
		   exe.executeScript("arguments[0].click", weref);
	   }
	   
	   public String getDataFromExcel(String Sheet,int rowIndex,int cellIndex) throws IOException { 
		   
		   String value= null;
		
		   File f = new File("C:\\Users\\elgovan\\Selenium\\Framework\\Excel Sheets\\Adactin Details.xlsx");
		   
		   FileInputStream stream = new FileInputStream(f);
		   
		   Workbook w = new XSSFWorkbook(stream);
		   
		   Sheet s = w.getSheet(Sheet);
		   
		   Row r= s.getRow(rowIndex);
		   
		   Cell c = r.getCell(cellIndex);
		   
		   int Type = c.getCellType();
		   if(Type==1) {
			    value = c.getStringCellValue();
		   }
		   if(Type==0) {
			   if(DateUtil.isCellDateFormatted(c)) {
				   Date d= c.getDateCellValue();
				   SimpleDateFormat sim = new SimpleDateFormat("dd/MM/yyyy");
				  value = sim.format(d);
			   }
			   else {
				   double d = c.getNumericCellValue();
				   long l = (long)d;
				    value = String.valueOf(l);
			   }
			   
		   }
		return value;   	   
	}
	   public void excelUpdate(String Sheet,int RowIndex,int CellIndex,String Olddata,String Newdata ) throws IOException {
		   
		   File f = new File("C:\\Users\\elgovan\\Selenium\\Framework\\Excel Sheets\\Adactin Details.xlsx");
		   FileInputStream fs = new FileInputStream(f);
		   
		   Workbook w = new XSSFWorkbook(fs);
		   
		   Sheet s = w.getSheet(Sheet);
		   
		   Row r = s.getRow(RowIndex);
		   
		   Cell c = r.getCell(CellIndex);
		   String scv = c.getStringCellValue();
		   
		   if(scv.equals(Olddata)) {
			   
			  c.setCellValue(Newdata);
		   }
		   FileOutputStream fos = new FileOutputStream(f);
		   w.write(fos);
	   }

	    public void writeExcel(String Sheet,int RowIndex,int CellIndex,String data) throws IOException {
		  
		  File f = new File("C:\\Users\\elgovan\\Selenium\\Framework\\Excel Sheets\\Adactin Details.xlsx");
		  
		  Workbook w = new XSSFWorkbook();
		  
		  Sheet s = w.createSheet(Sheet);
		  
		  Row r = s.createRow(RowIndex);
		  
		  Cell c = r.createCell(CellIndex);
		  
		  c.setCellValue(data);
		  
		  FileOutputStream fos = new FileOutputStream(f);
		  w.write(fos);
		   
	}   
	    public void excelWriteCell(String Sheet,int RowIndex,int CellIndex,String data ) throws IOException {
			   
			   File f = new File("C:\\Users\\elgovan\\Selenium\\Framework\\Excel Sheets\\Adactin Details.xlsx");
			   FileInputStream fs = new FileInputStream(f);
			   
			   Workbook w = new XSSFWorkbook(fs);
			   
			   Sheet s = w.getSheet(Sheet);
			   
			   Row r = s.getRow(RowIndex);
			   
			   Cell c = r.createCell(CellIndex);
			 
				  c.setCellValue(data);
			 
			   FileOutputStream fos = new FileOutputStream(f);
			   w.write(fos);
		   }
	}



package org.testng;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Dataprovider1 {
	static WebDriver driver;
	@DataProvider  (name = "data-provider")
	public Object[][] dpMethod(){
		return new Object[][] {{"iphone"}, {"watch"},{"computer"},
		{"dress"}};
	}

	@Test(dataProvider = "data-provider")
	private void choose(String s1) {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.amazon.in/");
		driver.manage().window().maximize();
		
		WebElement txtsearch = driver.findElement(By.id("twotabsearchtextbox"));
		txtsearch.sendKeys(s1,Keys.ENTER);
		

	}
	
	
	
}

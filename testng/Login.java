package org.testng;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Login {

	
	static WebDriver driver;
	@BeforeClass
	public static void  launch() throws InterruptedException {
	WebDriverManager.chromedriver().setup();
	driver = new ChromeDriver();
	driver.get("https://adactinhotelapp.com/");
	driver.manage().window().maximize();
	Thread.sleep(3000);	

}
	@BeforeMethod
	public void beforeentry() {
	
	System.out.println(System.currentTimeMillis());
}
	@Test
	public void loginentry() {
	WebElement login = driver.findElement(By.id("username"));
	login.sendKeys("Elangovan555");
	WebElement pass = driver.findElement(By.id("password"));
	pass.sendKeys("india@75");
	}
	@AfterMethod
	public void afterentry() {
		
	System.out.println(System.currentTimeMillis());
}
	@AfterClass
	public static void close() {
		driver.close();
	}
	
}

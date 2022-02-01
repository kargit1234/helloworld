package org.elango;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;


public class Junit {
	
	static WebDriver driver;
	@BeforeClass
	public static void  launch() throws InterruptedException {
	WebDriverManager.chromedriver().setup();
	driver = new ChromeDriver();
	driver.get("https://adactinhotelapp.com/");
	driver.manage().window().maximize();
	Thread.sleep(3000);	

}
	@Before
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
	@After
	public void afterentry() {
		
	System.out.println(System.currentTimeMillis());
}
	@AfterClass
	public static void close() {
		driver.close();
	}
	
}
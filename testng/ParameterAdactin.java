package org.testng;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ParameterAdactin {
	
	static WebDriver driver;
	@Test
	@Parameters({"username","password"})
	public void  launch(String s1,String s2) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://adactinhotelapp.com/");
		driver.manage().window().maximize();
		Thread.sleep(3000);	
		
		WebElement txtusername = driver.findElement(By.id("username"));
		txtusername.sendKeys(s1);
		WebElement txtpassword = driver.findElement(By.id("password"));
		txtpassword.sendKeys(s2);
		WebElement btnlogin = driver.findElement(By.id("login"));
		btnlogin.click();
	}
	@Test
	@Parameters({"location"})
	private void select1(String s3) {
		WebElement txtlocation = driver.findElement(By.id("location"));
		Select se = new Select(txtlocation);
		se.selectByVisibleText(s3);

	}

}

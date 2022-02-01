package org.elango;

import java.io.Closeable;
import java.io.IOException;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class JunitAdactin extends BaseClassS {
	static WebDriver driver;
	@BeforeClass
	public static void beforeclass() throws InterruptedException {
		launchBrowser();
		get("https://adactinhotelapp.com/");
		Thread.sleep(3000);
	}
	@AfterClass
	public static void afterClass() {
		close();
	}
	@Test
	public void login() throws IOException, InterruptedException {
	
	    //LoginPage
	    WebElement txtuser = findElementByid("username");
	    sendKeys(txtuser, getDataFromExcel("Sheet1", 1, 0));
	    
	    WebElement txtpass= findElementByid("password");
	    sendKeys(txtpass, getDataFromExcel("Sheet1", 1, 1));
	    
	    WebElement btnlogin = findElementByid("login");
        click(btnlogin);
    
        //SearchHotel 
        WebElement btnlocation = findElementByid("location");
        click(btnlocation);
        sendKeys(btnlocation,getDataFromExcel("Sheet1",5,2));
        
        WebElement btnroom = findElementByid("room_nos");      
        sendKeys(btnroom,getDataFromExcel("Sheet1", 3, 3));
        
        WebElement btnrooms = findElementByid("room_nos");
        click(btnrooms);
        sendKeys(btnrooms, getDataFromExcel("Sheet1", 2, 4));
        
        WebElement btndatein = findElementByid("datepick_in");
        click(btndatein);
        clear(btndatein);
        sendKeys(btndatein, getDataFromExcel("Sheet1", 1, 10));
        
        WebElement btndateout = findElementByid("datepick_out");;
        click(btndateout);
        clear(btndateout);
        sendKeys(btndateout, getDataFromExcel("Sheet1", 1, 11));
        
        
        WebElement btnadultroom = findElementByid("adult_room");
        click(btnadultroom);
        sendKeys(btnadultroom, getDataFromExcel("Sheet1", 2, 6));
        
        WebElement btnchildroom = findElementByid("child_room");
        click(btnchildroom);
        sendKeys(btnchildroom, getDataFromExcel("Sheet1", 2,6));
        //assert 1
        WebElement txtsearch =  findElementByXpath("//td[@class='login_title' ]");
        String search = getText(txtsearch);
        boolean contains = search.contains("Search Hotel");
        Assert.assertTrue("verify search", contains);
        
        WebElement btnclick = findElementByid("Submit");
        click(btnclick);
        
        //SelectHotel 
        WebElement btnhotel = findElementByid("radiobutton_1");
        click(btnhotel);
      //assert 2
        WebElement txtsearch1 =  findElementByXpath("//td[text()='Select Hotel ']");
        String search1 = getText(txtsearch);
        boolean contains1 = search1.contains("Select Hotel");
        Assert.assertTrue("verify search", contains1);
       // Assert.assertEquals("verify select", "Select Hotel", search1);
        
        WebElement btncontinue = findElementByid("continue");
        click(btncontinue);
        Thread.sleep(2000);
        
        //BookaHotel
        WebElement keysfirst =  findElementByid("first_name");
         sendKeys(keysfirst, getDataFromExcel("Sheet1", 1, 12));
        
        WebElement keyslast =  findElementByid("last_name");
         sendKeys(keyslast,  getDataFromExcel("Sheet1", 1, 13));
        
        WebElement keysadd =  findElementByid("address");
         sendKeys(keysadd,  getDataFromExcel("Sheet1", 1, 14));
        
        WebElement keyscardno =  findElementByid("cc_num");
         sendKeys(keyscardno,  getDataFromExcel("Sheet1", 1, 15));
        
        WebElement keyscardtype =  findElementByid("cc_type");
         sendKeys(keyscardtype,  getDataFromExcel("Sheet1", 3,7));
        
        WebElement keysexpmonth =  findElementByid("cc_exp_month");
         sendKeys(keysexpmonth,  getDataFromExcel("Sheet1", 4,8));
        
        WebElement keysexpyear =  findElementByid("cc_exp_year");
         sendKeys(keysexpyear,  getDataFromExcel("Sheet1", 12, 9));
       
        WebElement keyscvv =  findElementByid("cc_cvv");
         sendKeys(keyscvv,  getDataFromExcel("Sheet1", 1,16));
       //assert 3
         WebElement txtsearch2 =  findElementByXpath("//td[text()='Book A Hotel']");
         String search2 = getText(txtsearch);
         boolean contains3 = search2.contains("Book A Hotel");
         Assert.assertTrue("verify search", contains3);
       //  Assert.assertEquals("verify select", "Book A Hotel", search1);
        
        WebElement keysbook =  findElementByid("book_now");
         click(keysbook);
        Thread.sleep(7000);
        
      //assert 4
        WebElement txtsearch3 =  findElementByXpath("//td[text()='Booking Confirmation']");
        String search3 = getText(txtsearch);
        boolean contains5 = search3.contains("Booking Confirmation");
        Assert.assertTrue("verify search", contains5);
//        Assert.assertEquals("verify select", "Booking Confirmation", search3);
        
        
        //BookingConformation
        WebElement txtOrderno =  findElementByid("order_no");
        String attribute =  getAttribute(txtOrderno, "value");
        
         excelWriteCell("Sheet1",1 ,22, attribute); 
        
        

//
//        WebElement txtconfirmation =  findElementByClassName("login_title");
//        
        
        
}
	
}




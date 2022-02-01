package org.elango;

import java.io.IOException;
import org.openqa.selenium.WebElement;

public class AdactinS {
public static void main(String[] args) throws IOException, InterruptedException {
		
		BaseClassS bc = new BaseClassS();
		
		bc.launchBrowser();
		bc.get("https://adactinhotelapp.com/");
		
	    //LoginPage
	    WebElement txtuser = bc.findElementByid("username");
	    bc.sendKeys(txtuser, bc.getDataFromExcel("Sheet1", 1, 0));
	    
	    WebElement txtpass= bc.findElementByid("password");
	    bc.sendKeys(txtpass, bc.getDataFromExcel("Sheet1", 1, 1));
	    
	    WebElement btnlogin = bc.findElementByid("login");
        bc.click(btnlogin);
    
        //SearchHotel 
        WebElement btnlocation = bc.findElementByid("location");
        bc.click(btnlocation);
        bc.sendKeys(btnlocation,bc.getDataFromExcel("Sheet1",5,2));
        
        WebElement btnroom = bc.findElementByid("room_nos");      
        bc.sendKeys(btnroom,bc.getDataFromExcel("Sheet1", 3, 3));
        
        WebElement btnrooms = bc.findElementByid("room_nos");
        bc.click(btnrooms);
        bc.sendKeys(btnrooms, bc.getDataFromExcel("Sheet1", 2, 4));
        
        WebElement btndatein = bc.findElementByid("datepick_in");
        bc.click(btndatein);
        bc.clear(btndatein);
        bc.sendKeys(btndatein, bc.getDataFromExcel("Sheet1", 1, 10));
        
        WebElement btndateout = bc.findElementByid("datepick_out");;
        bc.click(btndateout);
        bc.clear(btndateout);
        bc.sendKeys(btndateout, bc.getDataFromExcel("Sheet1", 1, 11));
        
        
        WebElement btnadultroom = bc.findElementByid("adult_room");
        bc.click(btnadultroom);
        bc.sendKeys(btnadultroom, bc.getDataFromExcel("Sheet1", 2, 6));
        
        WebElement btnchildroom = bc.findElementByid("child_room");
        bc.click(btnchildroom);
        bc.sendKeys(btnchildroom, bc.getDataFromExcel("Sheet1", 2,6));
        
        WebElement btnclick = bc.findElementByid("Submit");
        bc.click(btnclick);
        
        //SelectHotel 
        WebElement btnhotel = bc.findElementByid("radiobutton_1");
        bc.click(btnhotel);
        
        WebElement btncontinue = bc.findElementByid("continue");
        bc.click(btncontinue);
        Thread.sleep(2000);
        
        //BookaHotel
        WebElement keysfirst = bc.findElementByid("first_name");
        bc.sendKeys(keysfirst,bc.getDataFromExcel("Sheet1", 1, 12));
        
        WebElement keyslast = bc.findElementByid("last_name");
        bc.sendKeys(keyslast, bc.getDataFromExcel("Sheet1", 1, 13));
        
        WebElement keysadd = bc.findElementByid("address");
        bc.sendKeys(keysadd, bc.getDataFromExcel("Sheet1", 1, 14));
        
        WebElement keyscardno = bc.findElementByid("cc_num");
        bc.sendKeys(keyscardno, bc.getDataFromExcel("Sheet1", 1, 15));
        
        WebElement keyscardtype = bc.findElementByid("cc_type");
        bc.sendKeys(keyscardtype, bc.getDataFromExcel("Sheet1", 3,7));
        
        WebElement keysexpmonth = bc.findElementByid("cc_exp_month");
        bc.sendKeys(keysexpmonth, bc.getDataFromExcel("Sheet1", 4,8));
        
        WebElement keysexpyear = bc.findElementByid("cc_exp_year");
        bc.sendKeys(keysexpyear, bc.getDataFromExcel("Sheet1", 12, 9));
       
        WebElement keyscvv = bc.findElementByid("cc_cvv");
        bc.sendKeys(keyscvv, bc.getDataFromExcel("Sheet1", 1,16));
        
        WebElement keysbook = bc.findElementByid("book_now");
        bc.click(keysbook);
        Thread.sleep(7000);
        
        //BookingConformation
        WebElement txtOrderno = bc.findElementByid("order_no");
        String attribute = bc.getAttribute(txtOrderno, "value");
        
        bc.excelWriteCell("Sheet1",1 ,22, attribute); 
        
        WebElement btnitenary = bc.findElementByXpath("//a[text()='Booked Itinerary']");
        bc.click(btnitenary);
        
        
        WebElement btnc1 = bc.findElementByXpath("//input[@name='ids[]']");
        bc.click(btnc1);
        
        WebElement btnc2 = bc.findElementByid("btn_id_542470");
        bc.click(btnc2);
        Thread.sleep(3000);
        bc.accept();
        
}
	
}




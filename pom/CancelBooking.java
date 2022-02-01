package org.pom;

import org.elango.BaseClassS;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CancelBooking extends BaseClassS {
	
	public CancelBooking() {
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(xpath ="//a[text()='Booked Itinerary']")
	private WebElement btnitenary1;
	
	@FindBy(name ="ids[]")
	private WebElement btnselectcancel;
	
	
	@FindBy(id ="btn_id_543685")
	private WebElement btncancel1;


	public WebElement getBtnitenary1() {
		return btnitenary1;
	}


	public WebElement getBtnselectcancel() {
		return btnselectcancel;
	}


	public WebElement getBtncancel1() {
		return btncancel1;
	}
	
	public void cancel() throws InterruptedException {
		click(getBtnitenary1());
		Thread.sleep(2000);
		click(getBtnselectcancel());
		click(getBtncancel1());
		accept();
	

	}
	  
     
     
	

}

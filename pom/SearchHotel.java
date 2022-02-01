package org.pom;

import org.elango.BaseClassS;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchHotel extends BaseClassS {
	
	public SearchHotel() {
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(id ="location")
	private WebElement dDnlocation;
	
	@FindBy(id ="hotels")
	private WebElement dDnhotel;

	@FindBy(id ="room_type")
	private WebElement dDnroomtype;
	
	@FindBy(id ="room_nos")
	private WebElement dDnroomnumber;
	
	@FindBy(id ="datepick_in")
	private WebElement txtid;
	
	@FindBy(id ="datepick_out")
	private WebElement txtout;

	@FindBy(id ="adult_room")
	private WebElement dDnadult;
	
	@FindBy(id ="child_room")
	private WebElement dDnchildren;
	
	@FindBy(id ="Submit")
	private WebElement btnsubmit;

	public WebElement getdDnlocation() {
		return dDnlocation;
	}

	public WebElement getdDnhotel() {
		return dDnhotel;
	}

	public WebElement getdDnroomtype() {
		return dDnroomtype;
	}

	public WebElement getdDnroomnumber() {
		return dDnroomnumber;
	}

	public WebElement getTxtid() {
		return txtid;
	}

	public WebElement getTxtout() {
		return txtout;
	}

	public WebElement getdDnadult() {
		return dDnadult;
	}

	public WebElement getdDnchildren() {
		return dDnchildren;
	}
	public WebElement getbtnsubmit() {
		return btnsubmit;
	}
	
	public void search(String location,String hotels,String roomtype, String roomno, String datein
			,String dateout,String adult, String children) {
		
		selectByVisibleText(getdDnlocation(), location);
		selectByVisibleText(getdDnhotel(), hotels);
		selectByVisibleText(getdDnroomtype(), roomtype);
		selectByVisibleText(getdDnroomnumber(), roomno);
		sendKeys(getTxtid(), datein);
		sendKeys(getTxtout(), dateout);
		selectByVisibleText(getdDnadult(), adult);
		selectByVisibleText(getdDnchildren(), children);
		click(getbtnsubmit());

		
	}
	

}

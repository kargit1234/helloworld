package org.pom;

import org.elango.BaseClassS;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BookConfirmation extends  BaseClassS{
	
	public BookConfirmation() {
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(id ="first_name")
	private WebElement txtfirstname;
	
	@FindBy(id ="last_name")
	private WebElement txtlastname;

	@FindBy(id ="address")
	private WebElement txtaddress;
	
	@FindBy(id ="cc_num")
	private WebElement txtcard;
	
	@FindBy(id ="cc_type")
	private WebElement dDncardtype;
	
	@FindBy(id ="cc_exp_month")
	private WebElement dDnmonth;
	
	@FindBy(id ="cc_exp_year")
	private WebElement dDnyear;
	
	@FindBy(id ="cc_cvv")
	private WebElement txtcvv;
	
	@FindBy(id ="book_now")
	private WebElement btnbook;
	
	
	
	public WebElement getTxtfirstname() {
		return txtfirstname;
	}

	public WebElement getTxtlastname() {
		return txtlastname;
	}

	public WebElement getTxtaddress() {
		return txtaddress;
	}

	public WebElement getTxtcard() {
		return txtcard;
	}

	public WebElement getdDncardtype() {
		return dDncardtype;
	}

	public WebElement getdDnmonth() {
		return dDnmonth;
	}

	public WebElement getdDnyear() {
		return dDnyear;
	}

	public WebElement getTxtcvv() {
		return txtcvv;
	}
	
	public WebElement getbtnbook() {
		return btnbook;
	}

	
	
	public void booking(String txtfirstname,String txtlastname,String txtaddress, String txtcard, String txtcvv
			,String dDncardtype, String Dnmonth, String Dnyear) throws InterruptedException {
	sendKeys(getTxtfirstname(), txtfirstname);
	sendKeys(getTxtlastname(), txtlastname);
	sendKeys(getTxtaddress(), txtaddress);
	sendKeys(getTxtcard(), txtcard);
	selectByVisibleText(getdDncardtype(), dDncardtype);
	selectByVisibleText(getdDnmonth(), Dnmonth);
	selectByVisibleText(getdDnyear(), Dnyear);
	sendKeys(getTxtcvv(), txtcard);
	Thread.sleep(4000);
	click(getbtnbook());
	

}
}

package org.pom;

import org.elango.BaseClassS;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SelectHotel extends BaseClassS{
	
	public SelectHotel() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id ="radiobutton_0")
	private WebElement btnhotel;
	
	@FindBy(id ="continue")
	private WebElement btncontinue;

	public WebElement getBtnhotel() {
		return btnhotel;
	}

	public WebElement getBtncontinue() {
		return btncontinue;
	}
	
	public void selecthotel1() {
		
		click(getBtnhotel());
		click(getBtncontinue());
		
	}
	
	

}

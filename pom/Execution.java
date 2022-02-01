package org.pom;

import org.elango.BaseClassS;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

public class Execution extends BaseClassS{
	
	@BeforeClass
	public static void beforeClass() {
	launchBrowser();
	get("https://adactinhotelapp.com/");
	
	}
	@AfterClass
	public static void afterclass() {
		close();

	}
	@Test
	public void loginadactin() throws InterruptedException {
		Login lo = new Login();
		lo.login1("Elangovan555", "M7I35U");
	
		SearchHotel se = new SearchHotel();
		se.search("Brisbane", "Hotel Sunshine", "Deluxe", "2 - Two","26/01/2022", "27/01/2022", "1 - One", "2 - Two");
		
		SelectHotel se1 = new SelectHotel();
		se1.selecthotel1();
		
		BookConfirmation b1 = new BookConfirmation();
		b1.booking("elango", "m", "trichy crawford", "1212211212233445","1233" , "American Express", "January", "2012");
		
		CancelBooking ca =new CancelBooking();
		ca.cancel();

	
}
}
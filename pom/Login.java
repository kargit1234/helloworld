	package org.pom;
	
	import org.elango.BaseClassS;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.support.FindBy;
	import org.openqa.selenium.support.PageFactory;
	
	public class Login extends BaseClassS {
		
		public Login() {
			PageFactory.initElements(driver, this);
		}
		
		
		@FindBy(id ="username")
		private WebElement txtusername;
		
		@FindBy(id ="password")
		private WebElement txtpassword;
		
		@FindBy(id ="login")
		private WebElement btnlogin;
	
		public WebElement getTxtusername() {
			return txtusername;
		}
	
		public WebElement getTxtpassword() {
			return txtpassword;
		}
	
		public WebElement getBtnlogin() {
			return btnlogin;
		}
		
		public void login1(String username, String password ) {
			sendKeys(getTxtusername(), username);
			sendKeys(getTxtpassword(), password);
			click(getBtnlogin());
	
		}
		
	
	}

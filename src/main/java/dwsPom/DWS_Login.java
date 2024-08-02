package dwsPom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DWS_Login {
	private @FindBy(className ="ico-login")
	WebElement login_link;
	
	private @FindBy(id="Email")
	WebElement username;
	
	private @FindBy(id="Password")
	WebElement password;
	
	private @FindBy(xpath="//input[@value='Log in']")
	WebElement login_button;
	
	 public DWS_Login(WebDriver driver) {
		// TODO Auto-generated constructor stub
		PageFactory.initElements(driver, this);
	}
	 
	 public void login_link()
	 {
		 login_link.click();
	 }
	 
	 public void username(String email)
	 {
		 username.sendKeys(email);;
	 }
	 
	 public void password(String pass)
	 {
		 password.sendKeys(pass);;
	 }
	 
	 public void login_button()
	 {
		 login_button.click();
	 }

}

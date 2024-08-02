package dwsTaskPOM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Task2_DWSLogin {
	
	private @FindBy(className ="ico-login")
	WebElement login_link;
	
	private @FindBy(id="Email")
	WebElement username;
	
	private @FindBy(id="Password")
	WebElement password;
	
	private @FindBy(xpath="//input[@value='Log in']")
	WebElement login_button;
	
	 public Task2_DWSLogin(WebDriver driver) {
		// TODO Auto-generated constructor stub
		PageFactory.initElements(driver, this);
	}
	 
	 public WebElement getLogin_link() {
		login_link.click();
		return login_link;
	}

	public WebElement getUsername(String email) {
		 username.sendKeys(email);
		return username;
	}

	public WebElement getPassword(String pass) {
		 password.sendKeys(pass);
		return password;
	}

	public WebElement getLogin_button() {
		 login_button.click();
		return login_button;
	}

	


}

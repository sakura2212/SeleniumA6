package dwsTaskPOM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Task1_DWSRegistered {
	
public Task1_DWSRegistered(WebDriver driver) {
		
		PageFactory.initElements(driver,this);
	}
	private @FindBy(className = "ico-register")
	WebElement register_link;
	
    private @FindBy(id = "gender-female")
	WebElement gender_female;
	
	private @FindBy(id = "FirstName")
	WebElement firstName;
	
	private @FindBy(xpath = "//input[@id='LastName']")
	WebElement lastName;
	
	private @FindBy(xpath = "//input[@name='Email']")
	WebElement Email;
	
	private @FindBy(xpath  = "//input[@id='Password']")
	WebElement password;
	
	private @FindBy(xpath  = "//input[@id='ConfirmPassword']")
	WebElement confirm_Password;
	
	private @FindBy(id = "register-button")
	WebElement register_button;
	
	public void register_link() {
		
		register_link.click();
	}
     public void gender() {
		
		gender_female.click();
	}
    public void firstname(String fName) {
    	
    	firstName.sendKeys(fName);
    }
    public void lastName(String lName) {
    	
    	lastName.sendKeys(lName);
    }
   public void email(String email) {
    	
    	Email.sendKeys(email);
    }
   public void password(String pass) {
   	
   	password.sendKeys(pass);
   }
   public void confirm_password(String confirmpass) {
   	
   	confirm_Password.sendKeys(confirmpass);
   }
   public void register_button() {
		
		register_button.click();
	}

}

package dwsPom;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DWS_HomePage {
	private @FindBy(xpath="//img[@alt='Tricentis Demo Web Shop']")
	WebElement logo;
	
	private @FindBy(className="ico-register")
	WebElement register;
	
	private @FindBy(className="ico-login")
	WebElement login;
	
	private @FindBy(id="small-searchterms")
	WebElement searchTf;
	
	private @FindBy(xpath="//input[@value='Search']")
	WebElement searchButton;
	
	private @FindBy(xpath="//ul[@class='poll-options']/li/input")
	List<WebElement> poll;
	
	private @FindBy(xpath="//ul[@class='top-menu']/li/a")
	List<WebElement> navBar;
	
	private @FindBy(id="newsletter-email")
	WebElement newsletter;
	
	public DWS_HomePage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		PageFactory.initElements(driver, this);
	}

	public WebElement getLogo() {
		return logo;
	}

	public WebElement getRegister() {
		register.click();
		return register;
	}

	public WebElement getLogin() {
		return login;
	}

	public WebElement getSearchTf(String data) {
		searchTf.sendKeys(data);
		return searchTf;
	}

	public WebElement getSearchButton() {
		searchButton.click();
		return searchButton;
	}

	public List<WebElement> getPoll() {
		return poll;
	}

	public List<WebElement> getNavBar() {
		return navBar;
	}

	public WebElement getNewsletter(String data) {
		newsletter.sendKeys(data);
		return newsletter;
	}
	
	
	
	

}

package dwsPom;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class DWS_DigitalDownload {
	
  private @FindBy(xpath="(//a[contains(text(),'Digital downloads')])[1]")
  WebElement digiDownload;
  
  private @FindBy(id="products-orderby")
  WebElement sortby;
  
  private @FindBy(id="products-pagesize")
  WebElement display;
  
  private @FindBy(id="products-viewmode")
  WebElement view;
  
  
  private @FindBy(xpath ="//input[@value='Add to cart']")
  List<WebElement> addToCart;
  
  public DWS_DigitalDownload(WebDriver driver)
  {
	  PageFactory.initElements( driver,this);
  }

public WebElement getDigiDownload() {
	digiDownload.click();
	return digiDownload;
}

public WebElement getSortby() {
	Select ref =new Select(sortby);
	ref.selectByVisibleText("Price: High to Low");
	return sortby;
}

public WebElement getDisplay() {
	Select ref =new Select(display);
	ref.selectByIndex(2);;
	return display;
}

public WebElement getView() {
	Select ref=new Select(view) ;
	ref.selectByIndex(1);
	return view;
}

public List<WebElement> getAddToCart() {
	return addToCart;
}
  
  

}

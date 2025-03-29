package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LogoutPage extends BaseClass{
	
	public LogoutPage(WebDriver driver)
	{
		super(driver);
	}
	
	@FindBy(xpath="//a[text()='Continue' and @class='btn btn-primary']") WebElement btnCont;
	
	public void clickCont()
	{
		btnCont.click();
	}
	

}

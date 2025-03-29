package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccount extends BaseClass{

	public MyAccount(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath="//div[@id='content']/h2[1]") WebElement header;
	@FindBy(xpath="//a[text()='Logout' and @class='list-group-item']") WebElement btnLogout;
	
	public boolean varifyHeader()
	{
		Boolean bn=header.isDisplayed();
		return bn;
	}
	
	public String varifyHeaderText()
	{
		String bn=header.getText();
		return bn;
	}
	
	public void clickLogout()
	{
		btnLogout.click();
	}
	

}

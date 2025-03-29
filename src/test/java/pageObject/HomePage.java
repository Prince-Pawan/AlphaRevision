package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BaseClass{
	
	public HomePage(WebDriver driver) 
	{
		super(driver);
	}

	@FindBy(xpath="//*[@class='fa fa-user']") WebElement profileLink;
	@FindBy(xpath="//*[@class=\"dropdown-menu dropdown-menu-right\"]//li[2]") WebElement loginLink;
	@FindBy(xpath="//a[text()='MacBook']") WebElement macItem;
	@FindBy(xpath="//a[text()=\"Register\"]") WebElement regLink;
	
	public void clickProfile()
	{
		profileLink.click();
	}
	
	public void clickLogin()
	{
		loginLink.click();
	}
	
	public void selectMac()
	{
		macItem.click();
	}
	
	public void clickReg()
	{
		regLink.click();
	}
	

}

package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MacPage {
	
	WebDriver driver;
	public MacPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	//button[@id='button-cart']
	
	@FindBy(xpath="//button[@id='button-cart']") WebElement btnCart;
	@FindBy(xpath="//div[contains(@class,'alert alert-success alert-dismissible')]") WebElement msgSuccess;
	
	public void clickCart()
	{
		btnCart.click();
	}
	//Success: You have added 
	public String valSuccess()
	{
		String act=msgSuccess.getText();
		return act;
	}
	public boolean valSuccessBol()
	{
		String exp="Success: You have added ";
		String act=msgSuccess.getText();
		if(exp.equals(act))
		{
			return true;
		}
		else
			return false;
	}

}

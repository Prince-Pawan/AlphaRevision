package testCases;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageObject.HomePage;
import pageObject.MacPage;
import testBase.TestBase;

public class TC002_OrderPlacing extends TestBase{
	
	@Test(groups= {"Reg","Feature"})
	public void placingMac() throws InterruptedException
	{
		HomePage hh=new HomePage(driver);
		hh.selectMac();
		Thread.sleep(2000);
		
		MacPage mp=new MacPage(driver);
		mp.clickCart();
		Thread.sleep(2000);
		
		if((mp.valSuccess().contains("added")))
		{
			//Success: You have added MacBook to your shopping cart!
			Assert.assertTrue(true);
		}
		else
		{
			System.out.println("last");
			Assert.fail();
		}
	}

}

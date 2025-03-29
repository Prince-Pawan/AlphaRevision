package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObject.HomePage;
import pageObject.LoginPage;
import pageObject.LogoutPage;
import pageObject.MyAccount;
import testBase.TestBase;

public class TC001_Login extends TestBase {
	
	@Test(groups= {"Reg","Sanity","Feature"})
	public void loginTest() throws InterruptedException
	{
		HomePage hp=new HomePage(driver);
		Thread.sleep(2000);
		hp.clickProfile();
		hp.clickLogin();
		Thread.sleep(2000);
		
		LoginPage lp=new LoginPage(driver);
		lp.setEmail(p.getProperty("email"));
		lp.setPass(p.getProperty("password"));
		lp.clickBtn();
		
		MyAccount ma=new MyAccount(driver);
		boolean c=ma.varifyHeader();
		Assert.assertEquals(c, true);
		
		String s=ma.varifyHeaderText();
		Assert.assertEquals(s,"My Account");
		
		ma.clickLogout();
		
		LogoutPage lop= new LogoutPage(driver);
		lop.clickCont();
		//Assert.fail();
		Assert.assertTrue(true);
		Thread.sleep(2000);
	}
	
	
	

}

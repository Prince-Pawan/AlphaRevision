package testCases;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageObject.HomePage;
import pageObject.RegistrationPage;
import testBase.TestBase;

public class TC003_Registration extends TestBase{
	
	@Test(groups= {"Sanity","Feature"})
	public void Register() throws InterruptedException
	{
		HomePage hp=new HomePage(driver);
		hp.clickProfile();
		hp.clickReg();
		
		RegistrationPage rp=new RegistrationPage(driver);
		
		rp.txtFirst(ranString());
		rp.txtlastName(ranString());
		rp.txte_Mail(ranAlphNum());
		rp.txttelephone(ranINT());
		
		String pass=ranString();
		rp.txtpassword(pass);
		rp.txtpasswordConfirm(pass);
		rp.btnAgree();
		rp.btnCont();
		
		String exp= driver.findElement(By.xpath("//h1[text()='Your Account Has Been Created!']")).getText();
		Assert.assertEquals(exp,"Your Account Has Been Created!");
		
		Thread.sleep(3000);
	}

}

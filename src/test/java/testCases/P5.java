package testCases;

import java.io.File;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class P5 {

	public static void main(String[] args) throws InterruptedException, IOException {
		
		WebDriver driver=new ChromeDriver();
		
		driver.get("https://automationpanda.com/2021/12/29/want-to-practice-test-automation-try-these-demo-sites/");
		
		driver.switchTo().parentFrame();
		
		List <WebElement> li= driver.findElements(By.tagName("a"));
		System.out.println(li.size());
		
		int x=0;
		for(WebElement s:li)
		{
			
			for(int i=0;i<1;i++)
			{
				x++;
			String p= s.getAttribute("href");
			System.out.println(p);
			
			URL url=new URL(p);
			HttpURLConnection conn= (HttpURLConnection)url.openConnection();
			
			conn.connect();
			if(conn.getResponseCode()>=400)
			{
				System.out.println("BROKEN HAI"+"      "+p);
			}
			
			
			}
			if(x==10)
			{
				TakesScreenshot ss= (TakesScreenshot)driver;
				File src= ss.getScreenshotAs(OutputType.FILE);
				File tar= new File("C:\\Users\\Prince Pawan\\eclipse-workspace\\AlphaRevision\\screenshots\\ram.png");
				
				src.renameTo(tar);
				break;	
			}
		}
		
		driver.quit();
		

	}

}

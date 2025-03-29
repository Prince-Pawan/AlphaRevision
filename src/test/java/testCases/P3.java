package testCases;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.time.Duration;
import java.util.List;

import javax.net.ssl.HttpsURLConnection;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class P3 {

	public static void main(String[] args) throws IOException {
		
		
				WebDriver driver = new ChromeDriver();
				driver.get("https://www.geeksforgeeks.org/set-in-java/");
				driver.manage().window().maximize();
				driver.manage().deleteAllCookies();
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
			
			
			List <WebElement> link= driver.findElements(By.tagName("a"));
			
			System.out.println(link.size());
			
			//for(WebElement wl:link)
				
				for(int i=0;i<20;i++)
			{
					WebElement wl= link.get(i);
				String links= wl.getAttribute("href");
				URL url=new URL(links);
				
				HttpURLConnection conn= (HttpURLConnection) url.openConnection();
				conn.connect();
				
				if((conn.getResponseCode()>=400))
				{
					System.out.println(links +"broken me");
				}
				else
				{
					System.out.println(links);
				}
				
				
				
				
			}
			
			
			
			
			
			driver.quit();
			

	}

}

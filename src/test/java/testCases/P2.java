package testCases;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class P2 {

	public static void main(String[] args) {
		
		
		//span[contains(text(),'Collection interface')]
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.geeksforgeeks.org/set-in-java/");
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	
	WebElement link= driver.findElement(By.xpath("//span[contains(text(),'Collection interface')]"));
	
	Actions act= new Actions(driver);
	act.keyDown(Keys.CONTROL).click(link).keyUp(Keys.CONTROL).perform();
	

			Set <String> id=driver.getWindowHandles();
			ArrayList<String> al=new ArrayList(id);
			
			String original= al.get(0);
			String New=al.get(1);
			
			driver.switchTo().window(New);
			System.out.println(driver.getTitle());
			
			driver.switchTo().window(original);
			System.out.println(driver.getTitle());
	
	
	driver.quit();
	}

}

package testCases;

import java.io.File;
import java.time.Duration;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class P1 {

	public static void main(String[] args) throws InterruptedException {
		
		
			WebDriver driver = new ChromeDriver();
			driver.get("https://tutorialsninja.com/demo/");
			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		driver.findElement(By.xpath("//*[@class='fa fa-user']")).click();
		driver.findElement(By.xpath("//*[@class='dropdown-menu dropdown-menu-right']//li[2]")).click();
		
		
		WebElement ss= driver.findElement(By.xpath("//div[@class='row']//div[2]//div[1]//div/ancestor::div[2]"));
		Thread.sleep(3000);
		
		String s=RandomStringUtils.randomAlphanumeric(5);
		
		TakesScreenshot tc= (TakesScreenshot)driver;
		File sc= tc.getScreenshotAs(OutputType.FILE);
		File tr= new File("C:\\Users\\Prince Pawan\\eclipse-workspace\\AlphaRevision\\screenshots\\"+s+".png");
		
		sc.renameTo(tr);
		
		driver.quit();
		

	}

}

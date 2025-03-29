package testBase;

import org.testng.annotations.AfterMethod;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
public class TestBase {
	
	public static WebDriver driver;
	public Properties p;
	
	@BeforeClass
	@Parameters({"browser","os"})
	public void setup(String br, String os) throws IOException
	{
		FileReader fr =new FileReader("C:\\Users\\Prince Pawan\\eclipse-workspace\\AlphaRevision\\src\\test\\resources\\Config.properties");
		p=new Properties();
		p.load(fr);
		
		if(p.getProperty("execution_env").equalsIgnoreCase("remote"))
		{
			DesiredCapabilities cap= new DesiredCapabilities();
			
			if(os.equalsIgnoreCase("windows"))
			{
			cap.setPlatform(Platform.WIN11);
			}
			else if(os.equalsIgnoreCase("linux"))
			{
				cap.setPlatform(Platform.LINUX);
			}
			else if(os.equalsIgnoreCase("mac"))
			{
				cap.setPlatform(Platform.MAC);
			}
			else
			{
				System.out.println("Invalid OS selection");
				return;
			}
			
			switch(br.toLowerCase())
			{
			case "chrome": cap.setBrowserName("chrome"); break;
			case "edge": cap.setBrowserName("MicrosoftEdge"); break;
			case "firefox": cap.setBrowserName("firefox"); break;
			default: System.out.println("Invalid browser"); return;
			}
			
			driver=new RemoteWebDriver(new URL(p.getProperty("remoteURL")),cap);
		}
		
		
		
		
		
		else if(p.getProperty("execution_env").equalsIgnoreCase("local"))
		{
				switch(br.toLowerCase())
				{
					case "chrome":driver= new ChromeDriver(); break;
					case "edge":driver= new EdgeDriver(); break;
					case "firefox":driver= new FirefoxDriver(); break;
					default : System.out.println("Nikl");  return;
					
				}
		}
		
		driver.get(p.getProperty("appURL"));
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	}
	
	@AfterMethod
	@AfterClass
	public void tearDown()
	{
		driver.quit();
	}
	
	public String ranString()
	{
		String ranStr= RandomStringUtils.randomAlphabetic(5);
		return ranStr;
		
	}
	
	public String ranINT()
	{
		String ranNum=RandomStringUtils.randomNumeric(10);
		return ranNum;
	}
	
	public String ranAlphNum()
	{
		String ranStr=RandomStringUtils.randomAlphabetic(3);
		String ranNum=RandomStringUtils.randomNumeric(3);
		return ranStr+ranNum+"@gmail.com";
	}
	
	public String captureScreen(String tname) throws IOException {

		String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date(5));
		
		TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
		File sc= takesScreenshot.getScreenshotAs(OutputType.FILE);
		
		String targetFilePath=System.getProperty("user.dir")+"\\screenshots\\" + tname + "_" + timeStamp + ".png";
		File targetFile=new File(targetFilePath);
		
		sc.renameTo(targetFile);
			
		return targetFilePath;
		/*
		SimpleDateFormat df=new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss");
		Date dt=new Date(5);
		String timestamp=df.format(dt);
		*/

	}
	
	

}

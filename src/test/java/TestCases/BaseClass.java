package TestCases;



import org.apache.log4j.PropertyConfigurator;

import java.io.File;
import java.io.IOException;
//import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import Utilities.ReadConfig;



public class BaseClass {
	ReadConfig readconfig = new ReadConfig();
	
	public String baseURL= readconfig.getApplicationURL();
	public String username= readconfig.getUserName();
	public String password= readconfig.getPassword();
	
	public static WebDriver driver;
	public static Logger Log;
	
	@Parameters("browser")
	@BeforeClass
	public void setup(String br) throws InterruptedException

	{
		//System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"Drivers\\chromedriver.exe");
		//System.setProperty("webdriver.chrome.driver","C:\\Users\\Seema\\eclipse-workspace\\iGuruV1\\Drivers\\chromedriver.exe");
		
		Log = Logger.getLogger("iGuru");
		PropertyConfigurator.configure("Log4j.properties");
		
		if(br.equals("chrome"))
		{
			System.setProperty("webdriver.chrome.driver",readconfig.getChromeDriver());
			driver=new ChromeDriver();
			
		}
		else if(br.equals("edge"))
		{
			System.setProperty("webdriver.chrome.driver",readconfig.getEdgeDriver());
			driver=new EdgeDriver();
			
		}
		else if(br.equals("IE"))
		{
			System.setProperty("webdriver.chrome.driver",readconfig.getIEDriver());
			driver=new InternetExplorerDriver();
			
		}
		else if(br.equals("firefox"))
		{
			System.setProperty("webdriver.chrome.driver",readconfig.getFireFoxDriver());
			driver=new FirefoxDriver();
			
		}
		
		driver.get(baseURL);
		//driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		//Thread.sleep(1000);
	}
	
	@AfterClass
	public void tearDown()
	
	{
		
		driver.quit();
	}
	
	public void captureScreen(WebDriver driver, String tname) throws IOException{
		TakesScreenshot ts =(TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File target = new File(System.getProperty("user.dir")+"/Screenshots/" +tname + ".png");
		FileUtils.copyFile(source, target);
		System.out.println("Screenshot Taken");
	}
}

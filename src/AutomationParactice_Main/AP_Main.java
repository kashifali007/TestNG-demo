package AutomationParactice_Main;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.asserts.Assertion;
import org.testng.asserts.SoftAssert;


public class AP_Main 
{
    public  static WebDriver drv = null;
    public String URL;
    
    public static  Assertion hardAssert = new Assertion();
    public static  SoftAssert softAssert = new SoftAssert();
  
  
  @BeforeSuite 
  public void setup() throws IOException
  {
	  System.out.println("running BeforeSuite");
	  Properties prop = new Properties();
	  FileInputStream fis = new FileInputStream(new File("C:\\Users\\kashif\\workspace\\selenium_tests\\Demo_TestNGFramework\\src\\AutomationParactice_Main\\param.properties"));
	  prop.load(fis);
	  
	  if(prop.getProperty("browser").contains("firefox"))
	  {
		  drv = new FirefoxDriver();
	  }
	  
	  else if(prop.getProperty("browser").contains("InternetExplorer"))
	  {
		  System.setProperty("webdriver.ie.driver", "E:\\selenium\\selenium-java-2.48.2\\IEDriverServer_x64_2.48.0\\IEDriverServer.exe");
		  drv = new InternetExplorerDriver();
	  }
	  
	  else if(prop.getProperty("browser").contains("Googlechrome"))
	  {
		  System.setProperty("webdriver.chrome.driver", "E:\\selenium\\selenium-java-2.48.2\\chromedriver_win32\\chromedriver.exe");  
          drv = new ChromeDriver();
	  }
	  
	  URL = prop.getProperty("url");
  }
	
  @AfterSuite
  public void tearDown()
  {
	  drv.manage().deleteAllCookies();
	  drv.close();
  }
  
  public void takescreenshot(String TestcaseName) throws IOException
  {
	  // Take the screen of current window opened in the browser
	  File screenshot = ((TakesScreenshot)drv).getScreenshotAs(OutputType.FILE);
	  
	  //copy the screen to desktop, we can save it anywhere or we can do whatever we want to do
	  FileUtils.copyFile(screenshot, new File("C:\\Users\\kashif\\workspace\\selenium_tests\\Demo_TestNGFramework\\screenshots\\"+TestcaseName+".png"));
	  
  }
}

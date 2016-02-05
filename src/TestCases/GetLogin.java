package TestCases;

import java.util.concurrent.TimeUnit;

import lib.ExcelConfig;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import AutomationParactice_Main.AP_Main;

public class GetLogin extends AP_Main 
{

	ExcelConfig ExcelObj = new ExcelConfig("C:\\Users\\kashif\\workspace\\selenium_tests\\Demo_TestNGFramework\\src\\Login.xlsx");
	
	
   @BeforeTest
   public void CleanBrowser()
   {
	   drv.manage().deleteAllCookies();
	   drv.manage().window().maximize();
   }
   
   @Test(dataProvider="ReadExcelData",groups={"priority1"})
   public void Login(String username, String password)
   {
	   String beforeTitle;
	   String afterTitle;
	   drv.get(URL);
	   
	   
	   try
	   {
	     //wait for page to synchronize
	     drv.manage().timeouts().implicitlyWait(6000, TimeUnit.MILLISECONDS);
	     beforeTitle = drv.getTitle();
	     String TextSignIn = drv.findElement(By.linkText("Sign in")).getText();
	     Assert.assertEquals(TextSignIn, "Sign in");
	     drv.findElement(By.linkText("Sign in")).click();
	     drv.manage().timeouts().implicitlyWait(6000, TimeUnit.MILLISECONDS);
	     drv.findElement(By.cssSelector("input[id='email']")).sendKeys(username);
		 drv.findElement(By.cssSelector("input[id='passwd']")).sendKeys(password);
		 drv.findElement(By.cssSelector("button[id='SubmitLogin']")).click();
	     afterTitle = drv.getTitle();
	     
	     if(beforeTitle != afterTitle)
	     {
	    	 Assert.assertTrue(true);
	     }
	     
	     else
	     {
	    	 takescreenshot("Login");
	    	 drv.quit();
	    	 Assert.assertTrue(false);
	     }
	  }
	   
	  catch(Exception e)
	   {
		 System.out.println(e.getMessage()); 
	   }
   }
      
   @DataProvider
   public Object[][] ReadExcelData() throws Exception
   {
	   
	   Object[][] getdata = ExcelObj.GetdataFromExcel(0); 
	   return getdata;	   
   }
   
   
   
	
}

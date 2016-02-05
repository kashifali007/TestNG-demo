package TestCases;


import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import AutomationParactice_Main.AP_Main;


public class Verify_Menu extends AP_Main
{
   
  int link;
  int linkSize;
  String Getlinks;
  
  @Test(groups={"priority3"})
  public void verifymenuLink() throws Exception
  {
	  WebElement Menu = drv.findElement(By.xpath(".//*[@id='block_top_menu']"));
	  linkSize = Menu.findElements(By.tagName("a")).size();
	  
	  for(link=0; link<linkSize; link++)
	  {
		  Getlinks = Menu.findElements(By.tagName("a")).get(link).getText();
		  if(Getlinks.equals("WOMEN"))
		  {
		    	 Assert.assertTrue(Menu.findElements(By.tagName("a")).get(link).isDisplayed());
		  }
		  
		  else if(Getlinks.equals("DRESSES"))
		  {
		    	 Assert.assertTrue(true, "DRESSES Link is present");
		  }
		    
		  else if(Getlinks.equals("T-SHIRTS"))
		  {
		    	 Assert.assertTrue(true, "T-SHIRTS Link is present");
		  } 	
		    	 
		  else if(Getlinks.isEmpty() == false)
		  {
		     System.out.println("Executing else block--->"+Getlinks);
		     Assert.assertTrue(false);
		  }
	  }
  }
  
  public void testcaseFailed(String testcaseName) throws IOException
  {
	     takescreenshot(testcaseName);
	     drv.close();
	     softAssert.assertAll();
  }
 
}


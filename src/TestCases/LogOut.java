package TestCases;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import AutomationParactice_Main.AP_Main;

public class LogOut extends AP_Main 
{

	@Test(groups={"priority3"})
	public void logout() throws IOException
	{
		drv.findElement(By.linkText("Sign out")).click();
		String titleLogout = drv.getTitle();
		
		// CHECKING LOGOUT SUCCESSFUL OR NOT BY GETTING THE TITLE OF THE PAGE
		if(titleLogout.contains("My Store") == true)
		{
			Assert.assertTrue(true);
			
		}
		
		else
		{
			
			takescreenshot("logout");
			Assert.assertTrue(false, "Logout failed");
			drv.close();
		}
	}
}


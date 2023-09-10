package TestCases;


import java.io.IOException;

import org.testng.annotations.Test;


import iGuruV1PageObjects.LoginPage;

public class TC_login_001 extends BaseClass
{
	@Test
	public void LoginTest() throws IOException
	{
		driver.get(baseURL);
		Log.info("URL is opened");
		
		LoginPage lp = new LoginPage(driver);
		lp.setUserName(username);
		Log.info("Username entered");
		lp.setPassword(password);
		Log.info("Password entered");
		lp.clickSubmit();
		
	/*	if(driver.getTitle().equals("insight guru"))
		{
			Assert.assertTrue(true);
			Log.info("login test passed");
		}
		else
		{
			captureScreen(driver, "LoginTest");
			Assert.assertTrue(false);
			Log.info("login test failed");
		}
		*/
	}
	
		

}
 
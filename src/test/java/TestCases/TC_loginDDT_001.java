package TestCases;

import java.io.IOException;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Utilities.XLUtils;
import iGuruV1PageObjects.LoginPage;

public class TC_loginDDT_001 extends BaseClass
{

	@Test(dataProvider ="LoginData") 
	public void loginDDT(String user, String pwd ) throws  InterruptedException
	{
		LoginPage lp = new LoginPage(driver);
		lp.setUserName(user);
		Log.info("username provided");
		lp.setPassword(pwd);
		Log.info("password provided");
		lp.clickSubmit();
		Thread.sleep(5000);
		lp.assesseeself();
		Thread.sleep(3000);
		lp.signout();
		lp.signoutyes();
		Thread.sleep(3000);
		
	}
	@DataProvider(name="LoginData")
	String[] []getData() throws IOException
	{
		//String path= System.getProperty("user.dir")+"/src/test/java/TestData/iGurutestdata.xlsx";
		String path ="C:\\Users\\Seema\\eclipse-workspace\\iGuruV1\\src\\test\\java\\TestData\\iGurutestdata.xlsx";
		int rownum= XLUtils.getRowCount(path, "Sheet1");
		int colcount= XLUtils.getCellCount(path, "Sheet1", 1);
		
		String logindata[][]= new String[rownum][colcount];
		
		for (int i=1;i<=rownum;i++)
		{
			for (int j=0;j<colcount;j++)
			{
				logindata[i-1][j]=XLUtils.getCellData(path,"Sheet1", i, j); //1 0
			}
		}
		return logindata;
	}
}

package iGuruV1PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	WebDriver ldriver;
	
	public LoginPage(WebDriver rdriver)
	{
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
	}
	@FindBy(xpath="//input[@type='text']")
	@CacheLookup
	WebElement txtusername;
	
	@FindBy(xpath="//input[@type='password']")
	@CacheLookup
	WebElement txtpassword;
	
	@FindBy(xpath="//span[@class='MuiIconButton-label']//*[name()='svg']")
	@CacheLookup
	WebElement btnlogin;
	
	@FindBy(xpath="//div[@data-value='assessee_card']")
	//@FindBy(xpath="//*[@id=\"main-container\"]/div[2]/div[1]/div/div[2]/div[1]/div/div/div/div[1]")
	@CacheLookup
	WebElement assesseeself;
	
	@FindBy(xpath="//*[@id=\"dialog-description\"]/div/div/div[10]/button")
	@CacheLookup
	WebElement signout;
	
	@FindBy(xpath="//*[@id=\"dialog-description\"]/div/div/div[2]/button/span[1]")
	@CacheLookup
	WebElement signoutyes;
	
	
	public void setUserName(String uname)
	{
		txtusername.sendKeys(uname);
	}
	public void setPassword(String pass)
	{
		txtpassword.sendKeys(pass);
	}
	
	public void clickSubmit()
	{
		btnlogin.click();
	}
	public void assesseeself()
	{
		assesseeself.click();
	}
	public void signout()
	{
		signout.click();
	}
	public void signoutyes()
	{
		signoutyes.click();
	}
	
}

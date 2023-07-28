package PomPolicyUsingTestNG;

import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import CommonMethods.CommonMethoduse;

public class ExcelTest
{
	
	WebDriver driver;
	
	ExcelLogin login;
	
	ExcelAccountPage mypage;
  
	@BeforeClass
	public void launchBrowser()
	{
		ChromeOptions opt =new ChromeOptions();
		opt.addArguments("--disable-notifications");
		driver = new ChromeDriver(opt);
		
		
		driver.manage().window().maximize();
		driver.get("https://www.policybazaar.com/");
		
		login= new ExcelLogin(driver);
		
		mypage=new ExcelAccountPage(driver);
	}
	
	@BeforeMethod
	public void logIntoPoliciBazar() throws EncryptedDocumentException, IOException
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(2000));
		login.clickOnHomePageSignInButton();
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(2000));
		
		login.enterMobileNum(CommonMethoduse.readDataFromExcel(2, 0));
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(2000));
		
		login.clickOnSignInWithPassword();
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(3000));
		
		login.enterPassword(CommonMethoduse.readDataFromExcel(2, 1));
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(2000));
		
		login.clickOnSignInButton();
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(2000));
		
		login.clickOnMyAccount();
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(2000));
	
		login.clickOnMyProfile();
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(2000));
		
		//new tab open we need to switch on new tab
		
	          Set<String> id = driver.getWindowHandles();
	          List <String>li=new ArrayList<String>(id);
	          
	          driver.switchTo().window(li.get(1));
	          
	          driver.manage().timeouts().implicitlyWait(Duration.ofMillis(3000));
	          
	          
	        }
	
	@Test
	public void validateUserName() throws EncryptedDocumentException, IOException
	{
		
		String expectedUsername= CommonMethoduse.readDataFromExcel(3, 0); 
				
		String ActualNameGet=mypage.getActualuserName();
		Assert.assertEquals(expectedUsername, ActualNameGet, " actual and expected name is not match taste case is failed ");
		
		
	}
	
	@AfterMethod
	public void logOutFromPolicy()
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(2000));
		mypage.clickOnLogOutButton();
	}
	
	@AfterClass
	 public void closeBrowser() throws InterruptedException
	 {
		
		Thread.sleep(3000);
		driver.quit();
	 }
}



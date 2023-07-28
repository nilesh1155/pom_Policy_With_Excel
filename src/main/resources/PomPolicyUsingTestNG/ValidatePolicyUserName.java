package PomPolicyUsingTestNG;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ValidatePolicyUserName 
{
	
	WebDriver driver;
	
	LogInPage login;
	
	MyAccountPage mypage;
  
	@BeforeClass
	public void launchBrowser()
	{
		ChromeOptions opt =new ChromeOptions();
		opt.addArguments("--disable-notifications");
		driver = new ChromeDriver(opt);
		
		
		driver.manage().window().maximize();
		driver.get("https://www.policybazaar.com/");
		
		login= new LogInPage(driver);
		
		mypage=new MyAccountPage(driver);
	}
	
	@BeforeMethod
	public void logIntoPoliciBazar()
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(2000));
		login.clickOnHomePageSignInButton();
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(2000));
		
		login.enterMobileNum();
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(2000));
		
		login.clickOnSignInWithPassword();
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(2000));
		login.enterPassword();
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
	          
	          driver.manage().timeouts().implicitlyWait(Duration.ofMillis(2000));
	          
	          
	        }
	
	@Test
	public void validateUserName()
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(2000));
		String expectedUsername= "Nilesh Ande";
		String ActualNameGet=mypage.getActualuserName();
		Assert.assertEquals( ActualNameGet, expectedUsername," actual and expected name is not match taste case is failed ");
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



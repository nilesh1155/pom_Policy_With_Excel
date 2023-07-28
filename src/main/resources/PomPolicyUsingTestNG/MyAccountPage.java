package PomPolicyUsingTestNG;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

public class MyAccountPage {
	//variable
	
		@FindBy(xpath="//div[@class='sc-dxgOiQ VlPVF']/div[contains(@class,'textCapitalize ')]") private WebElement actualName;
		
		@FindBy(className="h_l") private WebElement logoutButton;
		
		//constructor
		public MyAccountPage(WebDriver driver)
		{
			
		PageFactory.initElements(driver,this);	
			
			
		}
		
		public String getActualuserName()
		{
			String actName=actualName.getText();
			return actName;
		}
		
		public void clickOnLogOutButton()
		{
			logoutButton.click();
		}

	
	
}

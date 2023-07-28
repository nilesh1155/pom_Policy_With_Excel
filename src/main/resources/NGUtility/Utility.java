package NGUtility;



	import java.io.File;
	import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
	import org.apache.poi.ss.usermodel.WorkbookFactory;
	import org.openqa.selenium.JavascriptExecutor;
	import org.openqa.selenium.OutputType;
	import org.openqa.selenium.TakesScreenshot;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.io.FileHandler;
import org.testng.Reporter;
import org.testng.annotations.Test;

	
	  
		public class Utility {
		public static void getScreenshot(WebDriver driver,String filename) throws IOException
		{
		File	src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		
		File dest= new File("D:\\getimage\\"+filename+".jpeg");
		
		FileHandler.copy(src,dest);
		
		Reporter.log("taking screenshot",true);
		Reporter.log("screenshot location is"+dest,true);
		}
		
		public static String excelSheet(int row, int cell) throws EncryptedDocumentException, IOException
		{
			FileInputStream myfile=new FileInputStream("D:\\software testing\\Automation Testing Notes\\selenium\\CommonMethods\\dataForCommon.xlsx");
			
			Reporter.log("reading data from excel rownum"+row+"celnum is"+cell,true);
			String value = WorkbookFactory.create(myfile).getSheet("Sheet1").getRow(row).getCell(cell).getStringCellValue();
			
			return value;
			
			
		}
		
		public static void scrollElement(WebDriver driver, WebElement element)
		{
		JavascriptExecutor js	=((JavascriptExecutor)driver);
		
		js.executeScript("arguments[0].scrollIntoView(true)", element);
		
		Reporter.log("scroll to element"+element.getText(),true);
		
		}
		
		public static void timeThread(int time) throws InterruptedException
		{
			
		Thread.sleep(time);
		
		
	}
		
		
		public static String dataByUsingproperty(String key) throws IOException 
		{
			
			Properties prop=new Properties();
			
			FileInputStream myFile=new FileInputStream("C:\\\\Users\\\\niles\\\\eclipse-workspace\\\\Selenium_Java_Project\\\\propertyFile.properties");
			
			prop.load(myFile);
			
			String propertyValue = prop.getProperty(key);
			
			Reporter.log("reading data "+key+"from property file",true);
			return propertyValue;
			
			
		}

}

package projectnew.projectnew;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class homepage extends base{
			public static WebDriver driver;
						 
			@BeforeTest
			public void initialize() throws IOException
			{
			
				 driver =initializeDriver();

			}
			
			
			public static void capturescreenshot() throws IOException
			{
				
				Date d = new Date();
				String Filename =(d.toString().replace(" ", "_").replace(":", "_")+".jpg");
				
				
				File screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
				FileUtils.copyFile(screenshot, new File("/Users/addy/eclipse-workspace/eclipse2020/projectnew2/resources/"+Filename));
				
			}
			
			
			
		@Test(priority=0)
		
		// enter username/ password and click on login button
			
		public void basePageNavigation() throws IOException
			{			
				driver.get(prop.getProperty("url"));	
				
				driver.findElement(By.xpath("//body/app-root[1]/div[2]/app-home[1]/div[1]/div[1]/div[3]/div[1]/a[1]/span[1]")).click();
				
				WebElement email = driver.findElement(By.xpath("//body/app-root[1]/div[2]/app-login[1]/div[1]/div[1]/div[2]/div[1]/div[1]/form[1]/div[2]/div[1]/div[1]/input[1]"));
				email.sendKeys("8004543017");
				
				driver.findElement(By.xpath("//*[@name= 'password']")).sendKeys("Sudhish@1997");
				driver.findElement(By.xpath("//body/app-root[1]/div[2]/app-login[1]/div[1]/div[1]/div[2]/div[1]/div[1]/form[1]/div[2]/div[3]/button[1]/span[1]")).click();
				
			}

		
		//just click on affix seals
		@Test(priority=1)
		
		public void firsttestcase() throws IOException
		{
		
			WebElement affixseals = driver.findElement(By.xpath("//h3[contains(text(),'Affix Seals')]"));
			affixseals.click();		
			
		}
		
		
		@Test(priority=2)
		
		public void validatesealotherIEC() throws IOException
		{
		
		//    validate  seal is of other IEC
			
			
			driver.findElement(By.xpath("//tbody/tr[1]/td[2]/div[1]/div[1]/input[1]")).sendKeys("01435910");
		
			// click on check seal button
			
			driver.findElement(By.xpath("//button[contains(text(),'Check Seal')]")).click();
			
			capturescreenshot();
			
			driver.findElement(By.xpath("//button[contains(text(),'OK')]")).click();
			
			driver.findElement(By.xpath("//tbody/tr[1]/td[2]/div[1]/div[1]/input[1]")).clear();
			
			
		}
		
		
		// validate scanned seal
		
		@Test(priority=3)
		
		public void validatescannedseal() throws IOException
		{
			
			driver.findElement(By.xpath("//tbody/tr[1]/td[2]/div[1]/div[1]/input[1]")).sendKeys("BOLT00913173");
		
			// click on check seal button
			
			driver.findElement(By.xpath("//button[contains(text(),'Check Seal')]")).click();
			
			capturescreenshot();
			
			driver.findElement(By.xpath("//button[contains(text(),'OK')]")).click();
			
		
		
		}
		
		
			@AfterTest
			public void teardown()
			{
				
				//	driver.close();
			
				
	
			}
	
	
	}



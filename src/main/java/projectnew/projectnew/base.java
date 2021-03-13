package projectnew.projectnew;


	import java.io.FileInputStream;
	import java.io.IOException;
	import java.util.Properties;
	import java.util.concurrent.TimeUnit;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.chrome.ChromeDriver;
	import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

	public class base {

		public  WebDriver driver;
		public Properties prop;
	public WebDriver initializeDriver() throws IOException
	{
		
	 prop= new Properties();
	FileInputStream fis=new FileInputStream("/Users/addy/eclipse-workspace/eclipse2020/projectnew2/src/main/java/projectnew/projectnew/data.properties");
	prop.load(fis);
	String browserName=prop.getProperty("browser");
	System.out.println(browserName);

	if(browserName.equals("chrome"))
	{
		 WebDriverManager.chromedriver().setup();
		 driver = new ChromeDriver();
		
	}
	else if (browserName.equals("firefox"))
	{
		 driver= new FirefoxDriver();
	}


	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	return driver;


	}

	}



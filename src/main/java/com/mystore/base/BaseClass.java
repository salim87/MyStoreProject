package com.mystore.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeTest;

public class BaseClass {
	
   public static Properties prop = null;
  // ExtentManager.setExtent();
   
   // Declare ThreadLocal Driver
	public static ThreadLocal<RemoteWebDriver> driver = new ThreadLocal<>();
	//loadConfig method is to load the configuration
  
	@BeforeTest(groups = { "Smoke", "Sanity", "Regression" })
	public void loadConfig() {
		FileInputStream fis = null;
		
	      try {
	         fis = new FileInputStream(System.getProperty("user.dir")+"/Configuration/config.properties");
	         prop = new Properties();
	         prop.load(fis);
	      } catch(FileNotFoundException fnfe) {
	         fnfe.printStackTrace();
	      } catch(IOException ioe) {
	         ioe.printStackTrace();
	      } 
	      
	   }
	
	public static WebDriver getDriver() {
		// Get Driver from threadLocalmap
		return driver.get();
	}
	
		public static void lauchApp(String browserName) {
			//String browserName= System.getProperty("browser");
			if(browserName.equalsIgnoreCase("chrome")) {
				driver.set(new ChromeDriver());
			}else if(browserName.equalsIgnoreCase("firefox")) {
				driver.set( new FirefoxDriver());
			}else if(browserName.equalsIgnoreCase("edge")) {
				driver.set(new EdgeDriver());
			}
			getDriver().manage().window().maximize();
			getDriver().manage().deleteAllCookies();
			getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			getDriver().manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
			getDriver().get(prop.getProperty("url"));
		}
		@AfterSuite(groups = { "Smoke", "Regression","Sanity" })
		public void afterSuite() {
		//	ExtentManager.endReport();
		}
		
	}



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
import org.testng.annotations.BeforeTest;

public class BaseClass {
	public static WebDriver driver;
	
   public static Properties prop = null;
	@BeforeTest
	public void loadConfig() {
		FileInputStream fis = null;
		
	      try {
	         fis = new FileInputStream(System.getProperty("user.dir")+"/Configuration/Config.properties");
	         prop = new Properties();
	         prop.load(fis);
	      } catch(FileNotFoundException fnfe) {
	         fnfe.printStackTrace();
	      } catch(IOException ioe) {
	         ioe.printStackTrace();
	      } 
	      
	   }
	
		public static void lauchApp() {
			String browserName= System.getProperty("browser");
			if(browserName.equalsIgnoreCase("chrome")) {
				driver = new ChromeDriver();
			}else if(browserName.equalsIgnoreCase("firefox")) {
				driver = new FirefoxDriver();
			}else if(browserName.equalsIgnoreCase("edge")) {
				driver = new EdgeDriver();
			}
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
			driver.get(prop.getProperty("url"));
		}
		
		
	}



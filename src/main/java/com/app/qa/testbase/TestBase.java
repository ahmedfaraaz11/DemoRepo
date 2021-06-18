package com.app.qa.testbase;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;

import com.app.qa.util.TestUtil;

public class TestBase
{

	public static WebDriver driver;
	public static Properties prop;
	
	
	public TestBase() {
		
		prop = new Properties();
		try{
		FileInputStream fs = new FileInputStream("C:/SPPAutomation/workspace/RandomProject/src/main/java/com/app/qa/confiq/config.properties");
		prop.load(fs);
		}
		catch (FileNotFoundException e){
			e.printStackTrace();
			
		} catch (IOException e){
			e.printStackTrace();
		}
	}
	
	public static void initialization(){
		String browserName = prop.getProperty("browser");
		
		if(browserName.equals("chrome")){
			System.setProperty("webdriver.chrome.driver", "C:/Users/faraaz_ahmed/Downloads/chromedriver_win32/chromedriver.exe");
			
		}else if(browserName.equals("firefox")){
			System.setProperty("webdriver.gecko.driver", "C:/Users/faraaz_ahmed/Downloads");
		}
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.pageLoadTimeout, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.implicitWait, TimeUnit.SECONDS);
		
		driver.get(prop.getProperty("url"));

		
	}
	
	
}

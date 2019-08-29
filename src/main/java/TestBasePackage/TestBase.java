package TestBasePackage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestBase {
	
	public static Properties prop;
	public static WebDriver driver;
	public TestBase(){
		try {
			prop = new Properties();
			FileInputStream ip = new FileInputStream("D://selenium/workspace/PCUI_Test/src/main/java/config_properties/config.properties");
			prop.load(ip);
		} catch (FileNotFoundException e){
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public static void initialization(){
	  prop.getProperty("browser");
	  
	  System.setProperty("webdriver.chrome.driver", "C://Users/mayank.yadav/Desktop/AUTO/chromedriver.exe");
			 driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
			driver.get(prop.getProperty("url"));	
	}
}

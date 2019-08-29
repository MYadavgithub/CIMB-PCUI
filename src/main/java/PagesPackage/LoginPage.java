package PagesPackage;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;



import TestBasePackage.TestBase;

public class LoginPage extends TestBase{
	 
	
	//Page Factory - OR:
	@FindBy(name="UserNameTB")
	WebElement username;
	
	@FindBy(name="PwdTB")
	WebElement password;
	
	@FindBy(name="CaptchaText" )
	WebElement Captcha;
	
	@FindBy(xpath="//input[@type='submit']")
	WebElement loginBtn;

	
	//Initializing the Page Objects:
	public LoginPage(){
		PageFactory.initElements(driver, this);
	}
	
	//Actions:
	public String validateLoginPageTitle(){
		return driver.getTitle();
		
	}
	public HomePage login(String un, String pwd){
		
		username.sendKeys(un);
		password.sendKeys(pwd);
		Captcha.sendKeys("012345");
		loginBtn.click();
		    	//JavascriptExecutor js = (JavascriptExecutor)driver;
		    	//js.executeScript("arguments[0].click();", loginBtn);
		    	
		return new HomePage();
	}
}

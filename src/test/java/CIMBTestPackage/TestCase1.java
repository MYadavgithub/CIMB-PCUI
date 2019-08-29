package CIMBTestPackage;

import org.testng.annotations.Test;

import PagesPackage.HomePage;
import PagesPackage.LoginPage;
import TestBasePackage.TestBase;


public class TestCase1 extends TestBase {
	
	HomePage homepage;
	LoginPage loginpage;
	
	
	public TestCase1(){
		super();
	}
	
	@Test
  public void login() {
		initialization();
		 loginpage = new LoginPage();
		homepage = loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
		
  }
}

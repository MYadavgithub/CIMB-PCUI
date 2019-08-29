package CIMBTestPackage;

import org.testng.annotations.Test;

import PagesPackage.HomePage;
import PagesPackage.LoginPage;
import PagesPackage.MerchantCreationPage;
import TestBasePackage.TestBase;

public class MerchantCreationTest extends TestBase {

	HomePage homepage;
	LoginPage loginpage;
	MerchantCreationPage mrchntcrt;
	
	
	public MerchantCreationTest(){
		super();
	}
	
	@Test(priority=1)
  public void mrchntcreation() throws InterruptedException {
		initialization();
		loginpage = new LoginPage();
		
		homepage = loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
		mrchntcrt = homepage.CreateApproveMerchant();
		
		mrchntcrt.merchantcreation();
		
}
	
	@Test(priority=2)
	  public void mrchntapprove() throws InterruptedException {
			//initialization();
			loginpage = new LoginPage();
			
			homepage = loginpage.login(prop.getProperty("username1"), prop.getProperty("password1"));
			mrchntcrt = homepage.CreateApproveMerchant();
			
			mrchntcrt.approveMerchant();
			
	}
	
}
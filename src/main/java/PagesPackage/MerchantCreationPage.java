package PagesPackage;

import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import TestBasePackage.TestBase;

public class MerchantCreationPage extends TestBase{

	public static String merchantNamestore;
	public static String merchant_creation_msg;

	@FindBy(xpath = ".//*[@id='MerchantNodeLi']/a")
	@CacheLookup
	WebElement createmerchant;

	@FindBy(xpath = ".//*[@id='MerchantManagement']/a/span[1]")
	WebElement contactCreateMerchantsLink;

	@FindBy(xpath = ".//*[@id='CreateMerchantLI']/a")
	WebElement regustermerchant;

	@FindBy(name = "ctl00$ContentPlaceHolder1$TextBoxDisplayNameIDMerchantName")
	WebElement merchantName;

	@FindBy(name = "ctl00$ContentPlaceHolder1$TextBoxaddress1IDMerchantPanel")
	WebElement merchantAddress1;
	@FindBy(name = "ctl00$ContentPlaceHolder1$ddlCountry")
	WebElement country;

	@FindBy(name = "ctl00$ContentPlaceHolder1$ddlState")
	WebElement merchantState;

	@FindBy(name = "ctl00$ContentPlaceHolder1$ddlCity")
	WebElement merchantCity;
	
	@FindBy(name = "ctl00$ContentPlaceHolder1$TextBoxpinIDMerchantPanel")
	WebElement merchantPin;

	@FindBy(name = "ctl00$ContentPlaceHolder1$MerchantPrimaryContactName")
	WebElement merchantPrimaryContactname;
	@FindBy(name = "ctl00$ContentPlaceHolder1$TextBoxphone_numberIDMerchantPanel")
	WebElement merchantPrimaryPhoneno;
	@FindBy(name = "ctl00$ContentPlaceHolder1$TextBoxmobile_numberIDMerchantPanel")
	WebElement merchantPrimaryMobileNo;
	@FindBy(name = "ctl00$ContentPlaceHolder1$TextBoxemailIDMerchantPanel")
	WebElement merchantPrimaryEmail;

	@FindBy(name = "ctl00$ContentPlaceHolder1$ButtonCreateMerchant")
	WebElement merchantCreatebtn;

	@FindBy(id = "ContentPlaceHolder1_ClosePopup")
	WebElement merchantCreatepopup;
     
	@FindBy(xpath = "/html/body/form/div[2]/div[1]/div[5]/div/div[1]/div[3]/div/label/span[1]/i")
	WebElement addoncheck;

	@FindBy(id = "ContentPlaceHolder1_HubMessageID")
	WebElement merchantCreatepopupText;
	
	
	@FindBy(id = "BankNameDDL")
	WebElement AddonBank;
	
	@FindBy(id = "AccountNumberTB")
	WebElement Addonaccno;
	
	@FindBy(id = "BankIFCSCodeTB")
	WebElement AddonSwift;
	// Initializing the Page Objects:
	public MerchantCreationPage() {
		PageFactory.initElements(driver, this);
	}

	public void merchantcreation() throws InterruptedException {
		Thread.sleep(3000);
		createmerchant.click();
		Thread.sleep(3000);
		contactCreateMerchantsLink.click();
		Thread.sleep(3000);
		regustermerchant.click();
		Random randomGenerator = new Random();
		int randomInt = randomGenerator.nextInt(10);

		merchantName.sendKeys("TestMerchant" + randomInt);
		merchantNamestore = "TestMerchant" + randomInt;
		Thread.sleep(3000);
		merchantAddress1.sendKeys("MALAYSIA");
		Thread.sleep(3000);
		Select contry = new Select(country);
		contry.selectByVisibleText("Malaysia");
		Thread.sleep(3000);
		Select state = new Select(merchantState);
		state.selectByVisibleText("Johor");
		Thread.sleep(3000);
		Select city = new Select(merchantCity);
		city.selectByVisibleText("Batu Pahat");
		Thread.sleep(3000);
		merchantPin.sendKeys("12345");
		merchantPrimaryContactname.sendKeys("Mayank");
		merchantPrimaryPhoneno.sendKeys("12345678");
		merchantPrimaryMobileNo.sendKeys("1234506789");
		merchantPrimaryEmail.sendKeys("mnk@gmail.com");
		

		addoncheck.click();
		//Select bankaddon =new Select(AddonBank);
		//bankaddon.selectByValue("1005");
		//Addonaccno.sendKeys("21354848645151");
		//AddonSwift.sendKeys("CIBBMYKL");
		
		Thread.sleep(1000);
		merchantCreatebtn.click();
		String winHandleBefore = driver.getWindowHandle();
		for (String winHandle : driver.getWindowHandles()) {
			driver.switchTo().window(winHandle);
			// driver.findElement(By.name("ctl00$ContentPlaceHolder1$ApproveBtn")).click();
		}
		Thread.sleep(2000);
		String merchant_creation_msgfull = merchantCreatepopupText.getText();
		merchant_creation_msg = merchant_creation_msgfull.substring(0, 68);
		System.out.println(merchant_creation_msgfull);
		merchantCreatepopup.click();
		Thread.sleep(3000);
		driver.findElement(
				By.xpath("/html/body/form/div[2]/header/nav/div[2]/ul/li/a/span"))
				.click();
		Thread.sleep(1000);
		driver.switchTo().window(winHandleBefore);
		driver.findElement(By.id("Logout")).click();
		// String mer = merchantCreatepopup.getText();
		// System.out.println("my" + mer);

		// merchantCreatepopup.getText();
		// merchantCreatepopup.click();
		Thread.sleep(2000);

	}
	
	public static String merchant_approve_msg;

	@FindBy(xpath = ".//*[@id='MerchantNodeLi']/a")
	WebElement merchantManage;

	@FindBy(xpath = ".//*[@id='MerchantManagement']/a/span[1]")
	WebElement approvemerchant;
	@FindBy(id = "ApproveMerchantLI")
	WebElement merchantApprove;
	@FindBy(id = "SearchAllMerchantBtn")
	WebElement merchantSearchAll;
	@FindBy(id = "ContentPlaceHolder1_MerchantGV_MerchantDetailLB_0")
	WebElement merchantgridview1;
	@FindBy(name = "ctl00$ContentPlaceHolder1$ApproveBtn")
	WebElement merchantApprovebtn;

	public void approveMerchant() throws InterruptedException {

		merchantManage.click();
		Thread.sleep(3000);
		approvemerchant.click();
		Thread.sleep(3000);
		merchantApprove.click();

		merchantSearchAll.click();
		Thread.sleep(3000);

		// waitForNewWindowAndSwitchToIt(driver);
		// String newTitle = getCurrentWindowTitle();
		// Thread.sleep(3000);
		// String handle= driver.getWindowHandle();

		// System.out.println(handle);

		// driver.switchTo().window(handle);
		// driver.switchTo().activeElement();
		// Thread.sleep(3000);

		// driver.findElement(By.id("ApproveBtn")).click();

		String winHandleBefore = driver.getWindowHandle();
		Thread.sleep(1500);
		merchantgridview1.click();
		Thread.sleep(1500);

		// Switch to new window opened
		for (String winHandle : driver.getWindowHandles()) {
			driver.switchTo().window(winHandle);
			// driver.findElement(By.name("ctl00$ContentPlaceHolder1$ApproveBtn")).click();
		}
		Thread.sleep(2000);
		// merchantName
		// =driver.findElement(By.id("TextBoxDisplayNameIDMerchantName")).getText();
		// System.out.println("okmer"+ merchantName);
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		merchantApprovebtn.click();
		Thread.sleep(1000);

		// driver.findElement(By.name("ctl00$ContentPlaceHolder1$RejectionReasonTB")).sendKeys("Reject by script");
		// driver.findElement(By.name("ctl00$ContentPlaceHolder1$RejectionReasonBtn")).click();

		driver.findElement(By.id("ContentPlaceHolder1_ButtonOKApprove"))
				.click();
		String merchantID = driver.findElement(
				By.id("ContentPlaceHolder1_HubMessageID")).getText();
		String merchant_approve_msgfull = driver.findElement(
				By.id("ContentPlaceHolder1_HubMessageID")).getText();
		merchant_approve_msg = merchant_approve_msgfull.substring(0, 46);
		System.out.println(merchantID);
		// Thread.sleep(3000);
		// driver.findElement(By.id("alertify-ok")).click();
		// Close the new window, if that window no more required
		driver.close();

		// Switch back to original browser (first window)
		//driver.switchTo().window(winHandleBefore);
		//Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id='TopDiv']/nav/div[2]/ul/li"))
		.click();
		Thread.sleep(1000);
		driver.switchTo().window(winHandleBefore);
		driver.findElement(By.id("Logout")).click();
		// String mer = merchantCreatepopup.getText();
		// System.out.println("my" + mer);

		// merchantCreatepopup.getText();
		// merchantCreatepopup.click();
		Thread.sleep(2000);

	}
}

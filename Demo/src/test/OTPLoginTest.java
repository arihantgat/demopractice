package test;

import org.testng.annotations.Test;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import pages.OTPLoginPage;

public class OTPLoginTest {
	private WebDriver driver;
	private OTPLoginPage otploginpage;
	
	@BeforeClass
	public void SetUp() {
	System.setProperty("webdriver.chrome.driver", "C:\\Users\\Ragnar\\Documents\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
	driver = new ChromeDriver();
	otploginpage = new OTPLoginPage(driver);
	driver.manage().window().maximize();
	driver.get("https://practice.expandtesting.com/otp-login#google_vignette");
	
	}
//	@Test
//	public void testValidOTP() throws InterruptedException {
//		otploginpage.loginValidUsername("username", "otp");
//	}
//	@Test
//	public void testInvalidUsername() throws InterruptedException {
//		otploginpage.loginInvalidUsername("username");
//	}
	@Test
	public void testInvalidOTP() throws InterruptedException {
		otploginpage.loginInvalidOTP("username", "otp");
	}
	@AfterClass
	 public void tearDown() {
       if (driver != null) {
           driver.quit();
       }
	}
}

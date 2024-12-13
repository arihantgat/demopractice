package test;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pages.LoginPage;
import pages.RegistrationPage;


public class RegistrationTest {
	private WebDriver driver;
	private RegistrationPage registrationpage;
	private LoginPage loginpage;
	
	@BeforeClass
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Ragnar\\Downloads\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
		driver = new ChromeDriver();
		registrationpage = new RegistrationPage(driver);
		loginpage = new LoginPage(driver);
		driver.manage().window().maximize();
		driver.get("https://practice.expandtesting.com/register");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
	}
	@Test (priority = 2)
	public void testregisterwithvalidcredentials() throws InterruptedException {
		registrationpage.registerwithvalidcredentials("username", "password", "confirmpassword");
	}
	
	@Test (priority = 1)
	public void testregisterwithinvalidcredentials() {
		registrationpage.registerwithinvalidcredentials("username", "password", "confirmpassword");
	}
	@Test(priority = 3)
	public void testValidLogin() throws InterruptedException {
		loginpage.loginValidCredentials("username", "password");
	}
	@AfterClass
	public void tearDown() {
		if (driver != null) {
            driver.quit();
        }
	}
}

package test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import pages.LoginPage;

public class LoginTest {
	private WebDriver driver;
	private LoginPage loginpage;
	
	@BeforeClass
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Ragnar\\Downloads\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
		driver = new ChromeDriver();
		
		// Initialize the LoginPage object
		loginpage = new LoginPage(driver);
		driver.manage().window().maximize();
		driver.get("https://practice.expandtesting.com/login");
		
	}
	
	@Test(priority = 1)
	public void testValidLogin() throws InterruptedException {
		loginpage.loginValidCredentials("username", "password");
	}
	
	@Test(priority = 2)
	public void testInvalidValidLogin() throws InterruptedException {
		loginpage.loginInvalidCredentials("username", "password");
		Assert.assertEquals(driver.findElement(By.xpath("//div[@id='flash']")).getText(), "Your username is invalid!");
		System.out.println(driver.findElement(By.xpath("//div[@id='flash']")).getText());
		
	}
	
	@AfterClass
	 public void tearDown() {
        // Close the browser
        if (driver != null) {
            driver.quit();
        }
	}
}

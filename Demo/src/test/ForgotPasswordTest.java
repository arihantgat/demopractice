package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pages.ForgotPasswordPage;
import pages.LoginPage;

public class ForgotPasswordTest {

		private WebDriver driver;
		private ForgotPasswordPage forgotpasswordpage;
		
		@BeforeClass
		public void setUp() {
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\Ragnar\\Documents\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
			driver = new ChromeDriver();
			
			// Initialize the LoginPage object
			forgotpasswordpage = new ForgotPasswordPage(driver);
			driver.manage().window().maximize();
			driver.get("https://practice.expandtesting.com/forgot-password");
		}
		
		@Test
		public void testvalidemail() throws InterruptedException {
			forgotpasswordpage.retrivepasswordwithvalidemail("email");
		}
		
		@AfterClass
		 public void tearDown() {
	        // Close the browser
	        if (driver != null) {
	            driver.quit();
	        }

		}

}

package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pages.FormValidationPage;

public class FormValidationTest {

		private WebDriver driver;
		private FormValidationPage formvalidationpage;
		
		@BeforeClass
		public void setUp() {
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\Ragnar\\Documents\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
			driver = new ChromeDriver();
			formvalidationpage = new FormValidationPage(driver);
			driver.manage().window().maximize();
			driver.get("https://practice.expandtesting.com/form-validation");
		}
		
		@Test
		public void filltheform() {
			formvalidationpage.fillform("username", "phonenumber", "date");
		}
		
		@AfterClass
		public void tearDown() {
			if(driver != null) {
				driver.quit();
			}
		}
}

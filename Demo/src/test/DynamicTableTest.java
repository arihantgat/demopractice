package test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pages.DynamicTablePage;

public class DynamicTableTest {

	    private WebDriver driver;
		private DynamicTablePage dynamictablepage;
		
		@BeforeClass
		public void SetUp() throws InterruptedException {
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\Ragnar\\Documents\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
			driver = new ChromeDriver();
			dynamictablepage = new DynamicTablePage(driver);
			driver.manage().window().maximize();
			driver.get("https://practice.expandtesting.com/dynamic-table");
			Thread.sleep(5000);
		}
		
//		@Test(priority = 1)
//		public void printtableHeaders() {
//			dynamictablepage.printHeaders();
//		}
//		@Test(priority = 2)
//		public void printtablevalues() {
//			dynamictablepage.printtableValues();
//		}
		@Test(priority = 3)
		public void printtablespecificvalues() {
			dynamictablepage.printtablespecificValues();
		}
		@AfterClass
		public void TearDown() {
			if(driver != null) {
				driver.quit();
			}
		}
}

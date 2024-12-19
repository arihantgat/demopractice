package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pages.AutocompletePage;

public class AutoCompleteTest {

		private WebDriver driver;
		private AutocompletePage autocompletepage;
		
		@BeforeClass
		public void setUp() {
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\Ragnar\\Documents\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
			driver = new ChromeDriver();
			autocompletepage = new AutocompletePage(driver);
			driver.manage().window().maximize();
			driver.get("https://practice.expandtesting.com/autocomplete");
		}
		
		@Test
		public void selectValue() throws InterruptedException {
			autocompletepage.selectvalue("value");
		}
		
		@AfterClass
		public void tearDown() {
			if(driver != null) {
				driver.quit();
			}
		}
}

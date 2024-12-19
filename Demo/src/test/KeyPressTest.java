package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pages.AutocompletePage;
import pages.KeyPressPage;

public class KeyPressTest {

		private WebDriver driver;
		private KeyPressPage keypresspage;
		
		@BeforeClass
		public void setUp() {
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\Ragnar\\Documents\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
			driver = new ChromeDriver();
			keypresspage = new KeyPressPage(driver);
			driver.manage().window().maximize();
			driver.get("https://practice.expandtesting.com/key-presses?");
		}
		
		@Test
		public void keypress() throws InterruptedException {
			keypresspage.keypress();
		}
		
		@AfterClass
		public void tearDown(){
			if(driver != null) {
				driver.quit();
			}
		}
}

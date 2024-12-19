package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pages.BrowserInformationPage;
import pages.RadioButtonPage;

public class RadioButtonTest {

		private WebDriver driver;
		private RadioButtonPage radiobuttonpage;
		
		@BeforeClass
		public void setUp() {
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\Ragnar\\Documents\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
			driver = new ChromeDriver();
			radiobuttonpage = new RadioButtonPage(driver);
			driver.manage().window().maximize();
			driver.get("https://practice.expandtesting.com/radio-buttons");
		}
		
		@Test(priority = 1)
		public void selectfavcolour() {
			radiobuttonpage.checkblack();
			System.out.println();
		}
		
		@Test(priority = 2)
		public void selectfavgame() {
			radiobuttonpage.checkfootball();
			System.out.println();
		}
		
		@AfterClass
		public void tearDown() {
			if(driver != null) {
				driver.quit();
			}
		}
}

package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pages.DragandDropPage;

public class DragandDropTest {

		private WebDriver driver;
		private DragandDropPage draganddroppage;
		
		@BeforeClass
		public void setUp() {
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\Ragnar\\Documents\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
			driver = new ChromeDriver();
			draganddroppage = new DragandDropPage(driver);
			driver.manage().window().maximize();
			driver.get("https://practice.expandtesting.com/drag-and-drop");
		}
		
		@Test
		public void dragAintoB() {
			draganddroppage.dragAintoB();
		}
//		@Test
//		public void dragBintoA() {
//			draganddroppage.dragBintoA();
//		}
		
		@AfterClass
		public void tearDown() {
			if(driver != null) {
				driver.quit();
			}
		}
}

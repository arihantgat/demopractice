package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pages.DynamicElementPage;
import pages.MultipleWindowPage;

public class DynamicElementTest {
	private WebDriver driver;
	private DynamicElementPage dynamicelementpage;
	
	@BeforeClass
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Ragnar\\Documents\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
		driver = new ChromeDriver();
		dynamicelementpage = new DynamicElementPage(driver);
		driver.manage().window().maximize();
		//driver.get("https://practice.expandtesting.com/dynamic-loading/1");
		driver.get("https://practice.expandtesting.com/dynamic-loading/2");
	}
	
//	@Test
//	public void elementhidden() throws InterruptedException {
//		dynamicelementpage.elementpresentonpage();
//	}
	
	@Test
	public void elementadded() throws InterruptedException {
		dynamicelementpage.elementaddedonpage();
	}
	
	@AfterClass
	public void tearDown() throws InterruptedException {
		if(driver != null) {
			driver.quit();
		}
	}
}

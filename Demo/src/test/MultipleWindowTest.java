package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pages.AutocompletePage;
import pages.MultipleWindowPage;

public class MultipleWindowTest {
	private WebDriver driver;
	private MultipleWindowPage multiplewindowpage;
	
	@BeforeClass
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Ragnar\\Documents\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
		driver = new ChromeDriver();
		multiplewindowpage = new MultipleWindowPage(driver);
		driver.manage().window().maximize();
		driver.get("https://practice.expandtesting.com/windows");
	}
	
	@Test
	public void selectValue() throws InterruptedException {
		multiplewindowpage.clickonlink();
	}
	
	@AfterClass
	public void tearDown() throws InterruptedException {
		if(driver != null) {
			driver.close();
			Thread.sleep(2000);
			driver.quit();
		}
	}
}

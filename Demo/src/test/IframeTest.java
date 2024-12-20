package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pages.AutocompletePage;
import pages.IframePage;

public class IframeTest {
	private WebDriver driver;
	private IframePage iframepage;

	@BeforeClass
	public void setUp() {
		System.setProperty("webdriver.chrome.driver","C:\\Users\\Ragnar\\Documents\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
		driver = new ChromeDriver();
		iframepage = new IframePage(driver);
		driver.manage().window().maximize();
		driver.get("https://practice.expandtesting.com/iframe");
	}

//	@Test
//	public void Youtube() throws InterruptedException {
//		iframepage.youtube();
//	}
	
//	@Test
//	public void Text() throws InterruptedException {
//		iframepage.text();
//	}
	
	@Test
	public void Subscribe() throws InterruptedException {
		iframepage.email();
	}
	@AfterClass
	public void tearDown() {
		if (driver != null) {
			driver.quit();
		}
	}
}

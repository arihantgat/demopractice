package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pages.BrowserInformationPage;

public class BrowserInformationTest {
	private WebDriver driver;
	private BrowserInformationPage browserinformationpage;
	
	@BeforeClass
	public void SetUp() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Ragnar\\Documents\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
		driver = new ChromeDriver();
		browserinformationpage = new BrowserInformationPage(driver);
		driver.manage().window().maximize();
		driver.get("https://practice.expandtesting.com/my-browser");
	}
	
	@Test
	public void printDetails() {
		browserinformationpage.clickbrowserdetailsButton();
		browserinformationpage.printbrowserDetails();
	}
	
	@AfterClass
	public void TearDown() {
		if(driver != null) {
			driver.quit();
		}
	}
}

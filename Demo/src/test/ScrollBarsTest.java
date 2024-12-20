package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pages.HoverPage;
import pages.ScrollBarsPage;

public class ScrollBarsTest {
	private WebDriver driver;
	private ScrollBarsPage scrollbarspage;
	
	@BeforeClass
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Ragnar\\Documents\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
		driver = new ChromeDriver();
		scrollbarspage = new ScrollBarsPage(driver);
		driver.manage().window().maximize();
		driver.get("https://practice.expandtesting.com/scrollbars");
	}
	
	@Test
	public void ClickButton() {
		scrollbarspage.clickhiddenbutton();
	}
	
	@AfterClass()
	public void tearDown() {
		if(driver != null) {
			driver.quit();
		}
	}
}

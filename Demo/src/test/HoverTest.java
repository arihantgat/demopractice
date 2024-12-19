package test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pages.HoverPage;

public class HoverTest {
	private WebDriver driver;
	private HoverPage hoverpage;
	
	@BeforeClass
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Ragnar\\Documents\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
		driver = new ChromeDriver();
		hoverpage = new HoverPage(driver);
		driver.manage().window().maximize();
		driver.get("https://practice.expandtesting.com/hovers");
	}
	
	@Test
	public void Hover() {
		hoverpage.hover();
	}
	
	@AfterClass()
	public void tearDown() {
		if(driver != null) {
			driver.quit();
		}
	}
}

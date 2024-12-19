package test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class SliderTest {

	WebDriver driver;
	
	@BeforeClass
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Ragnar\\Documents\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://practice.expandtesting.com/horizontal-slider");
	}
	
	@Test
	public void slide() {
		WebElement slider = driver.findElement(By.xpath("//input[@type='range']"));
		Actions action = new Actions(driver);
		action.moveToElement(slider)
		.clickAndHold()
		.moveByOffset(0, 0)
		.release()
		.perform();
	}
	
	@AfterClass()
	public void tearDown() {
		if(driver != null) {
			//driver.quit();
		}
	}
}

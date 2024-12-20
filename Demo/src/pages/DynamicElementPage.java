package pages;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DynamicElementPage {

		private WebDriver driver;
		private By startButton = By.xpath("//button[@class='btn btn-primary' and text()='Start']");
		private By text = By.xpath("//div[@id='finish']");
		private By startButton1 = By.xpath("//button[@class='btn btn-primary' and text()='Start']");
		private By text1 = By.xpath("//div[@id='finish']");
		
		public DynamicElementPage(WebDriver driver) {
			this.driver = driver;
		}
		
		public void elementpresentonpage() {
			driver.findElement(startButton).click();
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.visibilityOfElementLocated(text));
			System.out.println("Element is loaded");
		}
		
		public void elementaddedonpage() {
			driver.findElement(startButton1).click();
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.visibilityOfElementLocated(text1));
			System.out.println("Element is added");
		}
}

package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class KeyPressPage {

		private WebDriver driver;
		
		public KeyPressPage(WebDriver driver) {
			this.driver = driver;
		}
		
		public void keypress() throws InterruptedException {
			WebElement inputField = driver.findElement(By.xpath("//input[@id='target']"));
			Actions action = new Actions(driver);
			action.sendKeys(inputField, Keys.TAB).perform();
			String msg = driver.findElement(By.xpath("//p[@id='result']")).getText();
			System.out.println(msg);
		}
}

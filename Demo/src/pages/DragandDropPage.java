package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

public class DragandDropPage {

		private WebDriver driver;
		private By dragA = By.xpath("//div[@id='column-a']");
		private By dragB = By.xpath("//div[@id='column-b']");
		
		public DragandDropPage(WebDriver driver) {
			this.driver = driver;
		}
		
		public void dragAintoB() {
			WebElement A = driver.findElement(dragA);
			WebElement B = driver.findElement(dragB);
			Actions action = new Actions(driver);
			action.dragAndDrop(A, B).build().perform();
			String actualText = driver.findElement(By.xpath("//div[@id='column-b']//header[text()]")).getText();
			String expectedText = "A";
			Assert.assertEquals(actualText, expectedText);
			System.out.println("A block dropped into B block");
		}
		
		public void dragBintoA() {
			WebElement A = driver.findElement(dragB);
			WebElement B = driver.findElement(dragA);
			Actions action = new Actions(driver);
			action.dragAndDrop(B, A).build().perform();
			String actualText = driver.findElement(By.xpath("//div[@id='column-a']//header[text()]")).getText();
			String expectedText = "B";
			Assert.assertEquals(actualText, expectedText);
			System.out.println("B block dropped into A block");
		}
}

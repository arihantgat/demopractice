package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ScrollBarsPage {

		private WebDriver driver;
		private By button = By.xpath("//button[@id='hidingButton']");
		
		public ScrollBarsPage(WebDriver driver){
			this.driver = driver;
		}
		
		public void clickhiddenbutton() {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
			WebElement Button = driver.findElement(button);
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView(true);", Button);
			wait.until(ExpectedConditions.elementToBeClickable(Button));
			Button.click();
			System.out.println("Button clicked successfully");
		}
}

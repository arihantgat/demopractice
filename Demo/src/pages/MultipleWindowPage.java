package pages;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MultipleWindowPage {
	
	private WebDriver driver;
	private By link = By.linkText("Click Here");
	
	public MultipleWindowPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public void clickonlink() throws InterruptedException {
		String mainWIndowHandle = driver.getWindowHandle();
		System.out.println("Title of window: "+driver.getTitle());
		driver.findElement(link).click();
		Set<String> allWindowHandles = driver.getWindowHandles();
		for(String handle : allWindowHandles) {
			if(!handle.equals(mainWIndowHandle)) {
				driver.switchTo().window(handle);
				break;
			}
		}
		System.out.println("New tab title: " + driver.getTitle());
		driver.switchTo().window(mainWIndowHandle);
		Thread.sleep(2000);
	}
}

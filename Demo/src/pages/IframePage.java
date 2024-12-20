package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class IframePage {

		private WebDriver driver;
		private By youtubeIframe = By.xpath("//iframe[@id='iframe-youtube']");
		private By playButton = By.xpath("//button[@title='Play']");
		private By pauseButton = By.xpath("//button[@title='Pause (k)']");
		private By textIframe = By.xpath("//iframe[@title='Rich Text Area']");
		private By fileButton = By.xpath("//span[text()='File']");
		private By textField = By.xpath("//body[@id='tinymce']");
		private By emailIframe = By.xpath("//iframe[@id='email-subscribe']");
		private By emailtextField = By.xpath("//input[@id='email']");
		private By subscribeButton = By.xpath("//button[@type='submit']");
		
		public IframePage(WebDriver driver) {
			this.driver = driver;
		}
		public void youtube() throws InterruptedException {
			WebElement YouTubeiframe = driver.findElement(youtubeIframe);
			driver.switchTo().frame(YouTubeiframe);
			driver.findElement(playButton).click();
			Thread.sleep(5000);
			driver.findElement(pauseButton).click();
			driver.switchTo().defaultContent();
		}
		
		public void text() throws InterruptedException {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			WebElement Textiframe = driver.findElement(textIframe);
			js.executeScript("arguments[0].scrollIntoView(true);", Textiframe);
			driver.switchTo().frame(Textiframe);
//			driver.findElement(fileButton).click();
//			List<WebElement> items = driver.findElements(By.xpath("//div[@class='tox-tiered-menu']//div[@role='menu']"));
//			for(WebElement item : items) {
//				if(item.getText().equals("New document"));
//				item.click();
//				break;
//			}
			driver.findElement(textField).clear();
			driver.findElement(textField).sendKeys("Hi there!" + "\n" + "I'm typing inside the iframe");
			Thread.sleep(5000);
			driver.switchTo().defaultContent();
		}
		
		public void email() throws InterruptedException {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			WebElement Emailiframe = driver.findElement(emailIframe);
			js.executeScript("arguments[0].scrollIntoView(true);", Emailiframe);
			driver.switchTo().frame(Emailiframe);
			driver.findElement(emailtextField).sendKeys("arihantgat@gmail.com");
			Thread.sleep(2000);
			WebElement SubscribeButton = driver.findElement(subscribeButton);
			js.executeScript("arguments[0].scrollIntoView(true);", SubscribeButton);
			driver.findElement(subscribeButton).click();
			if(driver.findElement(By.xpath("//div[@id='success-message']")).getText().equals("You are now subscribed!")) {
				System.out.println("Subscribed successfully");
			}else {
				System.out.println("Subscription unsuccessfull");
			}
		}
}

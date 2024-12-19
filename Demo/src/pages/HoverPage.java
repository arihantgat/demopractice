package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class HoverPage {

		private WebDriver driver;
		private By user1 = By.xpath("(//img[@alt='User Avatar'])[1]");
		private By user2 = By.xpath("(//img[@alt='User Avatar'])[2]");
		private By user3 = By.xpath("(//img[@alt='User Avatar'])[3]");
		
		public HoverPage(WebDriver driver) {
			this.driver = driver;
		}
		
		public void user1() {
			driver.findElement(user1);
		}
		public void hover() {
			WebElement User1 = driver.findElement(user1);
			Actions action = new Actions(driver);
			action.moveToElement(User1).build().perform();
			driver.findElement(By.linkText("View profile")).click();
			if(driver.getCurrentUrl().equals("https://practice.expandtesting.com/users/1")) {
				System.out.println(driver.findElement(By.xpath("//h2")).getText());
			}
		}
}

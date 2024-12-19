package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RadioButtonPage {

		private WebDriver driver;
		private By blue = By.xpath("//input[@id='blue']");
		private By red = By.xpath("//input[@id='red']");
		private By yellow = By.xpath("//input[@id='yellow']");
		private By black = By.xpath("//input[@id='black']");
		private By green = By.xpath("//input[@id='green']");
		private By basketball = By.xpath("//input[@id='basketball']");
		private By football = By.xpath("//input[@id='football']");
		private By tennis = By.xpath("//input[@id='tennis']");
		
		public RadioButtonPage(WebDriver driver) {
			this.driver = driver;
		}
		public void checkblue() {
			WebElement checkblue = driver.findElement(blue);
			JavascriptExecutor js = (JavascriptExecutor) driver;
	        js.executeScript("arguments[0].scrollIntoView(true);", checkblue);
			checkblue.click();
			boolean isChecked = checkblue.isSelected();
			if(isChecked) {
				System.out.println("Blue colour is checked");
			}
		}
		public void checkred() {
			WebElement checkred = driver.findElement(red);
			JavascriptExecutor js = (JavascriptExecutor) driver;
	        js.executeScript("arguments[0].scrollIntoView(true);", checkred);
			checkred.click();
			boolean isChecked = checkred.isSelected();
			if(isChecked) {
				System.out.println("Red colour is checked");
			}
		}
		public void checkyellow() {
			WebElement checkyellow = driver.findElement(yellow);
			JavascriptExecutor js = (JavascriptExecutor) driver;
	        js.executeScript("arguments[0].scrollIntoView(true);", checkyellow);
			checkyellow.click();
			boolean isChecked = checkyellow.isSelected();
			if(isChecked) {
				System.out.println("Yellow colour is checked");
			}
		}
		public void checkblack() {
			WebElement checkblack = driver.findElement(black);
			JavascriptExecutor js = (JavascriptExecutor) driver;
	        js.executeScript("arguments[0].scrollIntoView(true);", checkblack);
			checkblack.click();
			boolean isChecked = checkblack.isSelected();
			if(isChecked) {
				System.out.println("Black colour is checked");
			}
		}
		public void checkgreen() {
			WebElement checkgreen = driver.findElement(green);
			JavascriptExecutor js = (JavascriptExecutor) driver;
	        js.executeScript("arguments[0].scrollIntoView(true);", checkgreen);
			checkgreen.click();
			boolean isChecked = checkgreen.isSelected();
			if(isChecked) {
				System.out.println("Green colour is checked");
			}
		}
		public void checkbasketball() {
			WebElement checkbasketball = driver.findElement(basketball);
			JavascriptExecutor js = (JavascriptExecutor) driver;
	        js.executeScript("arguments[0].scrollIntoView(true);", checkbasketball);
			checkbasketball.click();
			boolean isChecked = checkbasketball.isSelected();
			if(isChecked) {
				System.out.println("Basketball colour is checked");
			}
		}
		public void checkfootball() {
			WebElement checkfootball = driver.findElement(football);
			JavascriptExecutor js = (JavascriptExecutor) driver;
	        js.executeScript("arguments[0].scrollIntoView(true);", checkfootball);
			checkfootball.click();
			boolean isChecked = checkfootball.isSelected();
			if(isChecked) {
				System.out.println("Football colour is checked");
			}
		}
		public void checktennis() {
			WebElement checktennis = driver.findElement(tennis);
			JavascriptExecutor js = (JavascriptExecutor) driver;
	        js.executeScript("arguments[0].scrollIntoView(true);", checktennis);
			checktennis.click();
			boolean isChecked = checktennis.isSelected();
			if(isChecked) {
				System.out.println("Tennis colour is checked");
			}
		}
		
}

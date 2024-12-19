package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AutocompletePage {

		private WebDriver driver;
		private By textbox = By.xpath("//input[@type='text']");
		private By submitbutton = By.xpath("//button[@onclick='displayResult()']");
		
		public AutocompletePage(WebDriver driver) {
			this.driver = driver;
		}
		
		public void entervalue(String value) throws InterruptedException {
			driver.findElement(textbox).sendKeys("ind");
			Thread.sleep(2000);
		}
		
		public void getvaluefromlist() {
			List<WebElement> list = driver.findElements(By.xpath("//div[@class='col-md-4']//div//div"));
			for(WebElement lists : list) {
				if(lists.getText().equals("India")) {
					lists.click();	
				}else {
					System.out.println("Desired country not found");
				}
				break;
			}
		}
		
		public void clickSubmit() {
			driver.findElement(submitbutton).click();
			System.out.println(driver.findElement(By.xpath("//p[@id='result']")).getText());
		}
		
		public void selectvalue(String value) throws InterruptedException {
			entervalue(value);
			getvaluefromlist();
			clickSubmit();
		}
}

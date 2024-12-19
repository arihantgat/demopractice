package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BrowserInformationPage {

	 private WebDriver driver;
	 private By button = By.xpath("//button[@id='browser-toggle']");
	 private By table = By.xpath("//table[@class='table table-bordered']");
	 
	 public BrowserInformationPage(WebDriver driver){
		 this.driver = driver;
	 }
	 public void clickbrowserdetailsButton() {
		 driver.findElement(button).click();
	 }
	 public void printbrowserDetails() {
		WebElement Table =  driver.findElement(table);
		List<WebElement> rows = Table.findElements(By.tagName("tr"));
		for(int i=0; i<rows.size(); i++) {
			List<WebElement> cols = rows.get(i).findElements(By.tagName("td"));
			for(WebElement col : cols) {
				System.out.println(col.getText() + "\t");
			}
			System.out.println();
		}
	}
}

package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import io.opentelemetry.exporter.logging.SystemOutLogRecordExporter;

public class DynamicTablePage {
	private WebDriver driver;
	
	public DynamicTablePage(WebDriver driver) {
		this.driver = driver;
	}
	public void printHeaders() {
		WebElement table = driver.findElement(By.xpath("//table[@class='table table-striped']"));
		List<WebElement> headers = table.findElements(By.tagName("th"));
		System.out.println("Table Headers:");
		for(WebElement header:headers) {
			System.out.println(header.getText() + "\t");
		}
	}
	public void printtableValues() {
		WebElement table = driver.findElement(By.xpath("//table[@class='table table-striped']"));
		System.out.println("Table Values:");
		List<WebElement> rows = table.findElements(By.tagName("tr"));
		for(int i=0; i<rows.size(); i++) {
			List<WebElement> cols = rows.get(i).findElements(By.tagName("td"));
			for(WebElement col:cols) {
				System.out.println(col.getText() + "\t");
			}	
		}
	}
	public void printtablespecificValues() {
		WebElement table = driver.findElement(By.xpath("//table[@class='table table-striped']"));
		List<WebElement> rows = table.findElements(By.tagName("tr"));
		 if (rows.size() > 0) {
		        List<WebElement> cols = rows.get(0).findElements(By.tagName("td"));
		       // Check if the first column contains the text "Chrome"
		        if (cols.size() > 0 && cols.get(0).getText().equalsIgnoreCase("Chrome")) {
		            System.out.println("Found " + cols.get(0).getText());
		        } else {
		            System.out.println("Chrome not found");
		        }
		 }
	}
}

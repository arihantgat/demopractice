package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class FileUploadPage {

		private WebDriver driver;
		private By choosefileButton = By.xpath("//input[@type='file']");
		private By uploadButton = By.xpath("//button[@id='fileSubmit']");
		private By confirmatiommessage = By.xpath("//div[@id='uploaded-files']");
		private By erromessage = By.xpath("//div[@id='flash']");
		
		public FileUploadPage(WebDriver driver) {
			this.driver = driver;
		}
		
		public void selectfile() {
			driver.findElement(choosefileButton).sendKeys("C:\\Users\\Ragnar\\Downloads\\Notes.pdf");
		}
		
		public void clickuploadbutton() {
			driver.findElement(uploadButton).click();
		}
		
		public void largefile() {
			driver.findElement(choosefileButton).sendKeys("C:\\Users\\Ragnar\\Downloads\\Git.pdf");
		}
		
		public void uploadfile() {
			selectfile();
			clickuploadbutton();
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
			WebElement confirmationmsg = driver.findElement(confirmatiommessage);
			wait.until(ExpectedConditions.visibilityOfElementLocated(confirmatiommessage));
		    String actualmsg = driver.findElement(By.xpath("//div//h1")).getText();
		    String expectedmsg = "File Uploaded!";
			Assert.assertEquals(actualmsg, expectedmsg);
			System.out.println(confirmationmsg.getText() + " File uploaded successfully");
		}
		
		public void uploadlargerfile() {
			largefile();
			String actualerror = driver.findElement(erromessage).getText();
			String expectederror = "File too large, please select a file less than 500KB";
			Assert.assertEquals(actualerror, expectederror);
			System.out.println("Following error encountered:" + "\n" + actualerror);
		}
}


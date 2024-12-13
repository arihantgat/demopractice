package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class ForgotPasswordPage {

	
		private WebDriver driver;
		
		private By emailField  = By.xpath("//input[@type='email']");
		
		public ForgotPasswordPage(WebDriver driver) {
			this.driver = driver;
		}
		
		public void entervalidemail(String email) {
			driver.findElement(emailField).sendKeys("arihantgat@gmail.com");
		}
		public void enterinvalidemail(String email){
			driver.findElement(emailField).sendKeys("arihantgat");
		}
		public void clickretrivepasswordButton() {
			JavascriptExecutor js = (JavascriptExecutor) driver;
	        WebElement retrivepasswordButton = driver.findElement(By.xpath("//button[@type='submit']"));
	        js.executeScript("arguments[0].click();", retrivepasswordButton);
		}
		public void retrivepasswordwithvalidemail(String email) throws InterruptedException{
			entervalidemail(email);
			clickretrivepasswordButton();
			Thread.sleep(1500);
			String actualText = driver.findElement(By.xpath("//div[@id='confirmation-alert']")).getText();
			String expectedText = "An e-mail has been sent to you which explains how to reset your password.";
			Assert.assertEquals(actualText, expectedText);
			System.out.println(actualText);
			
		}
		public void retrivepasswordwithinvalidemail(String email) throws InterruptedException{
			enterinvalidemail(email);
			clickretrivepasswordButton();
			Thread.sleep(1500);
			String actualText = driver.findElement(By.xpath("//div[@class='ms-1 invalid-feedback']")).getText();
			String expectedText = "Please enter a valid email address.";
			Assert.assertEquals(actualText, expectedText);
		}
}



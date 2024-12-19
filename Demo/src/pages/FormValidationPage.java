package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class FormValidationPage {

		private WebDriver driver;
		private By nameField = By.xpath("//input[@type='text']");
		private By phoneField = By.xpath("//input[@type='tel']");
		private By dateField = By.xpath("//input[@type='date']");
		private By paymentmethod = By.xpath("//select[@id='validationCustom04']");
		private By regsterbutton = By.xpath("//button[@class='btn btn-primary']");
		
		public FormValidationPage(WebDriver driver) {
			this.driver = driver;
		}
		
		public void enterusername(String username) {
			driver.findElement(nameField).clear();
			driver.findElement(nameField).sendKeys("Arihant");
		}
		
		public void enterphonumber(String phonenumber) {
			driver.findElement(phoneField).sendKeys("866-8588290");
		}
		
		public void enterdate(String date) {
			driver.findElement(dateField).sendKeys("19122024");
		}
		
		public void selectpaymentmethod() {
			WebElement paymentmethoddropdown = driver.findElement(paymentmethod);
			Select select = new Select(paymentmethoddropdown);
			select.selectByValue("cashondelivery");
		}
		public void clickregisterbutton() {
			driver.findElement(regsterbutton).click();
		}
		
		public void fillform(String username, String phonenumber, String date) {
			enterusername(username);
			enterphonumber(phonenumber);
			enterdate(date);
			selectpaymentmethod();
			clickregisterbutton();
			String actualText = driver.findElement(By.xpath("//div[@class='alert alert-info']")).getText();
			String expectedText = "Thank you for validating your ticket";
			Assert.assertEquals(actualText, expectedText);
			System.out.println("Form submitted successfully");
		}
}

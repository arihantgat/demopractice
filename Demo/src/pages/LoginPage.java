
package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class LoginPage {
	private WebDriver driver;
	
	private By usernameField  = By.xpath("//input[@name='username']");
	private By passwordField = By.xpath("//input[@name='password']");
	private By logoutButton = By.xpath("//a[@class='button secondary radius btn btn-danger']");
	
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		}
	public void entervalidusername(String username) {
		driver.findElement(usernameField).sendKeys("practice");
	}
	public void entervalidpassword(String password) {
		driver.findElement(passwordField).sendKeys("SuperSecretPassword!");
	}
	public void enterinvalidusername(String username) {
		driver.findElement(usernameField).sendKeys("practic");
	}
	public void enterinvalidpassword(String password) {
		driver.findElement(passwordField).sendKeys("SuperSecretPassword");
	}
	public void clickloginbutton() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
        WebElement loginButton = driver.findElement(By.xpath("//button[@class='btn btn-bg btn-primary d-block w-100']"));
        js.executeScript("arguments[0].click();", loginButton);
	}
	public void clicklogoutbutton() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
        WebElement logoutButton = driver.findElement(By.xpath("//a[@class='button secondary radius btn btn-danger']"));
        js.executeScript("arguments[0].click();", logoutButton);
	}
	public void loginValidCredentials(String username, String password) throws InterruptedException {
		entervalidusername(username);
		entervalidpassword(password);
		Thread.sleep(1500);
		clickloginbutton();
		Assert.assertEquals(driver.getCurrentUrl(), "https://practice.expandtesting.com/secure");
		clicklogoutbutton();
		Thread.sleep(2000);
	}
	public void loginInvalidCredentials(String username, String password) throws InterruptedException {
		enterinvalidusername(username);
		enterinvalidpassword(password);
		Thread.sleep(1500);
		clickloginbutton();
	}
	public boolean isloginsuccessful() {
		return driver.getCurrentUrl().equals("https://practice.expandtesting.com/secure");
	}




}

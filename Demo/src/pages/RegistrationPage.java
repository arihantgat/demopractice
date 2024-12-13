package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class RegistrationPage {
	private WebDriver driver;
	private By usernameField = By.xpath("//input[@name='username']");
	private By passwordField = By.xpath("//input[@name='password']");
	private By confirmpasswordField = By.xpath("//input[@name='confirmPassword']");
	private By registerbutton = By.xpath("//button[@type='submit']");
	
	public RegistrationPage(WebDriver driver) {
		this.driver = driver;
	}
	public void entervalidusername(String username) {
		driver.findElement(usernameField).sendKeys("JackM");
	}
	public void enterinvalidusername(String username) {
		driver.findElement(usernameField).sendKeys("A");
	}
	public void entervalidpassword(String username) {
		driver.findElement(passwordField).sendKeys("Aru@9511");
	}
	public void enterinvalidpassword(String username) {
		driver.findElement(passwordField).sendKeys("A");
	}
	public void entervalidconfirmpassword(String username) {
		driver.findElement(confirmpasswordField).sendKeys("Aru@9511");
	}
	public void enterinvalidconfirmpassword(String username) {
		driver.findElement(confirmpasswordField).sendKeys("A");
	}
	public void clickregisterbutton() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement RegisterButton = driver.findElement(registerbutton);
		js.executeScript("arguments[0].click();", RegisterButton);
	}
	public void registerwithvalidcredentials(String username, String password, String confirmpassword) throws InterruptedException {
		entervalidusername(username);
		//Thread.sleep(1500);
		entervalidpassword(password);
		entervalidconfirmpassword(confirmpassword);
		clickregisterbutton();	
		String actualMessage = driver.findElement(By.xpath("//div[@id='flash']")).getText();
		String expectedMessage = "Successfully registered, you can log in now.";
		Assert.assertEquals(actualMessage, expectedMessage);
	}
	public void registerwithinvalidcredentials(String username, String password, String confirmpassword) {
		enterinvalidusername(username);
		enterinvalidpassword(password);
		enterinvalidconfirmpassword(confirmpassword);
		clickregisterbutton();		
		String actualMessage = driver.findElement(By.xpath("//div[@id='flash']")).getText();
		String expectedMessage = "Username must be at least 3 characters long.";
		Assert.assertEquals(actualMessage, expectedMessage);
	}
}

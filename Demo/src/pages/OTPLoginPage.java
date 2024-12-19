package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class OTPLoginPage {
	
	private WebDriver driver;
	private By usernameField = By.xpath("//input[@type='email']");
	private By sendotpButton = By.xpath("//button[@id='btn-send-otp']");
	private By enterOTP = By.xpath("//input[@type='number']");
	private By verifyotpButton = By.xpath("//button[@id='btn-send-verify']");
	
	public OTPLoginPage(WebDriver driver) {
		this.driver = driver;
	}
	public void entervalidusername(String username) {
		driver.findElement(usernameField).sendKeys("practice@expandtesting.com");
	}
	public void enterinvalidusername(String username) {
		driver.findElement(usernameField).sendKeys("arihant");
	}
	public void clicksendotpbutton() {
		driver.findElement(sendotpButton).click();
	}
	public void entervalidotp(String otp) {
		driver.findElement(enterOTP).sendKeys("214365");
	}
	public void clickverifyotpbutton() {
		driver.findElement(verifyotpButton).click();
	}
	public void enterinvalidotp(String otp) {
		driver.findElement(enterOTP).sendKeys("2145");
	}
	public void loginValidUsername(String username, String otp) throws InterruptedException {
		entervalidusername(username);
		Thread.sleep(1500);
		clicksendotpbutton();
		Thread.sleep(1500);
		entervalidotp(otp);
		Thread.sleep(1500);
		clickverifyotpbutton();
		Assert.assertEquals(driver.getCurrentUrl(), "https://practice.expandtesting.com/secure");
	}
	public void loginInvalidUsername(String username) throws InterruptedException {
		enterinvalidusername(username);
		Thread.sleep(1500);
		clicksendotpbutton();
		Thread.sleep(1500);
		Assert.assertEquals(driver.findElement(By.xpath("//div[@class='invalid-feedback']")).getText(), "Please enter a valid email address.");
		System.out.println("Enter valid user email");
	}
	public void loginInvalidOTP(String username, String otp) throws InterruptedException {
		entervalidusername(username);
		Thread.sleep(1500);
		clicksendotpbutton();
		Thread.sleep(1500);
		enterinvalidotp(otp);
		Thread.sleep(1500);
		clickverifyotpbutton();
		Assert.assertEquals(driver.findElement(By.xpath("//p[@id='otp-message']")).getText(), "The provided OTP code is incorrect. Please check your code and try again.");
		System.out.println("OTP entered is not valid");
	}
}

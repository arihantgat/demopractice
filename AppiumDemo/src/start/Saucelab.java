package start;

import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.remote.MobileCapabilityType;

public class Saucelab {

	public static void main(String[] args) {
		try{
	          AppiumDriver<MobileElement> appiumDriver;

	          DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
	          desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
	          desiredCapabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
	          desiredCapabilities.setCapability(MobileCapabilityType.UDID, "ZD2228NGJY");
	          desiredCapabilities.setCapability("appPackage", "com.saucelabs.mydemoapp.rn");
	          desiredCapabilities.setCapability("appActivity", "com.saucelabs.mydemoapp.rn.MainActivity");

	          URL appiumServer = new URL("http://localhost:4723/");
	          appiumDriver = new AppiumDriver<MobileElement>(appiumServer, desiredCapabilities);
	          appiumDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	          appiumDriver.findElementByClassName("android.widget.ImageView").click();
	          appiumDriver.findElementByAccessibilityId("menu item log in").click();
	          appiumDriver.findElementByAccessibilityId("Username input field").sendKeys("bob@example.com");
	          appiumDriver.findElementByAccessibilityId("Password input field").sendKeys("10203040");
	          appiumDriver.findElementByAccessibilityId("Login button").click();
	          appiumDriver.findElementByXPath("//android.widget.TextView[@content-desc=\"store item text\" and @text=\"Sauce Labs Backpack\"]").click();
	          appiumDriver.findElementByXPath("//android.widget.TextView[@text=\"Add To Cart\"]").click();
	          appiumDriver.findElementByXPath("//android.view.ViewGroup[@content-desc=\"cart badge\"]/android.widget.ImageView").click();
	          appiumDriver.findElementByXPath("//android.widget.TextView[@text=\"Proceed To Checkout\"]").click();
	          appiumDriver.findElementByAccessibilityId("Full Name* input field").sendKeys("Arihant");
	          appiumDriver.findElementByAccessibilityId("Address Line 1* input field").sendKeys("Yashwant Nagar");
	          appiumDriver.findElementByAccessibilityId("City* input field").sendKeys("Hupari");
	          appiumDriver.findElementByAccessibilityId("Zip Code* input field").sendKeys("416203");
	          appiumDriver.findElementByAccessibilityId("Country* input field").sendKeys("India");
	          appiumDriver.findElementByXPath("//android.widget.TextView[@text=\"To Payment\"]").click();
	          Thread.sleep(2000);
	          appiumDriver.findElementByAccessibilityId("Full Name* input field").sendKeys("Arihant Gat");
	          appiumDriver.findElementByAccessibilityId("Card Number* input field").sendKeys("415263257845963");
	          appiumDriver.findElementByAccessibilityId("Expiration Date* input field").sendKeys("0329");
	          appiumDriver.findElementByAccessibilityId("Security Code* input field").sendKeys("526");
	          appiumDriver.findElementByAccessibilityId("Review Order button").click();
	          appiumDriver.findElementByXPath("//android.widget.TextView[@text=\"Place Order\"]").click();
	          Thread.sleep(2000);
	          String actualmsg = appiumDriver.findElementByXPath("//android.widget.TextView[@text='Checkout Complete']").getText();
	          String expectedmsg = "Checkout Complete";
	          if(actualmsg.equals(expectedmsg)) {
	        	  System.out.println("Order placed successfully");
	          }else {
	        	  System.out.println("Order placement failed");
	          }	          
	      }catch (Exception e){
	        System.out.println("Error");
	        }
	}

}

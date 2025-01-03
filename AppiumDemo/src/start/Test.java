package start;

import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.remote.MobileCapabilityType;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try{
	          AppiumDriver<MobileElement> appiumDriver;

	          DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
	          desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
	          desiredCapabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
	          desiredCapabilities.setCapability(MobileCapabilityType.UDID, "emulator-5554");
	          desiredCapabilities.setCapability("appPackage", "com.wdiodemoapp");
	          desiredCapabilities.setCapability("appActivity", "com.wdiodemoapp.MainActivity");

	          URL appiumServer = new URL("http://localhost:4723/wd/hub");
	          appiumDriver = new AppiumDriver<MobileElement>(appiumServer, desiredCapabilities);
	          appiumDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	          MobileElement loginLabel = appiumDriver.findElementByAccessibilityId("Login");
	          loginLabel.click();
	          appiumDriver.findElementByAccessibilityId("input-email").sendKeys("arihantgat@gmail.com");
	          appiumDriver.findElementByAccessibilityId("input-password").sendKeys("Aru@9511");
	          appiumDriver.findElementByClassName("android.view.ViewGroup").click();
	          System.out.println("Logged in");
	      }catch (Exception e){
	        System.out.println("Error");
	        }
	}

}

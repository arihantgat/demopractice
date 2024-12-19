package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pages.FileUploadPage;

public class FileUploadTest {

	private WebDriver driver;
	private FileUploadPage fileuploadpage;
	
	@BeforeClass
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Ragnar\\Documents\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
		driver = new ChromeDriver();
		fileuploadpage = new FileUploadPage(driver);
		driver.manage().window().maximize();
		driver.get("https://practice.expandtesting.com/upload");
	}
	
//	@Test
//	public void uploadafile() {
//		fileuploadpage.uploadfile();
//	}
	
	@Test
	public void largefileupload() {
		fileuploadpage.uploadlargerfile();
	}
	
	@AfterClass
	public void tearDown() {
		if(driver != null) {
			driver.quit();
		}
	}
}

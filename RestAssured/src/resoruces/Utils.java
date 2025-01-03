package resoruces;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Properties;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
//import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

public class Utils {
	RequestSpecification req;
	public RequestSpecification requestSpecifications() throws IOException {
		PrintStream log = new PrintStream(new FileOutputStream("logging.txt"));
		req = new RequestSpecBuilder().setBaseUri(getGlobalvalues("baseURL"))
				   .addQueryParam("key", "qaclick123")
				   .addFilter(RequestLoggingFilter.logRequestTo(log))
				   //.addFilter(ResponseLoggingFilter.logResponseTo(log))
				   .setContentType(ContentType.JSON)
				   .build();
		return req;
	}
	
	public String getGlobalvalues(String key) throws IOException {
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream("C:\\Users\\Ragnar\\Documents\\Main\\RestAssured\\src\\resoruces\\global.properties");
		prop.load(fis);
		return prop.getProperty(key);
	}
	
}

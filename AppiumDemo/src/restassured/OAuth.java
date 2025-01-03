package restassured;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import pojo.Api_Courses;
import pojo.GetCourses;
import pojo.WebAutomation_Courses;

import static io.restassured.RestAssured.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.testng.Assert;


public class OAuth {
	public static void main(String[] args) {
		String [] courseTitles = {"Selenium Webdriver Java", "Cypress", "Protractor"};
		String response = given().formParam("client_id", "692183103107-p0m7ent2hk7suguv4vq22hjcfhcr43pj.apps.googleusercontent.com")
			   .formParam("client_secret", "erZOWM9g3UtwNRj340YYaK_W").formParam("grant_type", "client_credentials").formParam("scope", "trust")
			   .when().log().all()
			   .post("https://rahulshettyacademy.com/oauthapi/oauth2/resourceOwner/token")
			   .then().assertThat().statusCode(200).extract().response().asString();
		JsonPath js = new JsonPath(response);
		String AccessToken = js.getString("access_token");
		System.out.println(AccessToken);
		
		GetCourses response1 = given().queryParam("access_token", AccessToken)
		.when().log().all()
		.get("https://rahulshettyacademy.com/oauthapi/getCourseDetails")
		.as(GetCourses.class);
		System.out.println(response1.getInstructor());
		System.out.println(response1.getLinkedIn());
		System.out.println(response1.getCourses().getApi().get(1).getCourseTitle());
		
		List<Api_Courses> apiCourses = response1.getCourses().getApi();
		for(int i=0; i<apiCourses.size(); i++) {
			if(apiCourses.get(i).getCourseTitle().equalsIgnoreCase("SoapUI Webservices testing")) {
				System.out.println("Price for " +apiCourses.get(i).getCourseTitle() + " is: " +apiCourses.get(i).getPrice());
			}
		}
		ArrayList<String> actuallist = new ArrayList();
		List<WebAutomation_Courses> webautomationCourses = response1.getCourses().getWebAutomation();
		for(int j=0; j<webautomationCourses.size(); j++) {
			System.out.println(webautomationCourses.get(j).getCourseTitle());
			actuallist.add(webautomationCourses.get(j).getCourseTitle());
		}
		List<String> expectedlist = Arrays.asList(courseTitles);
		Assert.assertTrue(actuallist.equals(expectedlist));
		System.out.println("Passed");
	}
}

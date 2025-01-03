package restassured;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.*;

import java.io.File;

import files.payload;

public class BugTest {
	public static void main(String[]args) {
			RestAssured.baseURI = "https://arihantgat-jira.atlassian.net";
			String response = given().header("Content-Type", "application/json")
								     .header("X-Atlassian-Token", "no-check")
									 .header("Authorization", "Basic YXJpaGFudGdhdEBnbWFpbC5jb206QVRBVFQzeEZmR0YwdmFlTGgtbzVnZkVvLXBjZTBnQ2p4UWVMUjRnOUxuT3VvVTdQdTRKLS1fQkYxUE5UcmdTRy1EbEFvMlB6VWpDWXJaYlZuVG5YZHdjZ0tyOUctNmdza1lmcUdRRkp6dUFxRG9RbmVfekNQNzFtWjYxX3EzQld3dHprQ0prTHlaS0dlT3BJN3JMdksyYWFJdkVNc05nM3h6UGlBUlBhV3dkM3AzTWp6M3daekhzPTE5NTQ4OEY5")
			.body(payload.CreateIssue()).log().all()
			.when().post("rest/api/3/issue").then().log().all().assertThat().statusCode(201).extract().response().asString();
			JsonPath js = new JsonPath(response);
			String issueid = js.get("id");
			System.out.println(issueid);
			
			given().pathParam("key", issueid)
				   .header("X-Atlassian-Token", "no-check")
			       .header("Authorization", "Basic YXJpaGFudGdhdEBnbWFpbC5jb206QVRBVFQzeEZmR0YwdmFlTGgtbzVnZkVvLXBjZTBnQ2p4UWVMUjRnOUxuT3VvVTdQdTRKLS1fQkYxUE5UcmdTRy1EbEFvMlB6VWpDWXJaYlZuVG5YZHdjZ0tyOUctNmdza1lmcUdRRkp6dUFxRG9RbmVfekNQNzFtWjYxX3EzQld3dHprQ0prTHlaS0dlT3BJN3JMdksyYWFJdkVNc05nM3h6UGlBUlBhV3dkM3AzTWp6M3daekhzPTE5NTQ4OEY5")
			       .multiPart("file", new File("C:\\Users\\Ragnar\\Downloads\\demo.png")).log().all()
			       .post("rest/api/3/issue/{key}/attachments").then().log().all().assertThat().statusCode(200);
		}
}

package stepDefinations;

import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;
import java.io.IOException;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import resoruces.TestDataBuild;
import resoruces.Utils;

public class StepDefinations extends Utils{
	TestDataBuild data = new TestDataBuild() ;
	RequestSpecification res;
	ResponseSpecification resb;
	Response response;
	
	@Given("Add Place Payload {string} {string} {string}")
	public void add_place_payload(String name, String language, String address) throws IOException {
		res = given().spec(requestSpecifications()).body(data.addPlacePayload(name, language, address));
	}
	@When("User calls {string} with Post http request")
	public void user_calls_with_post_http_request(String string) {
		resb = new ResponseSpecBuilder().expectContentType(ContentType.JSON).build();
		response = res.when().post("/maps/api/place/add/json")
				      .then().spec(resb).extract().response();
	}
	@Then("the API call got success with status code {int}")
	public void the_api_call_got_success_with_status_code(Integer int1) {
	    assertEquals(response.getStatusCode(),200);
	}
	@Then("{string} in response body is {string}")
	public void in_response_body_is(String keyValue, String expectedValue) {
		String stringresponse = response.asString();
		JsonPath js = new JsonPath(stringresponse);
		assertEquals(js.get(keyValue).toString(), expectedValue);
		
	}
}

package restassured;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import pojo.AddPlace;
import pojo.location_child;

import static io.restassured.RestAssured.*;

import java.util.ArrayList;
import java.util.List;

public class SpecBuilderTest {

	public static void main(String[] args) {
		RequestSpecification req = new RequestSpecBuilder().setBaseUri("https://rahulshettyacademy.com")
														   .addQueryParam("key", "qaclick123")
														   .setContentType(ContentType.JSON).build();
		ResponseSpecification resb = new ResponseSpecBuilder().expectStatusCode(200).expectContentType(ContentType.JSON).build();
		
		//body parameters
		AddPlace place = new AddPlace();
		place.setAccuracy(50);
		place.setAddress("Plot No 133A, Yashwant  Nagar, Hupari-416203");
		place.setLanguage("Marathi");
		place.setName("Yash Tara");
		place.setPhone_number("(+91) 866 858 8290");
		place.setWebsite("www.arihantgat.com");
		List<String> myList = new ArrayList<String>();
		myList.add("BSNL Office");
		myList.add("Mangal Karyalay");
		place.setTypes(myList);
		location_child l = new location_child();
		l.setLat(-38.383494);
		l.setLng(33.427362);
		place.setLocation(l);
		
		RequestSpecification res = given().spec(req).body(place);
		
		Response response = res.when().post("/maps/api/place/add/json")
									  .then().spec(resb).statusCode(200).extract().response();
		String stringresponse = response.asString();
		System.out.println(stringresponse);
		JsonPath js = new JsonPath(stringresponse);
		String placeid = js.getString("place_id");
		System.out.println("place_id: "+placeid);
	}

}

package restassured;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import pojo.AddPlace;
import pojo.location_child;

import static io.restassured.RestAssured.*;

import java.util.ArrayList;
import java.util.List;

public class SerializationTest {

	public static void main(String[] args) {
		RestAssured.baseURI = "https://rahulshettyacademy.com";
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
		String res = given().queryParam("key", "qaclick123")
			   .body(place)
			   .when().post("/maps/api/place/add/json")
			   .then().assertThat().statusCode(200).extract().response().asString();
		System.out.println(res);
		JsonPath js = new JsonPath(res);
		String placeid = js.getString("place_id");
		System.out.println("place_id: "+placeid);
	}

}

package restassured;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import org.testng.Assert;

import files.payload;

public class Basics {

	public static void main(String[] args) {
		// Add place
		RestAssured.baseURI = "https://rahulshettyacademy.com";
		String response = given().log().all().queryParam("key", "qaclick123").header("Content-Type", "application/json")
				.body(payload.AddPlace()).when().post("maps/api/place/add/json").then().assertThat().statusCode(200)
				.body("scope", equalTo("APP")).header("server", "Apache/2.4.52 (Ubuntu)").extract().response()
				.asString();
				System.out.println(response);
				JsonPath js = new JsonPath(response);
				String placeID = js.getString("place_id");
				System.out.println(placeID);
				
		//Update place
				String newAddress = "133 A Hupari";
				given().log().all().queryParam("key", "qaclick123").header("Content-Type", "application/json")
				.body("{\r\n"
						+ "\"place_id\":\""+placeID+"\",\r\n"
						+ "\"address\":\""+newAddress+"\",\r\n"
						+ "\"key\":\"qaclick123\"\r\n"
						+ "}\r\n"
						+ "").when().put("maps/api/place/update/json")
				.then().log().all().assertThat().statusCode(200).body("msg", equalTo("Address successfully updated"));
				
		//Get updated place
				
				String getnewaddress = given().log().all().queryParam("key", "qaclick123").queryParam("place_id", placeID).header("Content-Type", "application/json")
				.when().get("maps/api/place/get/json")
				.then().log().all().assertThat().statusCode(200).extract().response().asString();
				JsonPath js1 = new JsonPath(getnewaddress);
				String actualAddress = js1.getString("address");
				System.out.println(actualAddress);
				Assert.assertEquals(actualAddress, newAddress);
				System.out.println("Address updated successfully");
	}

}

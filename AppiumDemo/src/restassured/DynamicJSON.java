package restassured;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import files.payload;

import static io.restassured.RestAssured.*;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

public class DynamicJSON {

		@Test(priority = 1, dataProvider = "booksdata")
		public void addBooks(String isbn, String aisle) {
			RestAssured.baseURI = "http://216.10.245.166";
			String response = given().log().all().header("Content-Type", "application/json")
			.body(payload.AddBooks(isbn, aisle)).when()
			.post("Library/Addbook.php")
			.then().log().all().assertThat().statusCode(200).extract().response().asString();
			JsonPath js = new JsonPath(response);
			String id = js.getString("ID");
			System.out.println(id);
		}
		
		@Test(priority = 2, dataProvider = "deletebooksdata")
		public void deleteBooks(String id) {
			RestAssured.baseURI = "http://216.10.245.166";
			String response = given().header("Content-Type", "application/json")
			.body(payload.DeleteBooks(id)).when()
			.post("Library/DeleteBook.php")
			.then().log().all().statusCode(200).extract().response().asString();
			JsonPath js1 = new JsonPath(response);
			String msg = js1.getString("msg");
			System.out.println(msg);
			
		}
		
		@DataProvider(name = "booksdata")
		public Object[][] getData() {
			return new Object[][] {{"SERIAL", "001"}, {"SERIAL", "002"}, {"SERIAL", "003"}};
		}
		
		@DataProvider(name = "deletebooksdata")
		public Object[] getdeleteData() {
			return new Object[] {"SERIAL001", "SERIAL002", "SERIAL003"};
		}
}

package ecommerce_rest;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import static io.restassured.RestAssured.*;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;
import ecommerce_pojo.CreateProductResponse;
import ecommerce_pojo.LoginRequest;
import ecommerce_pojo.LoginResponse;
import ecommerce_pojo.PlaceOrderRequest;
import ecommerce_pojo.PlaceOrder_OrderDetailsRequest;

public class EcommerecAPITest {

	public static void main(String[] args) {
		//Login to website
		RequestSpecification req = new RequestSpecBuilder().setBaseUri("https://rahulshettyacademy.com")
														   .setContentType(ContentType.JSON).build();
		LoginRequest loginRequest = new LoginRequest();
		loginRequest.setUserEmail("arihantgat@gmail.com");
		loginRequest.setUserPassword("Aru@9511");
		RequestSpecification loginreq = given().log().all().spec(req).body(loginRequest);
		LoginResponse loginResponse = loginreq.when().post("/api/ecom/auth/login")
											  .then().log().all().assertThat().statusCode(200).extract().response().as(LoginResponse.class);
		String token = loginResponse.getToken();
		String userid = loginResponse.getUserId();
		
		//Create a product
		RequestSpecification createProduct = new RequestSpecBuilder().setBaseUri("https://rahulshettyacademy.com")
																     .addHeader("Authorization", token)
																     .build();
		RequestSpecification createproductreq = given().spec(createProduct).param("productName", "Hoodie")
														.param("productAddedBy", userid).param("productCategory", "Fashion").param("productSubCategory", "Top wear")
														.param("productPrice", "1999").param("productDescription", "H&M").param("productFor", "Men").multiPart("productImage", new File("C:\\Users\\Ragnar\\Downloads\\hmgoepprod.jpeg"));
		CreateProductResponse createproductResponse = createproductreq.when().post("/api/ecom/product/add-product")
																	  .then().log().all().assertThat().statusCode(201).extract().response().as(CreateProductResponse.class);
		String productid = createproductResponse.getProductId();	
		
		//Place order for created product
		RequestSpecification placeOrder = new RequestSpecBuilder().setBaseUri("https://rahulshettyacademy.com")
			     													 .addHeader("Authorization", token)
			     													 .setContentType(ContentType.JSON)
			     													 .build();
		PlaceOrder_OrderDetailsRequest orderdetailsrequest = new PlaceOrder_OrderDetailsRequest();
		orderdetailsrequest.setCountry("India");
		orderdetailsrequest.setProductOrderedId(productid);
		List<PlaceOrder_OrderDetailsRequest> orderDetails = new ArrayList<PlaceOrder_OrderDetailsRequest>();
		orderDetails.add(orderdetailsrequest);
		PlaceOrderRequest placeorderrequest = new PlaceOrderRequest();
		placeorderrequest.setOrders(orderDetails);
		
		RequestSpecification placeorderreq = given().spec(placeOrder).body(placeorderrequest);
		String placeorderresponse = placeorderreq.when().post("/api/ecom/order/create-order")
												 .then().log().all().assertThat().statusCode(201).extract().response().asString();
		 JSONObject jsonObject = new JSONObject(placeorderresponse);
		 JSONArray ordersArray = jsonObject.getJSONArray("orders");
		  String orderId = ordersArray.getString(0);
		  System.out.println(orderId);
		
		//Get order details
		RequestSpecification GetOrderdetailsbase = new RequestSpecBuilder().setBaseUri("https://rahulshettyacademy.com")
																		   .addHeader("Authorization", token).addQueryParam("id", orderId).build();
		RequestSpecification GetOrderdetails = given().spec(GetOrderdetailsbase);
		String GetOrderdetailsResponse = GetOrderdetails.when().get("/api/ecom/order/get-orders-details")
														.then().log().all().assertThat().statusCode(200).extract().response().asString();
		System.out.println(GetOrderdetailsResponse);
		
		//Delete product
		RequestSpecification deletProduct = new RequestSpecBuilder().setBaseUri("https://rahulshettyacademy.com")
																	.addHeader("Authorization", token)
																	.build();
		RequestSpecification deletProductreq = given().spec(deletProduct).pathParam("productId", productid);
		String deletProductres = deletProductreq.when().delete("/api/ecom/product/delete-product/{productId}")
												.then().log().all().assertThat().statusCode(200).extract().response().asString();
		System.out.println(deletProductres);
	}

}

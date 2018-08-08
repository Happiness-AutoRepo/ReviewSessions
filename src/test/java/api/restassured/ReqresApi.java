package api.restassured;

import org.junit.Assert;
import org.junit.Test;

import io.restassured.http.ContentType;
import io.restassured.http.Header;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

import java.util.Map;

public class ReqresApi {
	
	/**
	 *  Send a get request to https://reqres.in/api/users
	 *  including query param -> page=2
	 *  accept type is json
	 *  verify status code 200, verify response body
	 */
	
	@Test
	public void getUsersTest() {
		
		given().accept(ContentType.JSON)
		.and().param("page", 2)
		.when().get("https://reqres.in/api/users")
		.then().assertThat().statusCode(200);
		
		Response response = given().accept(ContentType.JSON)
		.and().param("page", 2)
		.when().get("https://reqres.in/api/users");
		
		System.out.println(response.getContentType());
		System.out.println(response.getStatusLine());
		System.out.println(response.headers());
		System.out.println(response.prettyPeek());
		
		//add assertions for parts of response
		Assert.assertEquals(200, response.getStatusCode());
		Assert.assertTrue(response.contentType().contains("application/json"));
		
		Header header = new Header("X-Powered-By", "Express");
		Assert.assertTrue(response.getHeaders().asList().contains(header));
		
		JsonPath json = response.jsonPath();
		Assert.assertEquals(12, json.getInt("total"));
		Assert.assertEquals(4, json.getInt("data.id[0]"));
		
		//verify that Charles's id is 5
		Assert.assertEquals(5, json.getInt("data.find{it.first_name == 'Charles'}.id"));
		//verify that whoever has id=6, there name is Tracey 
		Assert.assertEquals("Tracey", json.getString("data.find{it.id == 6}.first_name"));
		Assert.assertEquals("Ramos", json.getString("data.find{it.id == 6}.last_name"));
		
		System.out.println(response.getHeaders().asList());
		
//		given().auth().preemptive().basic("UserName", "Password").when().get();  //authentication and preemptive auth using RestAssured
		
		Map jsonData = response.body().as(Map.class);                            // JSON as Map
		System.out.println(jsonData);											 // You can also represent JSON as Java Object and vice versa using ObjectMapper Class
		
	}
	

}

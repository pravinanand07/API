package org.temp;

import static io.restassured.RestAssured.*;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

public class TestApi {

	public static void main(String[] args) {

		RestAssured.baseURI = "https://petstore.swagger.io/v2";
		String response = given().header("Content-Type", "application/json").header("accept", "application/json")
				.body("{\r\n" + "  \"id\": 0,\r\n" + "  \"category\": {\r\n" + "    \"id\": 0,\r\n"
						+ "    \"name\": \"string\"\r\n" + "  },\r\n" + "  \"name\": \"doggie\",\r\n"
						+ "  \"photoUrls\": [\r\n" + "    \"string\"\r\n" + "  ],\r\n" + "  \"tags\": [\r\n"
						+ "    {\r\n" + "      \"id\": 0,\r\n" + "      \"name\": \"string\"\r\n" + "    }\r\n"
						+ "  ],\r\n" + "  \"status\": \"available\"\r\n" + "}")
				.when().post("pet").then().assertThat().statusCode(200).extract().response().asString();

		System.out.println(response);
		JsonPath path = new JsonPath(response);
		Object id = path.get("status");
		System.out.println(id);
	}

}

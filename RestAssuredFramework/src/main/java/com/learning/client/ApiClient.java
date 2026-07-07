package com.learning.client;

import com.learning.specifications.RequestSpecificationBuilder;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class ApiClient {

	public Response get(String endpoint) {

		return RestAssured

				.given()

				.spec(RequestSpecificationBuilder.getRequestSpecification())

				.when()

				.get(endpoint);

	}

	public Response post(String endpoint, Object body) {

		return RestAssured

				.given()

				.spec(RequestSpecificationBuilder.getRequestSpecification())

				.body(body)

				.when()

				.post(endpoint);

	}

	public Response post(String endpoint, Object body, String token) {

		return RestAssured

				.given()

				.spec(RequestSpecificationBuilder.getRequestSpecification())

				.header("Cookie", "token=" + token)

				.body(body)

				.post(endpoint);

	}

	public Response put(String endpoint, Object body) {

		return RestAssured

				.given()

				.spec(RequestSpecificationBuilder.getRequestSpecification())

				.body(body)

				.when()

				.put(endpoint);

	}
	
	public Response put(String endpoint, Object body, String token) {

		return RestAssured

				.given()

				.spec(RequestSpecificationBuilder.getRequestSpecification())
				
				.header("Cookie", "token=" + token)

				.body(body)
				
				.when()

				.put(endpoint);

	}

	public Response delete(String endpoint) {

		return RestAssured

				.given()

				.spec(RequestSpecificationBuilder.getRequestSpecification())

				.when()

				.delete(endpoint);

	}
	
	public Response delete(String endpoint, String token) {

		return RestAssured

				.given()

				.spec(RequestSpecificationBuilder.getRequestSpecification())
				
				.header("Cookie", "token=" + token)

				.when()

				.delete(endpoint);

	}

}
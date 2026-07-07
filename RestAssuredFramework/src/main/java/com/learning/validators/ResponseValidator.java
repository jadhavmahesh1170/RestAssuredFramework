package com.learning.validators;

import io.restassured.response.Response;

public class ResponseValidator {

	public static void verifyStatus(Response response, int status) {

		response.then().statusCode(status);

	}

}
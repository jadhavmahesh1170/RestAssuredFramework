package com.learning.utils;

import io.restassured.response.Response;

public class ResponseUtil {

	public static <T> T parse(Response response, Class<T> clazz) {

		return response.as(clazz);

	}

}
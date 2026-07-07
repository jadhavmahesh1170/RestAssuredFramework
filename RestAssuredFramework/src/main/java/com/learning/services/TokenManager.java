package com.learning.services;

public class TokenManager {

	private static String token;

	public static String getToken() {

		if (token == null) {

			token = new AuthService().generateToken();

		}

		return token;

	}

}
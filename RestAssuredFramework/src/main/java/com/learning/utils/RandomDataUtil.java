package com.learning.utils;

import net.datafaker.Faker;

public class RandomDataUtil {
	
	private static final Faker faker = new Faker();
	
	public static String getRandomFirstName() {
		return faker.name().firstName();
	}
	
	public static String getRandomLastName() {
		return faker.name().lastName();
	}
	
	public static String getRandomEmail() {
		return faker.internet().emailAddress();
	}
}

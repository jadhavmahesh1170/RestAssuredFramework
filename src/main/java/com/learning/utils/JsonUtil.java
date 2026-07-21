package com.learning.utils;

import java.io.IOException;
import java.io.InputStream;

import com.fasterxml.jackson.databind.ObjectMapper;

//This class is used to read JSON files and convert them into Java objects using Jackson ObjectMapper.
public class JsonUtil {

	private static final ObjectMapper mapper = new ObjectMapper();

	public static <T> T readJson(String file, Class<T> clazz) {

		try {

			InputStream is = JsonUtil.class.getClassLoader().getResourceAsStream(file);

			return mapper.readValue(is, clazz);

		}

		catch (IOException e) {

			throw new RuntimeException(e);

		}

	}

}
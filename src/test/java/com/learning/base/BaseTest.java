package com.learning.base;

import org.testng.annotations.BeforeSuite;

import io.restassured.RestAssured;

public class BaseTest {

    @BeforeSuite

    public void setup() {

        RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();

    }

}
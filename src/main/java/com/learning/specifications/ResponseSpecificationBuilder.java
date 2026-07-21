package com.learning.specifications;

import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.specification.ResponseSpecification;

public final class ResponseSpecificationBuilder {

    private ResponseSpecificationBuilder() {}

    public static ResponseSpecification successResponse() {

        return new ResponseSpecBuilder()

                .expectStatusCode(200)

                .build();

    }

}
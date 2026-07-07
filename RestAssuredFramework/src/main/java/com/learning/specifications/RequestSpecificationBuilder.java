package com.learning.specifications;

import com.learning.config.ConfigManager;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

public final class RequestSpecificationBuilder {

    private RequestSpecificationBuilder() {}

    private static RequestSpecification requestSpecification;

    public static RequestSpecification getRequestSpecification() {

        if(requestSpecification == null) {

            requestSpecification =
                    new RequestSpecBuilder()

                    .setBaseUri(ConfigManager.get("base.url"))

                    .setContentType(ContentType.JSON)
                    
                    .addFilter(new RequestLoggingFilter())
                    
                    .addFilter(new ResponseLoggingFilter())

                    .build();
           

        }

        return requestSpecification;

    }

}
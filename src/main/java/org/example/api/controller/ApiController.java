package org.example.api.controller;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.example.api.data.ApiData;
import org.example.utils.ApiConfig;

public class ApiController {

    private final ApiData data;

    public ApiController(ApiData data) {
        this.data = data;
    }

    public Response getUser() {
        Response response = RestAssured
                .given()
                .header("Content-type", "application/json")
                .header("x-api-key", data.getApiKey())
                .queryParam("page", data.getPage())
                .log().all()
                .get(ApiConfig.BASE_URL + "/users");
        response.getBody().prettyPrint();
        return response;
    }

    public Response postUser() {
        String bodyRequest = "{\n" +
                "    \"name\": \"" + data.getName() + "\",\n" +
                "    \"job\": \"" + data.getJob() + "\"\n" +
                "}";

//        String test = "{\n" +
//                "    \"name\": \"morpheus\",\n" +
//                "    \"job\": \"leader\"\n" +
//                "}";

        Response response = RestAssured
                .given()
                .header("Content-type", "application/json")
                .header("x-api-key", data.getApiKey())
                .log().all()
                .body(bodyRequest)
                .post(ApiConfig.BASE_URL + "/users");
        response.getBody().prettyPrint();
        return response;
    }
}

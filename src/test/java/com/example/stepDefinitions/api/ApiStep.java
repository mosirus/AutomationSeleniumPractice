package com.example.stepDefinitions.api;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.api.controller.ApiController;
import org.example.api.data.ApiData;
import org.json.JSONObject;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ApiStep {

    ApiData data = new ApiData();
    ApiController controller;

    @Given("[reqres] prepare set request header page to {int}")
    public void reqresPrepareSetRequestHeaderPageTo(int page) {
        data.setPage(page);
    }

    @Given("[reqres] prepare set request header x-api-key to {string}")
    public void reqresPrepareSetRequestHeaderXApiKeyTo(String apiKey) {
        data.setApiKey(apiKey);
    }

    @When("[reqres] send request get list users")
    public void reqresSendRequestGetListUsers() {
        controller = new ApiController(data);
        data.setListUser(controller.getUser());
    }

    @Then("[reqres] send request get list users must be {int}")
    public void reqresSendRequestGetListUsersMustBe(int expectedResponseCode) {
        Integer actualResponseCode = data.getListUser().statusCode();
        System.out.println("Actual Response Code is: " + actualResponseCode);
        assertThat("Response code is not expected ", actualResponseCode, equalTo(expectedResponseCode));
    }

    @When("[reqres] prepare set body request name to {string}")
    public void reqresPrepareSetBodyRequestNameTo(String name) {
        data.setName(name);
    }


    @And("[reqres] prepare set body request job to {string}")
    public void reqresPrepareSetBodyRequestJobTo(String job) {
        data.setJob(job);
    }

    @Then("[reqres] send request post users")
    public void reqresSendRequestPostUsers() {
        controller = new ApiController(data);
        data.setPostUser(controller.postUser());
    }

    @And("[reqres] send request post users response code must be {int}")
    public void reqresSendRequestPostUsersResponseCodeMustBe(int responseCodePost) {
        Integer actualRcPost = data.getPostUser().statusCode();
        System.out.println("Actual Response Code is: " + actualRcPost);
        assertThat("Response code is not expected ", actualRcPost, equalTo(responseCodePost));
    }

    @And("[reqres] send request post users response name must be {string}")
    public void reqresSendRequestPostUsersResponseNameMustBe(String responseName) {
        String responseBody = data.getPostUser().getBody().prettyPrint();
        JSONObject jsonObject = new JSONObject(responseBody);
        String actualName = jsonObject.getString("name");
        assertThat("Wrong response name", actualName, equalTo(responseName));
    }

    @And("[reres] send request post users response job must be {string}")
    public void reresSendRequestPostUsersResponseJobMustBe(String responseJob) {
        String responseBody = data.getPostUser().getBody().prettyPrint();
        JSONObject jsonObject = new JSONObject(responseBody);
        String actualJob = jsonObject.getString("job");
        assertThat("Wrong response name", actualJob, equalTo(responseJob));
    }

}

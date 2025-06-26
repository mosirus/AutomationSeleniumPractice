package com.example.stepDefinitions;

import io.cucumber.java.en.Given;
import org.example.drivers.DriverFactory;
import org.example.pages.LoginPage;

public class OpenWebsite {
    @Given("[user] opens website using the endpoint {string}")
    public void userOpensWebsiteUsingTheEndpoint(String url) {
        DriverFactory.getDriver().get(url);
    }

}

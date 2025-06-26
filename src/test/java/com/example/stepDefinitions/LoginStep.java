package com.example.stepDefinitions;
import io.cucumber.java.en.And;
import org.example.pages.LoginPage;
import io.cucumber.java.en.When;

public class LoginStep {
    private final LoginPage loginPage = new LoginPage();

    @When("[user] fill valid username with value {string}")
    public void userFillValidUsernameWithValueAdmin(String username) {
        loginPage.fillUserName(username);

    }

    @And("[user] fill valid password with value {string}")
    public void userFillValidPasswordWithValueAdmin(String password) {
        loginPage.fillPassword(password);
    }

    @And("[user] click button Login")
    public void userClickButtonLogin() {
        loginPage.clickLoginButton();
    }
}

package org.example.steps;

import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.app.data.UserData;
import org.example.app.pages.HeaderPage;
import org.example.app.pages.SignupPage;
import org.example.app.properties.PropertiesReader;
import org.hamcrest.MatcherAssert;
import org.springframework.beans.factory.annotation.Autowired;

import static org.example.app.properties.PropertiesReader.properties;
import static org.hamcrest.Matchers.equalTo;

public class SignupSteps {
    @Autowired
    SignupPage signupPage;

    @Autowired
    HeaderPage headerPage;

    @Autowired
    UserData userData;

    @Before
    public void background(){
        PropertiesReader.initializePropertyFile();
    }

    @Given("user sign up using username: {string} and password: {string}")
    public void userSignUpUsingUsernameAndPassword(String username, String password) {
        signupPage.openAt(properties.getProperty("demoblazeUrl"));
        headerPage.clickSignupButton();
        switch (username) {
            case "notExistingUsername":
                username = "username" + System.currentTimeMillis();
                break;
            case "existingUsername":
                username = properties.getProperty("existingUsername");
                break;
            case "blank":
                username = "";
                break;
            default:
                break;
        }
        switch (password) {
            case "notExistingPassword":
                password = "password" + System.currentTimeMillis();
                break;
            case "existingPassword":
                password = properties.getProperty("existingPassword");
                break;
            case "blank":
                password = "";
                break;
            default:
                break;
        }
        signupPage.fillUsername(username);
        signupPage.fillPassword(password);
    }

    @When("user click sign up button")
    public void userClickSignUpButton() {
        signupPage.submit();
    }
}

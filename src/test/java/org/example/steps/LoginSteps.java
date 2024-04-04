package org.example.steps;

import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import static org.assertj.core.api.Assertions.assertThat;
import static org.example.app.properties.PropertiesReader.properties;
import static org.hamcrest.Matchers.equalTo;

import org.example.app.pages.HeaderPage;
import org.example.app.pages.LoginPage;
import org.example.app.properties.PropertiesReader;
import org.hamcrest.MatcherAssert;
import org.springframework.beans.factory.annotation.Autowired;

public class LoginSteps {

    @Autowired
    LoginPage loginPage;

    @Autowired
    HeaderPage headerPage;

    @Before
    public void background(){
        PropertiesReader.initializePropertyFile();
    }

    @Given("user login using username: {string} and password: {string}")
    public void userLoginUsingUsernameAndPassword(String username, String password) {
        loginPage.openAt(properties.getProperty("demoblazeUrl"));
        headerPage.clickLoginButton();
        switch (username) {
            case "validUsername":
                username = properties.getProperty("validUsername");
                break;
            case "invalidUsername":
                username = properties.getProperty("invalidUsername");
                break;
            case "blank":
                username = "";
                break;
            default:
                break;
        }
        switch (password) {
            case "validPassword":
                password = properties.getProperty("validPassword");
                break;
            case "invalidPassword":
                password = properties.getProperty("invalidPassword");
                break;
            case "blank":
                password = "";
                break;
            default:
                break;
        }
        loginPage.fillUsername(username);
        loginPage.fillPassword(password);
    }

    @When("user click login button")
    public void userClickLoginButton() {
        loginPage.submit();
    }

    @Then("user should see welcome {string}")
    public void userShouldSeeWelcome(String username) {
        MatcherAssert.assertThat("username is not visible",
                headerPage.getUsernameAttribute().toLowerCase(), equalTo("welcome " + properties.getProperty("validUsername")));

    }

    @And("user should see logout button")
    public void userShouldSeeLogoutButton() {
        MatcherAssert.assertThat("logout button is not visible",
                headerPage.getLogoutAttribute().toLowerCase(), equalTo("log out"));

    }

    @Then("user should see alert message")
    public void userShouldSeeAlertMessage() {
        MatcherAssert.assertThat("alert message is not visible", loginPage.isAlertMessageVisible(), equalTo(true));
    }
}

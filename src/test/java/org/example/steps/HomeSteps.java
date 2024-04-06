package org.example.steps;

import io.cucumber.java.Before;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.app.pages.CartPage;
import org.example.app.pages.HomePage;
import org.example.app.properties.PropertiesReader;
import org.hamcrest.MatcherAssert;
import org.springframework.beans.factory.annotation.Autowired;

import static org.example.app.properties.PropertiesReader.properties;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.not;

public class HomeSteps {

    @Autowired
    HomePage homePage;

    @Before
    public void background(){
        PropertiesReader.initializePropertyFile();
    }

    @When("user click next button on home page")
    public void userClickNextButtonOnHomePage() {
        homePage.clickNextButton();
    }

    @Then("user should see product that is different from the first product")
    public void userShouldSeeProductThatIsDifferentFromTheFirstProduct() {
        MatcherAssert.assertThat("product name is not visible",
                homePage.getFirstProductName().toLowerCase(),not(equalTo(properties.getProperty("firstProduct"))));
    }

    @When("user click prev button on home page")
    public void userClickPrevButtonOnHomePage() {
        homePage.clickPrevButton();
    }

    @Then("user should see the same product as the first product")
    public void userShouldSeeTheSameProductAsTheFirstProduct() {
        MatcherAssert.assertThat("product name is not visible",
                homePage.getProductName().get(1).toLowerCase(), equalTo("nokia lumia 1520"));

    }
}

package org.example.steps;

import io.cucumber.java.Before;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.app.pages.CartPage;
import org.example.app.properties.PropertiesReader;
import org.hamcrest.MatcherAssert;
import org.springframework.beans.factory.annotation.Autowired;

import static org.hamcrest.Matchers.equalTo;

public class CartSteps{

    @Autowired
    CartPage cartPage;

    @Before
    public void background(){
        PropertiesReader.initializePropertyFile();
    }

    @When("user delete product on cart page")
    public void userDeleteProductOnCartPage() {
        cartPage.clickDeleteButton();
    }

    @Then("user should see empty cart")
    public void userShouldSeeEmptyCart() {
        MatcherAssert.assertThat("product name visible",
                cartPage.isProductNameVisible(), equalTo(false));
    }
}

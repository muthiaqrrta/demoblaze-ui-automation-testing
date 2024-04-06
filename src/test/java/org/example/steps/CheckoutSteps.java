package org.example.steps;

import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.app.pages.CartPage;
import org.example.app.pages.HeaderPage;
import org.example.app.pages.HomePage;
import org.example.app.pages.ProductDetailPage;
import org.example.app.properties.PropertiesReader;
import org.hamcrest.MatcherAssert;
import org.springframework.beans.factory.annotation.Autowired;

import static org.example.app.properties.PropertiesReader.properties;
import static org.hamcrest.Matchers.equalTo;

public class CheckoutSteps {

    @Autowired
    HeaderPage headerPage;

    @Autowired
    HomePage homePage;

    @Autowired
    ProductDetailPage productDetailPage;

    @Autowired
    CartPage cartPage;

    @Before
    public void background(){
        PropertiesReader.initializePropertyFile();
    }


    @When("user click first product on home page")
    public void userClickFirstProductOnHomePage() {
        homePage.clickFirstProduct();
    }

    @Then("user should see product name on product detail page")
    public void userShouldSeeProductNameOnProductDetailPage() {
        MatcherAssert.assertThat("product name is not visible",
                productDetailPage.getProductNameAttribute().toLowerCase(), equalTo(properties.getProperty("firstProduct")));
    }

    @When("user click add to cart button")
    public void userClickAddToCartButton() {
        productDetailPage.clickAddToCartButton();
    }

    @When("user click cart button")
    public void userClickCartButton() {
        headerPage.clickCartButton();
    }

    @Then("user should see the added product")
    public void userShouldSeeTheAddedProduct() {
        MatcherAssert.assertThat("product name is not visible",
                cartPage.getProductNameAttribute().toLowerCase(), equalTo(properties.getProperty("firstProduct")));
    }

    @When("user click place order button")
    public void userClickPlaceOrderButton() {
        cartPage.clickPlaceOrderButton();
    }

    @And("user click purchase button")
    public void userClickPurchaseButton() {
        cartPage.clickPurchaseButton();
    }

    @Then("user should see order successfull")
    public void userShouldSeeOrderSuccessfull() {
        MatcherAssert.assertThat("order is not successfull",
                cartPage.getOrderSuccessfullConfirmation().toLowerCase(), equalTo("thank you for your purchase!"));
    }

    @And("fill name form using {string}")
    public void fillNameFormUsing(String name) {
        cartPage.fillName(name);
    }

    @And("fill country using {string}")
    public void fillCountryUsing(String country) {
        cartPage.fillCountry(country);
    }

    @And("fill city using {string}")
    public void fillCityUsing(String city) {
        cartPage.fillCity(city);
    }

    @And("fill credit card using {string}")
    public void fillCreditCardUsing(String creditCard) {
        cartPage.fillCreditCard(creditCard);
    }

    @And("fill month using {string}")
    public void fillMonthUsing(String month) {
        cartPage.fillMonth(month);
    }

    @And("fill year using {string}")
    public void fillYearUsing(String year) {
        cartPage.fillYear(year);
    }
}

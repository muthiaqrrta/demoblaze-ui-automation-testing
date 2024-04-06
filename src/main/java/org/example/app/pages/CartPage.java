package org.example.app.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import org.springframework.stereotype.Component;

@Component("org.example.app.pages.CartPage")
public class CartPage extends GeneralPage{

    @FindBy(xpath = "//button[text()='Place Order']")
    private WebElementFacade placeOrderButton;

    @FindBy(xpath = "(//tr[@class='success'])[1]//td[2]")
    private WebElementFacade productName;

    @FindBy(xpath = "//input[@id='name']")
    private WebElementFacade nameForm;

    @FindBy(xpath = "//input[@id='country']")
    private WebElementFacade countryForm;

    @FindBy(xpath = "//input[@id='city']")
    private WebElementFacade cityForm;

    @FindBy(xpath = "//input[@id='card']")
    private WebElementFacade creditCardForm;

    @FindBy(xpath = "//input[@id='month']")
    private WebElementFacade monthForm;

    @FindBy(xpath = "//input[@id='year']")
    private WebElementFacade yearForm;

    @FindBy(xpath = "//button[text()='Purchase']")
    private WebElementFacade purchaseButton;

    @FindBy(xpath = "(//h2)[3]")
    private WebElementFacade orderSuccessfull;

    public String getProductNameAttribute(){
        productName.waitUntilVisible();
        return productName.getText();
    }

    public void clickPlaceOrderButton(){
        placeOrderButton.waitUntilClickable().click();
    }

    public void fillName(String name) {
        nameForm.waitUntilEnabled().type(name);
    }

    public void fillCountry(String country) {
        countryForm.type(country);
    }

    public void fillCity(String city) {
        cityForm.type(city);
    }

    public void fillCreditCard(String creditCard) {
        creditCardForm.type(creditCard);
    }

    public void fillMonth(String month) {
        monthForm.type(month);
    }

    public void fillYear(String year) {
        yearForm.type(year);
    }

    public void clickPurchaseButton(){
        purchaseButton.waitUntilClickable().click();
    }

    public String getOrderSuccessfullConfirmation(){
        orderSuccessfull.waitUntilVisible();
        return orderSuccessfull.getText();
    }
}

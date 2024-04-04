package org.example.app.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import org.springframework.stereotype.Component;

@Component("org.example.app.pages.LoginPage")
public class LoginPage extends GeneralPage {

    @FindBy(xpath = "//input[@id='loginusername']")
    private WebElementFacade usernameForm;

    @FindBy(xpath = "//input[@id='loginpassword']")
    private WebElementFacade passwordForm;

    @FindBy(xpath = "//button[text()='Log in']")
    private WebElementFacade loginButton;

    @FindBy(xpath = "//div[@class='alert alert-danger']")
    private WebElementFacade alertMessageAttribute;

    public void fillUsername(String username) {
        usernameForm.type(username);
    }

    public void fillPassword(String password) {
        passwordForm.type(password);
    }

    public void submit() {
        loginButton.click();
        waitABit(5000);
    }

}

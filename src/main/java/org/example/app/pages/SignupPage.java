package org.example.app.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import org.springframework.stereotype.Component;

@Component("org.example.app.pages.SignupPage")
public class SignupPage extends GeneralPage {
    @FindBy(xpath = "//input[@id='sign-username']")
    private WebElementFacade usernameForm;

    @FindBy(xpath = "//input[@id='sign-password']")
    private WebElementFacade passwordForm;

    @FindBy(xpath = "//button[text()='Sign up']")
    private WebElementFacade signupButton;

    @FindBy(xpath = "(//div[@class='modal-header'])[2]")
    private WebElementFacade signupForm;

    public void fillUsername(String username) {
        usernameForm.type(username);
    }

    public void fillPassword(String password) {
        passwordForm.type(password);
    }

    public void submit() {
        signupButton.waitUntilClickable().click();
    }

    public boolean isSignupFormVisible(){
        return signupForm.isVisible();
    }
}

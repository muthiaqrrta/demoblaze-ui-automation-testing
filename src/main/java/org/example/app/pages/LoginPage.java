package org.example.app.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.stereotype.Component;

@Component("org.example.app.pages.LoginPage")
public class LoginPage extends GeneralPage {

    @FindBy(xpath = "//input[@id='loginusername']")
    private WebElementFacade usernameForm;

    @FindBy(xpath = "//input[@id='loginpassword']")
    private WebElementFacade passwordForm;

    @FindBy(xpath = "//button[text()='Log in']")
    private WebElementFacade loginButton;

    @FindBy(xpath = "(//button[text()='Close'])[3]")
    private WebElementFacade closeButton;

    public void fillUsername(String username) {
        usernameForm.type(username);
    }

    public void fillPassword(String password) {
        passwordForm.type(password);
    }

    public void submit() {
        loginButton.waitUntilClickable().click();
    }

    public String getAlertMessage(){
        // Switch to the alert
        WebDriverWait wait = new WebDriverWait(getDriver(),10);
        wait.until(ExpectedConditions.alertIsPresent());
        Alert alert = getDriver().switchTo().alert();

        // Get and print the alert text
        String alertText = alert.getText();
        System.out.println("Alert text: " + alertText);

        // Accept the alert after getting the alert text
        alert.accept();

        return alertText;
    }

    public void clickCloseButton() {
        closeButton.waitUntilClickable().click();
    }
}

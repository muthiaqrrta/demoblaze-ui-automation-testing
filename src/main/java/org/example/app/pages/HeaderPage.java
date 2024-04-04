package org.example.app.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import org.springframework.stereotype.Component;

@Component("org.example.app.pages.HeaderPage")
public class HeaderPage extends GeneralPage {

    @FindBy(xpath = "//a[@id='login2']")
    private WebElementFacade loginButton;

    @FindBy(xpath = "//a[@id='nameofuser']")
    private WebElementFacade username;

    @FindBy(xpath = "//a[@id='logout2']")
    private WebElementFacade logoutButton;

    public void clickLoginButton() {
        loginButton.click();
    }

    public String getUsernameAttribute(){
        return username.getText();
    }

    public String getLogoutAttribute(){
        return logoutButton.getText();
    }

}

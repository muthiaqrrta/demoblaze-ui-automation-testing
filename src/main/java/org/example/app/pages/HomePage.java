package org.example.app.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import org.springframework.stereotype.Component;

import java.util.List;

@Component("org.example.app.pages.HomePage")
public class HomePage extends GeneralPage{

    @FindBy(xpath = "//div[@class='card h-100']//a")
    private List<WebElementFacade> listProductLink;

    @FindBy(xpath = "//button[@id='next2']")
    private WebElementFacade nextButton;

    @FindBy(xpath = "//button[@id='prev2']")
    private WebElementFacade prevButton;

    public void clickFirstProduct() {
        listProductLink.get(0).waitUntilClickable().click();
    }

    public void clickNextButton(){
        nextButton.waitUntilClickable().click();
    }

    public void clickPrevButton(){
        prevButton.waitUntilClickable().click();
        waitABit(1000);
    }

    public String getFirstProductName(){
        scrollToElement(listProductLink.get(0));
        listProductLink.get(0).waitUntilVisible();
        return listProductLink.get(0).getText();
    }

    public List<String> getProductName(){
        scrollToElement(listProductLink.get(0));
        return getTextListWebElement(listProductLink);
    }
}

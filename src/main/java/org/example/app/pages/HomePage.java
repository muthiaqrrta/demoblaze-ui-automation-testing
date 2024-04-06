package org.example.app.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import org.springframework.stereotype.Component;

import java.util.List;

@Component("org.example.app.pages.HomePage")
public class HomePage extends GeneralPage{

    @FindBy(xpath = "//div[@class='card h-100']")
    private List<WebElementFacade> listProduct;

    @FindBy(xpath = "//div[@class='card h-100']//a")
    private List<WebElementFacade> listProductLink;

    public void clickFirstProduct() {
        listProductLink.get(0).waitUntilClickable().click();
    }
}

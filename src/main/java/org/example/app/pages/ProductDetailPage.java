package org.example.app.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import org.springframework.stereotype.Component;

@Component("org.example.app.pages.ProductDetailPage")
public class ProductDetailPage extends GeneralPage{

    @FindBy(xpath = "//h2")
    private WebElementFacade productName;

    @FindBy(xpath = "//a[text()='Add to cart']")
    private WebElementFacade addToCartButton;

    public String getProductNameAttribute(){
        productName.waitUntilVisible();
        return productName.getText();
    }

    public void clickAddToCartButton(){
        addToCartButton.waitUntilClickable().click();
    }
}

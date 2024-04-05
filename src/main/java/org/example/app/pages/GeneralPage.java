package org.example.app.pages;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;

public class GeneralPage extends PageObject {

    public void scrollToElement(WebElementFacade webElementFacade) {
        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        js.executeScript("arguments[0].scrollIntoView(true);", webElementFacade);
        waitABit(1000);
    }

    public boolean isListWebElementVisible(List<WebElementFacade> listWebElement) {
        if (listWebElement.size() > 0) {
            for (WebElementFacade webElementFacade : listWebElement) {
                if (!webElementFacade.isVisible()) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    public List<String> getTextListWebElement(List<WebElementFacade> listWebElement) {
        List<String> stringList = new ArrayList<>();
        for (WebElementFacade webElementFacade : listWebElement) {
            stringList.add(webElementFacade.getText().trim());
        }
        return stringList;
    }

    public void refreshPage() {
        getDriver().navigate().refresh();
        waitABit(1000);
    }
}

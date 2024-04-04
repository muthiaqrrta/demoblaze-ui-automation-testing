package org.example.app.drivers;

import net.thucydides.core.webdriver.DriverSource;
import org.example.app.utility.EnvironmentVariablesUtility;
import org.openqa.selenium.WebDriver;

public class WebDriverConfiguration implements DriverSource {

    @Override
    public WebDriver newDriver() {
        CustomDriver driver = CustomDriver.valueOf(EnvironmentVariablesUtility.getProperties("driver").toUpperCase());
        boolean isRemote = Boolean.parseBoolean(EnvironmentVariablesUtility.getProperties("isRemote"));
        CustomWebDriver customWebDriver = initializeDriver(driver);
        setWebDriverCapabilities(customWebDriver, isRemote);
        return customWebDriver.getDriver();
    }

    private void setWebDriverCapabilities(CustomWebDriver customWebDriver, boolean isRemote) {
        if (isRemote) {
            String url = EnvironmentVariablesUtility.getRemoteProperties("url");
            boolean enableVnc = Boolean.parseBoolean(EnvironmentVariablesUtility.getRemoteProperties("enableVnc"));
            boolean enableVideo = Boolean.parseBoolean(EnvironmentVariablesUtility.getRemoteProperties("enableVideo"));
            customWebDriver.setRemoteCapability(enableVnc, enableVideo);
            customWebDriver.initializeRemoteDriver(url);
        } else {
            customWebDriver.setLocalCapability();
            customWebDriver.initializeLocalDriver();
        }
    }

    private CustomWebDriver initializeDriver(CustomDriver driver) {
        CustomWebDriver customWebDriver;
        switch (driver) {
            case CHROME:
                customWebDriver = new CustomChromeDriver();
                break;
            case FIREFOX:
                customWebDriver = new CustomFirefoxDriver();
                break;
            default:
                customWebDriver = new CustomChromeDriver();
                break;
        }
        return customWebDriver;
    }

    @Override
    public boolean takesScreenshots() {
        return false;
    }
}

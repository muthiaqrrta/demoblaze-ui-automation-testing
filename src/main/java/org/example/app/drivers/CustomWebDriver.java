package org.example.app.drivers;

import org.openqa.selenium.WebDriver;

public abstract class CustomWebDriver {
    WebDriver driver;
    public abstract void initializeLocalDriver();
    public abstract void initializeRemoteDriver(String remoteUrl);
    public abstract void setLocalCapability();
    public abstract void setRemoteCapability(boolean enableVnc, boolean enableVideo);
    public abstract WebDriver getDriver();
}

package org.example.app.drivers;

import io.github.bonigarcia.wdm.WebDriverManager;
import lombok.SneakyThrows;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.URL;
import java.util.HashMap;

public class CustomFirefoxDriver extends CustomWebDriver {

    private FirefoxProfile profile;
    private FirefoxOptions options;
    private DesiredCapabilities capabilities;

    public CustomFirefoxDriver() {
        WebDriverManager.firefoxdriver().setup();
        profile = new FirefoxProfile();
        options = new FirefoxOptions();
    }

    @Override
    public void initializeLocalDriver() {
        options.merge(capabilities);
        driver = new FirefoxDriver(options);
        driver.manage().window().maximize();
    }

    @SneakyThrows
    @Override
    public void initializeRemoteDriver(String remoteUrl) {
        options.merge(capabilities);
        URL url = new URL(remoteUrl);
        driver = new RemoteWebDriver(url, options);
        driver.manage().window().maximize();
    }

    @Override
    public void setLocalCapability() {
        capabilities = DesiredCapabilities.firefox();
        capabilities.setCapability(FirefoxDriver.PROFILE, profile);
    }

    @Override
    public void setRemoteCapability(boolean enableVnc, boolean enableVideo) {
        capabilities = DesiredCapabilities.firefox();
        capabilities.setCapability(FirefoxDriver.PROFILE, profile);
        capabilities.setCapability("screenResolution", "1280x1024x24");
        capabilities.setCapability("enableVnc", enableVnc);
        capabilities.setCapability("enableVideo", enableVideo);
        options.setCapability("moz:firefoxOptions", new HashMap<String, Object>() {
            {
                put("prefs", new HashMap<String, Object>() {
                    {
                        put("browser.helperApps.neverAsk.saveToDisk", "application/octet-stream");
                    }
                });
            }
        });
    }

    @Override
    public WebDriver getDriver() {
        return driver;
    }
}

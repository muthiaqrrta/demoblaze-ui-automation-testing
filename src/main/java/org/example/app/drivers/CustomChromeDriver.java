package org.example.app.drivers;

import io.github.bonigarcia.wdm.WebDriverManager;
import lombok.SneakyThrows;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;

public class CustomChromeDriver extends CustomWebDriver {

    private ChromeOptions options;
    private DesiredCapabilities capabilities;

    public CustomChromeDriver() {
        WebDriverManager.chromedriver().setup();
        options = new ChromeOptions();
    }

    @Override
    public void initializeLocalDriver() {
        options.merge(capabilities);
        driver = new ChromeDriver(options);
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
        capabilities = DesiredCapabilities.chrome();
        capabilities.setCapability(ChromeOptions.CAPABILITY, options);
    }

    @Override
    public void setRemoteCapability(boolean enableVnc, boolean enableVideo) {
        capabilities = DesiredCapabilities.chrome();
        capabilities.setCapability(ChromeOptions.CAPABILITY, options);
        capabilities.setCapability("screenResolution", "1920x1080x24");
        capabilities.setCapability("enableVnc", enableVnc);
        capabilities.setCapability("enableVideo", enableVideo);
        options.setExperimentalOption("prefs", new HashMap<String, Object>() {
            {
                put("profile.default_content_settings.popups", 0);
                put("download.default_directory", "/home/selenium/Downloads");
                put("download.prompt_for_download", false);
                put("download.directory_upgrade", true);
                put("safebrowsing.enabled", false);
                put("plugins.always_open_pdf_externally", true);
                put("plugins.plugins_disabled", new ArrayList<String>() {
                    {
                        add("Chrome PDF Viewer");
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

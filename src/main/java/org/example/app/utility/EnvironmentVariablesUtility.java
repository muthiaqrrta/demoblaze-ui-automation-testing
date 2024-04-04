package org.example.app.utility;

import net.thucydides.core.util.EnvironmentVariables;
import net.thucydides.core.util.SystemEnvironmentVariables;

public class EnvironmentVariablesUtility {

    private static EnvironmentVariables variables = SystemEnvironmentVariables.createEnvironmentVariables();
    private static final String CONFIGURATION_PREFIX = "configuration.webdriver.";
    private static final String CONFIGURATION_REMOTE_PREFIX = CONFIGURATION_PREFIX + "remote.";

    public static String getProperties(String key) {
        return variables.getProperty(CONFIGURATION_PREFIX + key);
    }

    public static String getRemoteProperties(String key) {
        return variables.getProperty(CONFIGURATION_REMOTE_PREFIX + key);
    }
}


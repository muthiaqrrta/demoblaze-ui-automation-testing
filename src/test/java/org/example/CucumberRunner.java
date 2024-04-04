package org.example;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features="src/test/resources/features/",
        plugin = {"json:target/destination/cucumber.json"},
        stepNotifications = true,
        tags = "@Negative",
        glue="org.example")
public class CucumberRunner {}

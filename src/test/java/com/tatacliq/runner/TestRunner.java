package com.tatacliq.runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features/application/ValidatePriceDetails.feature",
        glue = "com.tatacliq.steps",
        plugin = {"pretty","html:reports/cucumber.html",
                "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"},
        monochrome = true,
        tags = "@web"
)
public class TestRunner {
}

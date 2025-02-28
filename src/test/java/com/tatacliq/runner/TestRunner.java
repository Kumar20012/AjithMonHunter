package com.tatacliq.runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features/application/ProductSortBy.feature",
        glue = "com.tatacliq.steps",
        plugin = {"pretty","html:reports/cucumber.html"},
        tags = "@web",
        monochrome = true

)
public class TestRunner {
}

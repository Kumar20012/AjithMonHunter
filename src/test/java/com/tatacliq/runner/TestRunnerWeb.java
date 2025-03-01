package com.tatacliq.runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features/application/LoginCommon.feature",
        glue = "com.tatacliq.steps",
        plugin = {"pretty","html:target/cucumber.html",
                "json:target/cucumber.json",
                "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
        },
        tags = "@web",
        monochrome = true

)
public class TestRunnerWeb {
}

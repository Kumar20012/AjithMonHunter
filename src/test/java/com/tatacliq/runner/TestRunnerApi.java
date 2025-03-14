package com.tatacliq.runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features/restsssured",
        glue = "com.tatacliq.steps",
        plugin = {"pretty","html:target/cucumber.html","json:target/cucumber.json"
        },
        tags = "@api",
        monochrome = true

)
public class TestRunnerApi {

}

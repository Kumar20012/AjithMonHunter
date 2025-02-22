package com.tatacliq.steps;

import com.tatacliq.utils.RestAssuredUtils;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.junit.Assert;

public class ResponseSteps {

    @Then("verify status code is {int}")
    public void verifyStatusCodeIs(int statusCode) {
        Assert.assertEquals(statusCode,RestAssuredUtils.getStatusCode());
    }

    @And("verify response body has a field {string} is {string}")
    public void verify_response_body_has_a_field_is(String jsonPath, String value) {
        Assert.assertEquals(value, RestAssuredUtils.getResponseFieldValue(jsonPath));

    }
}

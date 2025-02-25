package com.tatacliq.steps;

import com.github.fge.jsonschema.main.JsonSchema;
import com.github.fge.jsonschema.main.JsonValidator;
import com.github.fge.jsonschema.messages.JsonSchemaValidationBundle;
import com.tatacliq.utils.RestAssuredUtils;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.response.Response;
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

    @And("verify the field {string} is available")
    public void verifyTheFieldDataIsAvailable(String val) {
        Assert.assertTrue(RestAssuredUtils.FiledNameIsAvailable(val));
    }

    @And("the response should match the JSON schema {string}")
    public void theResponseShouldMatchTheJSONSchema(String fileName) {
        Response response1 = RestAssuredUtils.getResponse();
        response1.then().assertThat().body(JsonSchemaValidator.matchesJsonSchemaInClasspath("apidata\\"+fileName));
    }
}

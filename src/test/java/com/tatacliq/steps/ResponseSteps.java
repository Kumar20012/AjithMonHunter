package com.tatacliq.steps;

import com.github.fge.jsonschema.main.JsonSchema;
import com.github.fge.jsonschema.main.JsonValidator;
import com.github.fge.jsonschema.messages.JsonSchemaValidationBundle;
import com.tatacliq.pojo.OrderPetStore;
import com.tatacliq.utils.ConfigurationManager;
import com.tatacliq.utils.RestAssuredUtils;
import io.cucumber.core.internal.com.fasterxml.jackson.databind.ObjectMapper;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.response.Response;
import org.junit.Assert;

import java.io.FileNotFoundException;

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

    @And("verify response body matches request body")
    public void verifyResponseBodyMatchesRequestBody() {
        OrderPetStore response_pojo = RestAssuredUtils.getResponse().as(OrderPetStore.class);
        OrderPetStore request_pojo = (OrderPetStore) ConfigurationManager.getObject("order_request");
        Assert.assertEquals(request_pojo,response_pojo);

    }

    @When("store response {string} into {string}")
    public void storeResponseInto(String jsonPath, String key) throws Exception {
        String val = RestAssuredUtils.getResponseFieldValue(jsonPath);
        System.out.println(val);
        ConfigurationManager.setConfigValue(key,val);
    }
}

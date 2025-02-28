package com.tatacliq.steps;

import com.tatacliq.pojo.OrderPetStore;
import com.tatacliq.utils.ConfigurationManager;
import com.tatacliq.utils.RestAssuredUtils;
import io.cucumber.core.internal.com.fasterxml.jackson.databind.JsonNode;
import io.cucumber.core.internal.com.fasterxml.jackson.databind.ObjectMapper;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import java.io.File;
import java.io.IOException;

public class RequestSteps {

    @When("user performs {string} call")
    public void userPerformsGetCall(String call) {
        switch (call) {
            case "get" -> RestAssuredUtils.get();
            case "post" -> RestAssuredUtils.post();
            case "delete" -> RestAssuredUtils.delete();
            default -> RestAssuredUtils.put();
        }
    }

    @Given("user wants to call {string} end point")
    public void userWantsToCallEndPoint(String endPoint) {
        RestAssuredUtils.clear();
        if (endPoint.contains("@name") && endPoint.contains("@pass")) {
            endPoint = endPoint.replace("@pass", ConfigurationManager.getConfigValues("user.password"));
            endPoint = endPoint.replace("@name", ConfigurationManager.getConfigValues("user.name"));
        } else if (endPoint.contains("@user")) {
            System.out.println(ConfigurationManager.getConfigValues("username"));
            endPoint = endPoint.replaceAll("@user", ConfigurationManager.getConfigValues("username"));
        }
        RestAssuredUtils.setEndPoint(endPoint);
    }

    @Given("set header {string} to {string}")
    public void set_header_to(String key, String value) {
        RestAssuredUtils.setHeader(key, value);

    }

    @Given("set request body from file {string}")
    public void set_request_body_from_file(String filePath) {
        RestAssuredUtils.setBody(filePath);
    }

    @When("get the data {string} from json file {string}")
    public void getTheUserNameFromJsonFile(String data, String fileName) {
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode jsonNode = null;
        try {
            jsonNode = objectMapper.readTree(new File("src/test/resources/apidata/" + fileName));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        String name = jsonNode.get(data).asText();
        ConfigurationManager.setConfigValue(data, name);
        System.out.println(ConfigurationManager.getConfigValues(data));
    }

    @And("set request body from using pojo {string}")
    public void setRequestBodyFromUsingPojo(String fileName) throws Exception {
        String bodyData = RestAssuredUtils.getDataFromJsonFile(fileName);
        ObjectMapper objectMapper = new ObjectMapper();
        OrderPetStore requestPojo = objectMapper.readValue(bodyData, OrderPetStore.class);
        RestAssuredUtils.setBody(requestPojo);
        ConfigurationManager.setObject("order_request", requestPojo);
    }

    @And("set path param {string} to {string}")
    public void setPathParamTo(String key, String value) {
        RestAssuredUtils.setPathParam(key, ConfigurationManager.getConfigValues(value));
    }
}

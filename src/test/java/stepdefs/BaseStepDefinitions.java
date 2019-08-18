package stepdefs;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import org.apache.commons.lang3.StringUtils;

import java.util.Map;

import static org.hamcrest.Matchers.equalTo;

public class BaseStepDefinitions {

    private StepData stepData;

    public BaseStepDefinitions(StepData stepData) {
        this.stepData = stepData;
    }

    @Then("the status code is (\\d+)")
    public void verifyStatusCode(int statusCode) {
        stepData.json = stepData.response.then().statusCode(statusCode);
    }

    @And("response includes the following$")
    public void responseEquals(Map<String, String> responseFields) {
        for (Map.Entry<String, String> field : responseFields.entrySet()) {
            if (StringUtils.isNumeric(field.getValue())) {
                stepData.json.body(field.getKey(), equalTo(Integer.parseInt(field.getValue())));
            } else {
                stepData.json.body(field.getKey(), equalTo(field.getValue()));
            }
        }
    }
}

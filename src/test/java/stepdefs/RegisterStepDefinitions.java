package stepdefs;

import config.BaseApi;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import static io.restassured.RestAssured.given;

public class RegisterStepDefinitions {
    private StepData stepData;
    public RegisterStepDefinitions(StepData stepData) { this.stepData = stepData;}

    BaseApi baseApi = new BaseApi();
    private String baseURI = baseApi.buildPath("register");

    @Given("^a user with valid email (.*) and password (.*) exists$")
    public void aUserWithValidEmailAndPasswordExists(String email, String password){
        String payload = "{\n" +
                "  \"email\": \""+email+"\",\n" +
                "  \"password\": \""+password+"\"\n" +
                "}";
        stepData.request = given().contentType("application/json; charset=UTF-8").body(payload);
    }

    @When("^the client registers the user$")
    public void theClientRegistersTheUser() throws Throwable {
        stepData.response = stepData.request.when().post(baseURI);
    }
}

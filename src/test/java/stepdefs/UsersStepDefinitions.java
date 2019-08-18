package stepdefs;

import config.BaseApi;
import cucumber.api.java.en.Given;
import static io.restassured.RestAssured.given;
import cucumber.api.java.en.When;

public class UsersStepDefinitions {
    private StepData stepData;

    public UsersStepDefinitions(StepData stepData) {
        this.stepData = stepData;
    }

    BaseApi baseApi = new BaseApi();
    private String baseURI = baseApi.buildPath("users");

    @Given("a page exists with id (.*)")
    public void aUserWithId(int pageNumber) {
        stepData.request = given().param("page", pageNumber);
    }

    @When("a client retrieves the page")
    public void aClientRetrievesTheUserById() {
        stepData.response = stepData.request.when().get(baseURI);
    }

    @Given("^a webservice can receive user (.*) and job (.*) fields$")
    public void aWebserviceCanReceiveUserMorpheusAndJobLeaderFields(String name, String job) {
        String payload = "{\n" +
                "  \"name\": \"" + name + "\",\n" +
                "  \"job\": \"" + job + "\"\n" +
                "}";

        stepData.request = given().contentType("application/json; charset=UTF-8").body(payload);
    }

    @When("^a client sends the user and job")
    public void aClientSendsTheUserAndPassword() {
        stepData.response = stepData.request.when().post(baseURI);
    }

    @When("^the client updates the user with id with (.*)$")
    public void updateUserWithPutMethod(String userId) {
        stepData.response = stepData.request.basePath("/" + userId).when().put(baseURI);
    }

    @Given("^a user exists with id (\\d+)$")
    public void aUserWithIdExists(int userId) {
        stepData.request = given().basePath("/" + userId);
    }

    @When("^a client deletes the user$")
    public void aClientDeletesTheUser() throws Throwable {
        stepData.response = stepData.request.delete(baseURI);
    }
}

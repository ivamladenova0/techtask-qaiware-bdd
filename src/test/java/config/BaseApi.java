package config;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.enableLoggingOfRequestAndResponseIfValidationFails;

public class BaseApi {

    public String buildPath(String path){
        enableLoggingOfRequestAndResponseIfValidationFails();
        baseURI = "https://reqres.in/api/" + path;
        return baseURI;
    }
}

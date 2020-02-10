package helpers;

import io.restassured.RestAssured;
import io.restassured.response.ValidatableResponse;

public class RequestHelper {
    private ValidatableResponse response;

    public RequestHelper sendGetRequest(String url) {
        response = RestAssured.given().get(url).then().statusCode(200);
        return this;
    }

    public String extractBody(){
        return response.extract().response().getBody().asString();
    }
}

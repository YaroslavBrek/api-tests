package api;

import io.qameta.allure.Step;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static helpers.StringHelper.getEnvUrl;
import static io.restassured.RestAssured.with;

public class UserApiSteps {

    private static final String USER_URI = "/user/";
    private final RequestSpecification withDefaultRequestSpecification;

    public UserApiSteps() {
        withDefaultRequestSpecification = new RequestSpecBuilder()
                .setAccept(ContentType.JSON)
                .setBaseUri(getEnvUrl())
                .setBasePath(USER_URI)
                .build();
    }

    @Step("GET /user/..")
    public Response sendGetUser(String userId) {
        return with().spec(withDefaultRequestSpecification)
                .get(userId);
    }

    @Step("POST /user/..")
    public Response sendPostUser(String userId) {
        return with()
                .spec(withDefaultRequestSpecification)
                .post(userId);
    }

    @Step("GET /user")
    public Response sendGetAllUsers() {
        return with()
                .spec(withDefaultRequestSpecification)
                .get();
    }
}

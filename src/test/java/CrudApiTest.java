import api.UserApiSteps;
import api.entity.User;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static api.ResponseExtractor.getBookFromResponse;
import static org.apache.hc.core5.http.HttpStatus.SC_NOT_FOUND;

public class CrudApiTest extends Assert {
    private UserApiSteps userApiSteps;

    public UserApiSteps onUserApi() {
        if (userApiSteps == null) {
            userApiSteps = new UserApiSteps();
        }
        return userApiSteps;
    }

    @Test(groups = "api")
    public void getStatusCode200() {
        onUserApi()
                .sendGetAllUsers()
                .then()
                .assertThat()
                .statusCode(200)
                .contentType(ContentType.JSON);
    }

    @Test(groups = "api")
    public void getSingleUserWithIdEqualsTwo() {
        Response response = onUserApi()
                .sendGetUser("2");
        User user = getBookFromResponse(response);
        assertEquals(user.getId(), 2);
    }

    @Test(groups = "api")
    public void getNotFoundError() {
        onUserApi()
                .sendGetUser("666")
                .then()
                .assertThat()
                .statusCode(SC_NOT_FOUND);
    }
}

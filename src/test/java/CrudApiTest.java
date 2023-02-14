import static org.apache.hc.core5.http.HttpStatus.SC_NOT_FOUND;
import static org.apache.hc.core5.http.HttpStatus.SC_OK;

import api.UserApiSteps;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class CrudApiTest extends Assert {
    private UserApiSteps userApiSteps;

    public UserApiSteps onUserApi() {
        if (userApiSteps == null) {
            userApiSteps = new UserApiSteps();
        }
        return userApiSteps;
    }

    @Test(groups = "api")
    public void getUsers() {
        onUserApi()
                .sendGetAllUsers()
                .then()
                .assertThat()
                .statusCode(200)
                .contentType(ContentType.JSON);
    }

    @Test(groups = "api")
    public void getSingleUser() {
        onUserApi()
                .sendGetUser("2")
                .then()
                .assertThat()
                .statusCode(SC_OK)
                .contentType(ContentType.JSON);
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

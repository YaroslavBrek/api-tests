import static io.restassured.RestAssured.given;
import static org.apache.hc.core5.http.HttpStatus.SC_NOT_FOUND;
import static org.apache.hc.core5.http.HttpStatus.SC_OK;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class CrudApiTest extends Assert {

  @Test(groups = "api")
  public void getUsers() {
    given()
        .when()
        .get("http://crud:9000/user/")
        .then()
        .assertThat()
        .statusCode(200)
        .contentType(ContentType.JSON);
  }

  @Test(groups = "api")
  public void getSingleUser() {
    given()
        .when()
        .get("http://crud:9000/user/2")
        .then()
        .assertThat()
        .statusCode(SC_OK)
        .contentType(ContentType.JSON);
  }

  @Test(groups = "api")
  public void getNotFoundError() {
    given()
        .when()
        .get("http://crud:9000/user/666")
        .then()
        .assertThat()
        .statusCode(SC_NOT_FOUND);
  }
}

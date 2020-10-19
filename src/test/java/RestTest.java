import helpers.FileLoader;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class RestTest extends Assert {
    private static Object[] data;

    @BeforeClass
    public void initialize() {
        data = FileLoader.loadCsvData("autoria_API_links.csv")
                .toArray();
    }

    @DataProvider
    public static Object[] urlValues() {
        return data;
    }

    @AfterClass
    public void destroy() {
    }

    @Test(dataProvider = "urlValues")
    public void checkServerResponseCode(String uri){
        given()
                .when()
                .header("User-Agent", "Jmeter")
                .get(uri)
                .then()
                .assertThat()
                .statusCode(200)
                .contentType("text/html")
                .header("Content-Encoding", "gzip");
    }
}

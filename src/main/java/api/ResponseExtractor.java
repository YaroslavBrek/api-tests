package api;

import api.entity.User;
import com.google.gson.Gson;
import io.restassured.response.Response;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j2;

import java.util.List;

@Log4j2
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ResponseExtractor {

    public static List<User> getBooksListFromResponse(Response response) {
        return response.jsonPath().getList("", User.class);
    }

    public static User getBookFromResponse(Response response) {
        return response.as(User.class);
    }
}

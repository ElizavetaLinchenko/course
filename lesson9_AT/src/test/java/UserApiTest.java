import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import model.User;
import model.UserResponse;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import utils.Logger;

import java.util.List;
import java.util.stream.Collectors;

public class UserApiTest extends Logger {

    @Test
    void getUsersTest() {
        Response response = RestAssured.given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .when()
                .get("https://reqres.in/api/users?page=2");
        Assertions.assertEquals(HttpStatus.SC_OK, response.getStatusCode());

        UserResponse userResponse = response.as(UserResponse.class);
        List<User> users = userResponse.getUser();

        List<String> emailList = users.stream()
                .map(User::getEmail)
                .filter(email -> email.contains("@"))
                .collect(Collectors.toList());

        Assertions.assertEquals(users.size(), emailList.size());
    }
}
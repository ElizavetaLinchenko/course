import io.restassured.RestAssured;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import model.User;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;

public class UserApiTest {
    @BeforeAll
    static void prepareLogger() {
        RestAssured.filters(new RequestLoggingFilter(), new ResponseLoggingFilter());
    }

    @Test
    void getUsersTest() {
        List<User> users = RestAssured.given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .when()
                .get("https://reqres.in/api/users?page=2")
                .then()
                .statusCode(HttpStatus.SC_OK)
                .contentType(ContentType.JSON)
                .extract()
                .jsonPath()
                .getList("data", User.class);

        List<String> emailList = users.stream()
                .map(User::getEmail)
                .filter(email -> email.contains("@"))
                .collect(Collectors.toList());

        Assertions.assertEquals(users.size(), emailList.size());
    }
}
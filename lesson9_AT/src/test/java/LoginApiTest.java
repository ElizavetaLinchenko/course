import io.restassured.http.ContentType;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import utils.Logger;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

import static io.restassured.RestAssured.given;

public class LoginApiTest extends Logger {

    public static Stream<Arguments> сredentials() {
        return Stream.of(
                Arguments.of(null, "password"),
                Arguments.of("username", null)
        );
    }

    @ParameterizedTest
    @MethodSource("сredentials")
    public void testLoginWithInvalidCredentials(String username, String password) {
        Map<String, String> queryParams = new HashMap<>();
        queryParams.put("username", username);
        queryParams.put("password", password);
        queryParams.values().removeIf(value -> value == null);

        given()
                .contentType(ContentType.JSON)
                .queryParams(queryParams)
                .when()
                .get("https://reqres.in/api/login")
                .then()
                .statusCode(400);
    }
}
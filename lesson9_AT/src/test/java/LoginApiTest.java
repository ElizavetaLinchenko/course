import io.restassured.http.ContentType;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static io.restassured.RestAssured.given;

public class LoginApiTest {
    public static Stream<Arguments> сredentials() {
        return Stream.of(
                Arguments.of(null, "password", 400),
                Arguments.of("username", null, 400)
        );
    }

    @ParameterizedTest
    @MethodSource("сredentials")
    public void testLoginWithInvalidCredentials(String username, String password, int expectedStatusCode) {
        given()
                .contentType(ContentType.JSON)
                .queryParam("username", username)
                .queryParam("password", password)
                .when()
                .get("https://reqres.in/api/login")
                .then()
                .statusCode(expectedStatusCode);
    }
}
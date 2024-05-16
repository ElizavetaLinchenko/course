import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MyFinTest {
    @Test
    public void testStatusCode() {
        Response response = RestAssured.get("https://myfin.by/online-services?utm_source=myfin&utm_medium=organic&utm_campaign=menu");
        int statusCode = response.getStatusCode();
        Assertions.assertEquals(200, statusCode);
    }
}
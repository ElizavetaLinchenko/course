import constants.Endpoint;
import io.restassured.RestAssured;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import model.Pet;
import model.PetResponse;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class AddPetApiTest {
    @BeforeAll
    static void prepareLogger() {
        RestAssured.filters(new RequestLoggingFilter(), new ResponseLoggingFilter());
        RestAssured.baseURI = "https://petstore.swagger.io/v2";
    }

    @Test
    void createAddPetTest() {
        Pet pet = new Pet();
        pet.setName("Kitty");
        pet.setStatus("available");

        PetResponse response = RestAssured.given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .body(pet)
                .when()
                .post(Endpoint.ADD_PET)
                .then()
                .statusCode(HttpStatus.SC_OK)
                .contentType(ContentType.JSON)
                .extract()
                .as(PetResponse.class);
        Assertions.assertEquals("Kitty", response.getName());
        Assertions.assertEquals("available", response.getStatus());
    }
}
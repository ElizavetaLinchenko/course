import constants.Endpoint;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import model.Pet;
import model.PetResponse;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import utils.Logger;

public class AddPetApiTest extends Logger {

    @Test
    void createAddPetTest() {
        String baseURI = "https://petstore.swagger.io/v2";
        Pet pet = new Pet("Kitty", "available");

        PetResponse response = RestAssured.given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .body(pet)
                .when()
                .post(baseURI + Endpoint.ADD_PET)
                .then()
                .statusCode(HttpStatus.SC_OK)
                .contentType(ContentType.JSON)
                .extract()
                .as(PetResponse.class);
        Assertions.assertEquals("Kitty", response.getName());
        Assertions.assertEquals("available", response.getStatus());
    }
}
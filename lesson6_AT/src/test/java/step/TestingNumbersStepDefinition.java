package step;

import io.cucumber.java.en.Then;
import org.junit.jupiter.api.Assertions;

public class TestingNumbersStepDefinition {
    @Then("Test that the number from the {int} column is bigger than the number from the {int} column")
    public void testNumbersValue(int first, int second) {
        Assertions.assertTrue(first > second);
    }
}
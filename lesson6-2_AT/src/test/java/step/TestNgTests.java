package step;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestNgTests {
    @DataProvider(name = "numbers")
    public Object[][] testingNumbers() {
        return new Object[][]{
                {1},
                {2},
                {3},
                {4}
        };
    }

    @Test(dataProvider = "numbers")
    void testNumbers(int number) {
        Assert.assertTrue(number > 0);
    }

    @DataProvider(name = "text")
    public Object[][] testingText() {
        return new Object[][]{
                {"tested", "test"},
                {"testing", "tester"}
        };
    }

    @Test(dataProvider = "text")
    void testLength(String firstValue, String secondValue) {
        Assert.assertTrue(firstValue.length() > secondValue.length());
    }
}
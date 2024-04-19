import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;


public class JunitDataProviderColors {
    @ParameterizedTest
    @EnumSource(value = Colors.class, names = {"RED", "WHITE"})
    void checkColors(Colors colors) {
        Assertions.assertNotNull(colors);
        Assertions.assertFalse(colors.toString().isEmpty());
    }
}
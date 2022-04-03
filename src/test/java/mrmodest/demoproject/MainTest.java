package mrmodest.demoproject;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MainTest {

    @ParameterizedTest
    @CsvSource({"1,2,3", "2,3,5"})
    public void sumTest(int a, int b, long expectedSum) {
        assertEquals(expectedSum, Main.sum(a, b));
    }
}

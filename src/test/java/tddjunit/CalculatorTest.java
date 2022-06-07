package tddjunit;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import tddjunit.exemplo.util.Calculator;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class CalculatorTest {

    private final Calculator calculator = new Calculator();

    @Test
    void addition() {
        assertEquals(120, calculator.multiply(4,30));
    }
}

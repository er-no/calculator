package calculator;

import org.junit.Test;
import static org.junit.Assert.*;

public class CalculatorTest {

    @Test
    public void testCalculatorInvocation() {
        var c = new Calculator();
        assertNotNull(c);
    }

    @Test
    public void testCalculatorInput() {
        var c = new Calculator();
        c.input("4");
        assertEquals("add method adds length",
            c.instructions(),
            1);
    }
}

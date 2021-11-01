package calculator;

import org.junit.Test;
import static org.junit.Assert.*;

public class CalculatorTest {

    @Test
    public void testCalculatorInvocation() {
        var c = new Calculator();
        assertNotNull(c);
        assertEquals("begins with 0 on the stack", 1, c.instructions());
    }

    @Test
    public void testCalculatorInputNumber() {
        var c = new Calculator();
        c.input( new Number());
        assertEquals("add method adds length",
            1,
            c.instructions());
    }
}

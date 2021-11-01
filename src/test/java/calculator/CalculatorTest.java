package calculator;

import org.junit.Test;
import static org.junit.Assert.*;

public class CalculatorTest {

    @Test
    public void testCalculatorInvocation() {
        var c = new Calculator();
        assertNotNull(c);
        assertEquals("begins with state 0", 0, c.stateNumber());
        assertTrue("begins with 0 on the tack",
            c.peek().value() == 0);
    }

    @Test
    public void testCalculatorInputNumber() {
        var c = new Calculator();
        c.input(new Number());
        assertEquals("input number from state-zero yields state 0",
            0,
            c.stateNumber());
    }

    @Test
    public void testCalculatorMultipleNumber() {
        var c = new Calculator();
        c.input(new Number(1));
        c.input(new Number(2));
        c.input(new Number(3));
        assertEquals("input multiple numbers will still result in state 0",
            0,
            c.stateNumber());
    }

    @Test
    public void testCalculatorInputOperand() {
        var c = new Calculator();
        c.input(new OperandAddition());
        assertEquals("input operand from state-zero yields state 1",
            1,
            c.stateNumber());
    }

    @Test
    public void testCalculatorMultipleOperand() {
        var c = new Calculator();
        c.input(new OperandDivision());
        c.input(new OperandMultiplication());
        c.input(new OperandAddition());
        c.input(new OperandSubtraction());
        assertEquals("input multiple operands will still result in state 1",
            1,
            c.stateNumber());
    }

    @Test
    public void testLatestAfterNumber() {
        var c = new Calculator();
        Integer actual = c.input(new Number(5));
        assertEquals("when you input a number, it returns latest number",
            5,
            (int) actual);
    }

    @Test
    public void testLatestAfterOperandThenNumber() {
        var c = new Calculator();
        c.input(new OperandSubtraction());
        Integer actual = c.input(new Number(5));
        assertEquals("when inputting operand then number, correct output",
            -5,
            (int) actual);
    }

    @Test
    public void testLatestAfterOperand() {
        var c = new Calculator();
        c.input(new Number(5)); // Overwrite!
        Integer actual = c.input(new OperandAddition());
        assertTrue("when you input an operand, it returns latest number",
            actual.equals(5));
    }
}

package calculator;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class CalculatorArithmeticIntegrationTest {
    private Calculator cal = new Calculator();
    private static final Number NUM = new Number(6);
    private static final OperandAddition ADD = new OperandAddition();
    private static final OperandSubtraction SUB = new OperandSubtraction();
    private static final OperandMultiplication MUL = new OperandMultiplication();
    private static final OperandDivision DIV = new OperandDivision();

    @Before
    public void flushCalculator() {
        this.cal = new Calculator();
        this.cal.input(NUM);
    }

    @Test
    public void addSubMulDiv() {
        assertTrue("Operand retains latest value of 6", cal.input(ADD).equals(6));
        assertTrue("New number completes evaluation of 6 + 6 = 12", cal.input(NUM).equals(12));
        assertTrue("Operand retains latest value of 12", cal.input(SUB).equals(12));
        assertTrue("New number completes evaluation of 12 - 6 = 6", cal.input(NUM).equals(6));
        assertTrue("Operand retains latest value of 6", cal.input(MUL).equals(6));
        assertTrue("New number completes evaluation of 6 * 6 = 36", cal.input(NUM).equals(36));
        assertTrue("Operand retains latest value of 36", cal.input(DIV).equals(36));
        assertTrue("New number completes evaluation of 36 / 6 = 6", cal.input(NUM).equals(6));
    }

}

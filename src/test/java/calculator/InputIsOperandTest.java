package calculator;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class InputIsOperandTest {

    @Test
    public void plusIsOperand() {
        assertTrue("plusses are operands",
        InputFactory.parse(InputFactory.ADD).operand() != null);
    }

    @Test
    public void additionEvaluation() {
        var a = new OperandAddition();
        assertTrue("addition actually evaluations as expected",
        a.evaluation(new Number(5), new Number(5)).equals(10));
    }

    @Test
    public void minusIsOperand() {
        assertTrue("minuses are operands",
        InputFactory.parse(InputFactory.SUB).operand() != null);
    }

    @Test
    public void subtractionEvaluation() {
        var s = new OperandSubtraction();
        assertTrue("subtraction actually evaluations as expected",
        s.evaluation(new Number(15), new Number(5)).equals(10));
    }

    @Test
    public void asteriskAreOperand() {
        assertTrue("asterisks are operands",
        InputFactory.parse(InputFactory.MUL).operand() != null);
    }

    @Test
    public void multiplicationEvaluation() {
        var m = new OperandMultiplication();
        assertTrue("multiplication actually evaluations as expected",
        m.evaluation(new Number(2), new Number(5)).equals(10));
    }

    @Test
    public void slashAreOperand() {
        assertTrue("slashes are operands",
        InputFactory.parse(InputFactory.DIV).operand() != null);
    }

    @Test
    public void divisionEvaluation() {
        var d = new OperandDivision();
        assertTrue("division actually evaluations as expected",
        d.evaluation(new Number(40), new Number(4)).equals(10));
    }
}

package calculator;

import org.junit.Test;

import static org.junit.Assert.*;

public class InputFactoryTest {
    @Test
    public void passingNumberYieldsNumberClass() {
        assertTrue("number shall yield Number",
            InputFactory.parse("1337") instanceof Number);
    }

    @Test
    public void passingPlusYieldsOperandClass() {
        assertTrue("plus shall yield Operand",
            InputFactory.parse("+") instanceof Operand);
    }

    @Test
    public void passingPlusYieldsAdditionClass() {
        assertTrue("plus shall yield OpreandAddition",
            InputFactory.parse("+") instanceof OperandAddition);
    }

    @Test
    public void passingMinusYieldsSubtractionClass() {
        assertTrue("plus shall yield OpreandSubtraction",
            InputFactory.parse("-") instanceof OperandSubtraction);
    }

    @Test
    public void passingAsteriskYieldsMultiplicationClass() {
        assertTrue("plus shall yield OpreandMultiplication",
            InputFactory.parse("*") instanceof OperandMultiplication);
    }

    @Test
    public void passingSlashYieldsDivisionClass() {
        assertTrue("plus shall yield OpreandDivision",
            InputFactory.parse("/") instanceof OperandDivision);
    }

    @Test
    public void passingNonsenseYieldsNull() {
        assertTrue("nonsense yields error",
            InputFactory.parse("poej") == null);
    }
}

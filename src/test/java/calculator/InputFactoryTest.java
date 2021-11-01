package calculator;

import org.junit.Test;

import static org.junit.Assert.*;

public class InputFactoryTest {
    @Test
    public void passingNumberYieldsNumberClass() {
        assertTrue("number shall yield Number",
            InputFactory.parse("1337").value() != null);
    }

    @Test
    public void passingOperandDoesNotYieldNumber() {
        assertTrue("operand shall not yied number",
            InputFactory.parse(InputFactory.ADD).value() == null);
    }

    @Test
    public void passingNumberYieldsThatNumber() {
        assertEquals("number shall actually yield the correct number",
            -93,
            (int) InputFactory.parse("-93").value());
    }

    @Test
    public void passingSignYieldsOperandClass() {
        assertTrue("plus shall yield Operand",
            InputFactory.parse(InputFactory.ADD).operand() != null);
        assertTrue("minus shall yield Operand",
            InputFactory.parse(InputFactory.SUB).operand() != null);
        assertTrue("asterisk shall yield Operand",
            InputFactory.parse(InputFactory.MUL).operand() != null);
        assertTrue("slash shall yield Operand",
            InputFactory.parse(InputFactory.DIV).operand() != null);
    }

    @Test
    public void passingPlusYieldsAdditionClass() {
        assertEquals("plus shall yield OpreandAddition",
            8,
            (int) InputFactory.parse(InputFactory.ADD).operand().evaluation(6, 2).value());
    }

    @Test
    public void passingMinusYieldsSubtractionClass() {
        assertEquals("plus shall yield OpreandSubtraction",
            4,
            (int) InputFactory.parse(InputFactory.SUB).operand().evaluation(6, 2).value());
    }

    @Test
    public void passingAsteriskYieldsMultiplicationClass() {
        assertEquals("plus shall yield OpreandMultiplication",
            12,
            (int) InputFactory.parse(InputFactory.MUL).operand().evaluation(6, 2).value());
    }

    @Test
    public void passingSlashYieldsDivisionClass() {
        assertEquals("plus shall yield OpreandDivision",
            3,
            (int) InputFactory.parse(InputFactory.DIV).operand().evaluation(6, 2).value());
    }

    @Test
    public void passingNonsenseYieldsNull() {
        assertTrue("nonsense yields error",
            InputFactory.parse("poej") == null);
    }

    @Test
    public void passingNumberFollowedByNonsenseYieldsNull() {
        assertTrue("nonsense yeilds error even tho numbers",
            InputFactory.parse("85jwosdpkadg") == null);
    }
}

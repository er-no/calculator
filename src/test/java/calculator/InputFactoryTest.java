package calculator;

import org.junit.Test;

import static org.junit.Assert.*;

public class InputFactoryTest {
    @Test
    public void passingNumberYieldsNumber() {
        assertTrue("number shall yield Number",
            InputFactory.parse("1337") instanceof Number);
    }

    @Test
    public void passingPlusYieldsOperand() {
        assertTrue("plus shall yield Operand",
            InputFactory.parse("+") instanceof Operand);
    }

    @Test
    public void passingNonsenseYieldsError() {
        assertTrue("nonsense yields error",
            InputFactory.parse("poej") == null);
    }
}

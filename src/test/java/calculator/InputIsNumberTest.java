package calculator;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;

public class InputIsNumberTest {

    @Test
    public void construction() {
        var num = new Number(42);
        assertNotNull(num);
    }

    @Test
    public void equalsWithSelf() {
        var num = new Number(1337);
        assertTrue("number objects are .equals with self",
            num.equals(num));
    }

    @Test
    public void equalsWithNumber() {
        var num = new Number(1337);
        assertTrue("number objects are .equals with number objects",
            num.equals(new Number(1337)));
    }

    @Test
    public void equalsWithInteger() {
        var num = new Number(1337);
        assertTrue("number objects are .equals int",
            num.equals(1337));
    }

    @Test
    public void testEqualsWhenNot() {
        var num = new Number(666);
        assertFalse("number objects are not .equals when different",
            num.equals(42));
    }

    @Test
    public void numberIsNumberalNotOperand() {
        var num = new Number(42);
        assertTrue("number is not operand",
            num.operand() == null);
    }
}

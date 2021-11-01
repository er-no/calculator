package calculator;

public abstract class Operand implements Input {

    @Override
    public boolean state() {
        return false;
    }

    @Override
    public Integer value() {
        return null;
    }

    abstract Number evaluation(Number a, Number b);
}

package calculator;

public abstract class Operand implements Input {

    @Override
    public boolean state() {
        return true;
    }

    @Override
    public Integer value() {
        return null;
    }

    abstract Integer evaluation(Number a, Number b);
}

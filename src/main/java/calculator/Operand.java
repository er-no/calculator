package calculator;

public abstract class Operand implements Input {

    @Override
    public Operand operand() {
        return this;
    }

    @Override
    public Integer value() {
        return null;
    }

    Number evaluation(Integer a, Integer b) {
        return evaluation(new Number(a), new Number(b));
    }

    abstract Number evaluation(Number a, Number b);
}

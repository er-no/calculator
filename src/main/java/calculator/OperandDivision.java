package calculator;

public class OperandDivision extends Operand {

    @Override
    Number evaluation(Number a, Number b) {
        return new Number(a.value() / b.value());
    }

}

package calculator;

public class OperandSubtraction extends Operand {

    @Override
    Number evaluation(Number a, Number b) {
        return new Number(a.value() - b.value());
    }

}

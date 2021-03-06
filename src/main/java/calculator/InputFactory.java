package calculator;

/**
 * Creates suitable Input class depending on parsed String
 */
public class InputFactory {
    public static final String ADD = "+";
    public static final String SUB = "-";
    public static final String MUL = ".";
    public static final String DIV = "/";

    private static final String[] OPERANDS = {
        ADD, SUB, MUL, DIV
//index: 0    1    2    3
    };
    /* hide constructor */
    private InputFactory(){}

    public static Input parse(String token) {
        int whatOperand = -1;
        for(int i = 0; i < OPERANDS.length; i++) {
            if(OPERANDS[i].equals(token)) {
                whatOperand = i;
                break;
            }
        }

        if(whatOperand >= 0) {
            if(whatOperand == 0) return new OperandAddition();
            if(whatOperand == 1) return new OperandSubtraction();
            if(whatOperand == 2) return new OperandMultiplication();
            if(whatOperand == 3) return new OperandDivision();
            return null;
        } else {
            try {
                int num = Integer.parseInt(token);
                return new Number(num);
            } catch (NumberFormatException e) {
                return null;
            }
        }
    }
}

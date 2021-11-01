package calculator;

/**
 * Creates suitable Input class depending on parsed String
 */
public class InputFactory {
    private static final String[] OPERANDS = {
        "+", "-", "*", "/"
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
            return new Operand();
        } else {
            try {
                int num = Integer.parseInt(token);
                return new Number();
            } catch (NumberFormatException e) {
                return null;
            }
        }
    }
}

package calculator;

import java.util.Stack;

/**
 * A basic calculator that functions like on of those "basic" calculators that
 * you can see IRL. Essentially a state machine that works something like:
 *
 * state -1 - initial state (equivalent to state 0 -- but with pre-condition):
 *      0 is on top of stack
 *      if input is number, pop stack and push number, goto state 1
 *      if input is operand, push operand, goto state 2
 * state 0 - number is pushed
 *      if input is number, pop stack and push number, goto state 1
 *      if input is operand, push stack, goto state 2
 * state 1 - operand is pushed
 *      if input is number, pop stack and save operand, pop stack and save
 *                          number, apply bin calculation and push to stack
 *                          goto state 1
 *      if input is operand, pop stack and push operand, goto state 2
 */
public class Calculator {
    private Stack<Input> stack;
    private boolean state; // only 2 unique states, boolean can represent them

    public Calculator() {
        this.stack = new Stack<>();
        stack.add(null);
        state = false;
    }

    public int input(Input instruction) {
        if(instruction.state()) {
            stack.add(instruction);
        }
        return 0;
    }

    public int instructions() {
        return stack.size();
    }
}

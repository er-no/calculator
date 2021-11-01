package calculator;

import java.util.Stack;

/**
 * A basic calculator that functions like on of those "basic" calculators that
 * you can see IRL. Essentially a state machine that works something like:
 *
 * state -1 - initial state (equivalent to state 0 -- but with pre-condition):
 *      push 0 ontop of stack, goto state 0
 * state 0 - number is pushed
 *      if input is number, pop stack and push number, goto state 0
 *      if input is operand, push stack, goto state 1
 * state 1 - operand is pushed
 *      if input is number, pop stack and save operand, pop stack and save
 *                          number, apply bin calculation and push to stack
 *                          goto state 0
 *      if input is operand, pop stack and push operand, goto state 1
 */
public class Calculator {
    private Stack<Input> stack;
    private boolean operandOnStack;

    public Calculator() {
        this.stack = new Stack<>();
        stack.add(new Number(0));
        operandOnStack = false;
    }

    /**
     * Inputs the instruction to the calculator. Every instruction has the
     * potential to change the latest presented value of the calculator. This
     * latest value sice the input will be return in the method.
     *
     * Example: - Someone inputs 5, then latest value is 5.
     *          - Now, someone inputs +, then lates value is still 5
     *          - At last someone inputs 3, now latest value will be 8
     *
     * Example: - Someone inputs 4, latest value is 4
     *          - Someone inputs 2, latest value is now 42
     *
     * @param instruction
     * @return latestValue (latest represented value for calculator)
     */
    public Integer input(Input instruction) {
        Integer latestValue = null; // return value
        if (this.operandOnStack == (instruction.operand() != null)) {
            // either top of stack is operand AND ALSO instruction is operand
            // or top of stack is NOT operand AND ALSO instruction is number
            latestValue = overwriteTopOfStack(instruction);
        } else {
            if(instruction.operand() != null) {
                latestValue = stack.peek().value();
            } else {
                latestValue = instruction.value();
            }
            stack.add(instruction);
        }

        // check if we can calculate
        if(stack.size() == 3) {
            int b = stack.pop().value();
            Operand o = stack.pop().operand();
            int a = stack.pop().value();
            stack.add(o.evaluation(a, b));
            latestValue = stack.peek().value();
        }

        operandOnStack = instruction.operand() != null;
        return latestValue;
    }

    /**
     * Tells observers what state the calculator is in
     * @return 0 if number was last inputted, 1 if operand was last inputted
     */
    public int stateNumber() {
        return stack.size() - 1;
    }

    public Input peek() {
        return stack.peek();
    }

    /**
     * Overwrites the top of stack with Input i. Will return the most recent
     * number value from the stack.
     *
     * @param i the Input to overwrite the top with
     * @return the latest value of the latest number in the stack
     */
    private Integer overwriteTopOfStack(Input i) {
        // Get the top of stack and save its value (null if operand)
        Integer latest = stack.pop().value();
        // If top of stack was operand, we need to peek deeper before add
        if(latest == null) latest = stack.peek().value();
        stack.add(i);
        if(i.operand() == null) latest = stack.peek().value();
        return latest;
    }
}

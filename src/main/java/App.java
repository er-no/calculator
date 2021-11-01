import calculator.Calculator;
import calculator.InputFactory;

public class App {
    public static void main(String[] args) {
        final Calculator calc = new Calculator();
        System.out.println("Executing instructions...");
        for(String s : args) {
            System.out.println("Input:  " + s);
            System.out.println("Output: " + calc.input(InputFactory.parse(s)));
        }
    }
}

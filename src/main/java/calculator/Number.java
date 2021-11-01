package calculator;

public class Number implements Input {
    private int value;

    public Number() {
        this.value = 0;
    }

    public Number(int value) {
        this.value = value;
    }

    @Override
    public Operand operand() {
        return null;
    }

    @Override
    public Integer value() {
        return this.value;
    }

    @Override
    public boolean equals(Object o) {
        if(o == this) return true;
        if(o == null) return false;
        if(!(o instanceof Number)) return false;

        Number n = (Number) o;

        return n.value().equals(this.value());
    }

    public boolean equals(int i) {
        return this.value().equals(i);
    }
}

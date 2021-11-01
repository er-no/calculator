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
        return false;
    }

    public boolean equals(Number num) {
        return this.value().equals(num.value());
    }

    public boolean equals(Integer i) {
        return this.value().equals(i);
    }

    public boolean equals(int i) {
        return this.value().equals(i);
    }
}

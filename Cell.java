public class Cell {
    private int value;
    private final boolean isFixed; // true se o valor foi pré-definido no início do jogo

    public Cell(int value, boolean isFixed) {
        this.value = value;
        this.isFixed = isFixed;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public boolean isFixed() {
        return isFixed;
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }
}
public class Calculator {
    private int x;
    private int y;
    public Calculator(int x, int y) {
        this.setX(x);
        this.setY(y);
    }

    public int getX() {
        return this.x;
    }
    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return this.y;
    }

    public void setY(int y) {
        this.y = y;
    }
    public int Add() throws ArithmeticException {
        if (this.x < 0 || this.y < 0) {
            throw new ArithmeticException("numbers can't be negative");
        }
        return this.x + this.y;
    }
    public int Subtract() throws ArithmeticException {
        if (this.x < 0 || this.y < 0) {
            throw new ArithmeticException("numbers can't be negative");
        }
        return this.x - this.y;
    }
    public int Multiplication() throws ArithmeticException {
        if (this.x == 0 || this.y == 0) {
            throw new ArithmeticException("numbers can't be equal to zero");
        }
        return this.x * this.y;
    }
    public int Division() throws ArithmeticException {
        if (this.x == 0 || this.y == 0) {
            throw new ArithmeticException("numbers can't be equal to zero");
        }
        return this.x / this.y;
    }
}

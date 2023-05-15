public class Circle {
    private double r;

    public Circle() {
        this.r = 1.0;
    }

    public Circle(double r) {
        this.r = r;
    }

    public double getRadius() {
        return this.r;
    }

    public void setRadius(double r) {
        this.r = r;
    }

    public double getArea() {
        return Math.PI * Math.pow(this.r, 2);
    }

    public double getCircumference() {
        return Math.PI * 2 * this.r;
    }

    public String toString() {
        return "Circle[r = " + this.r + " ]";
    }
}

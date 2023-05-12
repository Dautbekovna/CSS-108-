package week2.B;

public class Circle extends Shape {
    private double radius;
    public Circle() {
        this.radius = 1.0;
    }
    public Circle(double radius) {
        this.radius = radius;
    }
    public Circle(double radius, String color, boolean filled) {
        super(color, filled);
        this.radius = radius;
    }
    public double getRadius() {
        return this.radius;
    }
    public void setRadius(double radius) {
        this.radius = radius;
    }
    public double getArea() {
        return 3.14 * this.radius * this.radius;
    }
    public double getPerimeter() {
        return 2 * 3.14 * this.radius;
    }
    @Override
    public String toString() {
        return "Circle[" + super.toString() + ",radius=" + this.radius + "]";
    }
}

public class Rectangle extends GeometricObject {
    private int height;
    private int width;
    public Rectangle(int height, int width) {
        this.height = height;
        this.width = width;
    }

    @Override
    public double getArea() {
        return width * height;
    }

    @Override
    public double getPerimeter() {
        return 2 * (width + height);
    }
    @Override
    public String toString() {
        return "Rectangle: " + (int)getArea();
    }
}

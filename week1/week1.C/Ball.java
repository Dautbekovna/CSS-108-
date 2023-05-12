public class Ball {
    private float x;
    private float y;
    private int radius;
    private float xDelta;
    private float yDelta;
    public Ball(float x, float y, int radius, float xDelta, float yDelta) {
        this.x = x;
        this.y = y;
        this.radius = radius;
        this.xDelta = xDelta;
        this.yDelta = yDelta;
    }

    public float getX() {
        return this.x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return this.y;
    }

    public void setY(float y) {
        this.y = y;
    }

    public float getxDelta() {
        return this.xDelta;
    }

    public void setxDelta(float xDelta) {
        this.xDelta = xDelta;
    }

    public float getyDelta() {
        return this.yDelta;
    }

    public void setyDelta(float yDelta) {
        this.yDelta = yDelta;
    }
    public void move() {
        this.x += this.xDelta;
        this.y += this.yDelta;
    }
    public void reflectHorizontal() {
        this.xDelta *= -1;
    }
    public void reflectVertical() {
        this.yDelta *= -1;
    }
    @Override
    public String toString() {
        return "Ball[(" + this.x + "," + this.y + "),speed=(" + this.xDelta + "," + this.yDelta + ")]";
    }
}

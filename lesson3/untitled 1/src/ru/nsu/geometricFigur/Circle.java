package ru.nsu.geometricFigur;

public class Circle extends Figure{
    private double radius;
    private double x;
    private double y;

    public Circle(double x, double y, double radius) {
        this.x = x;
        this.y = y;
        this.radius = radius;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    @Override
    public String toString() {
        return "Circle{" +
                "radius=" + radius +
                ", x=" + x +
                ", y=" + y +
                '}';
    }

    public double getArea() {
        return Math.pow(this.radius, 2) * Math.PI;
    }

    public void resizing(int alpha) {
        setRadius(alpha * this.radius);
    }

    public void move(int x, int y) {
        this.x = x;
        this.y = y;
    }

}

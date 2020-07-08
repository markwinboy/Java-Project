package ru.nsu.geometricFigur;

public class Rectangle extends Figure {
    public double x1;
    public double y1;
    public double x2;
    public double y2;

    public Rectangle(double x1, double y1, double x2, double y2) {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
    }


    public Rectangle() {
        this.x1 = -1;
        this.y1 = -1;
        this.x2 = -1;
        this.y2 = -1;
    }

    public double getX1() {
        return x1;
    }

    public void setX1(double x1) {
        this.x1 = x1;
    }

    public double getY1() {
        return y1;
    }

    public void setY1(double y1) {
        this.y1 = y1;
    }

    public double getX2() {
        return x2;
    }

    public void setX2(double x2) {
        this.x2 = x2;
    }

    public double getY2() {
        return y2;
    }

    public void setY2(double y2) {
        this.y2 = y2;
    }

    public double getB() {
        return this.y2 - this.y1;
    }

    public double getA() {
        return this.x2 - this.x1;
    }

    public double getArea() {
        return (this.x2 - this.x1) * (this.y2 - this.y1);
    }

    @Override
    public String toString() {
        return "Rectangle{" +
                "x1=" + x1 +
                ", y1=" + y1 +
                ", x2=" + x2 +
                ", y2=" + y2 +
                '}';
    }

    public void resizing(int alpha) {
        double diag = Math.sqrt(Math.pow(this.y2 - this.y1, 2) + Math.pow(this.x2 - this.x1, 2));
        double beta1 = (this.x2 - this.x1) / diag;
        double beta2 = (this.y2 - this.y1) / diag;
        diag = diag * alpha;
        this.x2 = diag * beta1 + this.x1;
        this.y2 = diag * beta2 + this.y1;
    }

    public void move(int x, int y) {
        this.x2 = this.x1 + x;
        this.y2 = this.y1 + y;

    }
}


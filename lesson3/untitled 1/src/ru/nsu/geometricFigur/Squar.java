package ru.nsu.geometricFigur;

import java.time.LocalDate;
import java.util.Set;


public class Squar extends Figure{
    public double x1;
    public double y1;
    public double y2;
    public double x2;

    public static void main(String[] args) {

        Squar rec = new Squar(100, 100, 250, 200);
        rec.move(50, 100);
        System.out.println(rec.getY2());
        System.out.println(rec.getX2());
    }

    public double getX1() {
        return this.x1;
    }

    public double getY1() {
        return this.y1;
    }

    public double getX2() {
        return this.x2;
    }

    public double getY2() {
        return this.y2;
    }

    public Squar(double x1, double y1, double x2, double y2) {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
    }

    public Squar() {
        this.x1 = -1;
        this.y1 = -1;
        this.x2 = -1;
        this.y2 = -1;
    }

    @Override
    public String toString() {
        return "Squar{" +
                "x1=" + x1 +
                ", y1=" + y1 +
                ", y2=" + y2 +
                ", x2=" + x2 +
                '}';
    }

    public double getArea() {
        return Math.pow((this.y2 - this.y1), 2);
    }

    public void resizing(int alpha) {
        double diag = Math.sqrt(Math.pow(this.y2 - this.y1, 2) * 2);
        double beta = Math.abs(this.y2 - this.y1) / diag;
        diag = diag * alpha;
        this.y2 = diag * beta + this.y1;
        this.x2 = diag * beta + this.x1;
    }


    public void move(int x, int y) {
        this.y2 = this.y2 - this.y1 + y;
        this.x2 = this.x2 - this.x1 + x;
    }

}



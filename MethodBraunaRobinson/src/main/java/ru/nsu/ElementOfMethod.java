package ru.nsu;

public class ElementOfMethod {
    private int kOrder;
    private int iOrder;
    private int[] UAJ;
    private Double alpha;
    private int jOrder;
    private int[] UAI;
    private Double beta;
    private Double value;
    private Double delta;
    private Double epsilon;

    public ElementOfMethod(int kOrder, int iOrder, int[] UAJ, double alpha,
                           int jOrder, int[] UAI, double beta, double value, double delta,
                           double epsilon) {
        this.kOrder = kOrder;
        this.iOrder = iOrder;
        this.UAI = UAI;
        this.UAJ = UAJ;
        this.alpha = alpha;
        this.jOrder = jOrder;
        this.beta = beta;
        this.value = value;
        this.delta = delta;
        this.epsilon = epsilon;
    }

    public int getkOrder() {
        return kOrder;
    }

    public int getiOrder() {
        return iOrder;
    }

    public int[] getUAI() {
        return UAI;
    }

    public double getAlpha() {
        return alpha;
    }

    public int getjOrder() {
        return jOrder;
    }

    public double getBeta() {
        return beta;
    }

    public double getValue() {
        return value;
    }

    public double getDelta() {
        return delta;
    }

    public double getEpsilon() {
        return epsilon;
    }

    public void setkOrder(int kOrder) {
        this.kOrder = kOrder;
    }

    public void setiOrder(int iOrder) {
        this.iOrder = iOrder;
    }

    public void setUAI(int[] UAI) {
        this.UAI = UAI;
    }

    public void setAlpha(double alpha) {
        this.alpha = alpha;
    }

    public void setjOrder(int jOrder) {
        this.jOrder = jOrder;
    }

    public void setBeta(double beta) {
        this.beta = beta;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public int[] getUAJ() {
        return UAJ;
    }

    public void setUAJ(int[] UAJ) {
        this.UAJ = UAJ;
    }

    public void setDelta(double delta) {
        this.delta = delta;
    }

    public void setEpsilon(double epsilon) {
        this.epsilon = epsilon;
    }
}

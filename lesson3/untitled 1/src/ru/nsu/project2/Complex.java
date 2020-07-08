package ru.nsu.project2;

public class Complex {

    private double real;
    private double imaginarius;

    public Complex(int real,int imaginarius){
        this.real = real;
        this.imaginarius = imaginarius;
    }

    public Complex(double real,double imaginarius){
        this.real = real;
        this.imaginarius = imaginarius;
    }


    public double getReal(){
        return real;
    }

    public double getImaginarius(){
        return imaginarius;
    }


    public Complex sum(Complex comp2){
        return new Complex(this.getReal()+comp2.getReal(),
                this.getImaginarius()+comp2.getImaginarius());
    }

    public Complex sub(Complex comp2){
        return new Complex(this.getReal()-comp2.getReal(),
                this.getImaginarius()-comp2.getImaginarius());
    }

    public Complex multy(Complex comp2){
        return new Complex(this.getReal()*comp2.getReal()-this.getImaginarius()*comp2.getImaginarius(),
                this.getReal()*comp2.getImaginarius()-this.getImaginarius()*comp2.getReal());

    }

    @Override
    public String toString() {
        return "Complex{" +
                "real=" + real +
                ", imaginarius=" + imaginarius +
                '}';
    }
}


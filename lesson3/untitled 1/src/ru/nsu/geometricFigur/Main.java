package ru.nsu.geometricFigur;


import ru.nsu.geometricFigur.Circle;
import ru.nsu.geometricFigur.Figure;
import ru.nsu.geometricFigur.Rectangle;
import ru.nsu.geometricFigur.Squar;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Rectangle rec = new Rectangle(10, 10, 20, 20);
        List<Figure> figureList = new ArrayList<>();
        Squar rec1 = new Squar(10,10,30,30);
        Circle cir = new Circle(100,100,10);
        figureList.add(cir);
        figureList.add(rec);
        figureList.add(rec1);

        double sum=0;
        for(Figure f: figureList){
            sum+=f.getArea();
            System.out.println(f);
        }
        System.out.println(sum);
    }
}

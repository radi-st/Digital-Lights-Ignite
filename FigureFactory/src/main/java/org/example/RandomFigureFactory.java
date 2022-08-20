package org.example;
import java.util.Random;

public class RandomFigureFactory {
    private static Triangle getRandomValidTriangle(){
        Random rand= new Random();

        double side1, side2, side3;

        do{
            side1=rand.nextDouble()*100+1;
            side2=rand.nextDouble()*100+1;
            side3=rand.nextDouble()*100+1;
        } while(side1+side2<=side3 || side1+side3<=side2 || side3+side2<=side1 );

        return new Triangle(side1,side2,side3);
    }
    public static Figure create() {
        Random rand= new Random();
        int fig_number=rand.nextInt(3);
        return switch (fig_number) {
            case 0 -> getRandomValidTriangle();
            case 1 -> new Circle(rand.nextDouble() * 100 + 1);
            case 2 -> new Rectangle(rand.nextDouble() * 100 + 1, rand.nextDouble() * 100 + 1);
            default -> null;
        };
    }
}

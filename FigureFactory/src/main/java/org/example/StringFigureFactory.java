package org.example;
import java.io.InputStream;
import java.util.Scanner;

public class StringFigureFactory {
    public static Figure create(String line) throws Exception{
        Scanner sc= new Scanner(line);
        String class_name=sc.next().toLowerCase();
        return switch (class_name) {
            case "triangle" -> new Triangle(sc.nextDouble(), sc.nextDouble(), sc.nextDouble());
            case "circle" -> new Circle(sc.nextDouble());
            case "rectangle" -> new Rectangle(sc.nextDouble(), sc.nextDouble());
            default -> throw new IllegalArgumentException("Input is invalid!");
        };
    }
}

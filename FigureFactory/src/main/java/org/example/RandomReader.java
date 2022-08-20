package org.example;
import java.util.ArrayList;
import java.util.Scanner;

public class RandomReader {

    public static ArrayList<Figure> createFigures(int count){
        ArrayList<Figure> result= new ArrayList<Figure>();
        for(int i=0; i<count;++i){
            result.add(RandomFigureFactory.create());
        }
        return result;
    }
}

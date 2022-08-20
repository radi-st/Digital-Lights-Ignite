package org.example;
import javax.print.DocFlavor;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Scanner;

public class StreamReader {

    public static ArrayList<Figure> createFigures(InputStream in) throws Exception {
        ArrayList<Figure> result= new ArrayList<Figure>();
        Scanner sc = new Scanner(in);
        while (sc.hasNext()) {
            result.add(StringFigureFactory.create(sc.nextLine()));
        }
        return result;

    }

    public static ArrayList<Figure> createFigures(int count, InputStream in) throws Exception{
        ArrayList<Figure> result= new ArrayList<Figure>();
        Scanner sc = new Scanner(in);
        for (int i = 0; i < count; ++i) {
            result.add(StringFigureFactory.create(sc.nextLine()));
        }
        return result;

    }

}

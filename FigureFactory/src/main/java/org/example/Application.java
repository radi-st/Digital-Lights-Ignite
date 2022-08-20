package org.example;
import java.io.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

public class Application {

    private static int getFigureCount(InputStream in, PrintStream out) throws IllegalArgumentException{
        out.println("How many figures should i create?");
        Scanner sc= new Scanner(in);
        int count=sc.nextInt();
        if(count<0){
            throw new IllegalArgumentException("Figure count must be nonnegative!");
        }
        return count;
    }

    private static String getInputType(InputStream in, PrintStream out) throws Exception{
        Scanner sc=new Scanner(in);
        out.println("Choose input type for figure generation: random, stdin or file");
        String input_type=sc.nextLine().toLowerCase();
        if(!(input_type.equals("random") || input_type.equals("stdin") || input_type.equals("file"))) {
            throw new Exception("Input type must be one of the following: random, stdin, file");
        }
        return input_type;
    }

    private static String getFileName(InputStream in, PrintStream out){
        Scanner sc=new Scanner(in);
        out.println("Input the name of the file from which the figures will be read.");
        return sc.next();
    }


    public static void printFiguresToPrintStream(ArrayList<Figure> figures, PrintStream out){
        for ( Figure figure: figures){
           out.println(figure.toString());
        }
        out.close();
    }
    public static void printGeneratedFigures(ArrayList<Figure> figures){
        printFiguresToPrintStream(figures,System.out);
    }

    public static void deleteFigure(ArrayList<Figure> figures, int index) throws IndexOutOfBoundsException{
        figures.remove(index);
    }

    public static void writeFiguresToFile(ArrayList<Figure> figures, String filename) throws Exception{
        File file= new File(filename);
        file.createNewFile();
        printFiguresToPrintStream(figures,new PrintStream(file));

    }

    public static Figure duplicateFigureAt(ArrayList<Figure> figures, int index) throws CloneNotSupportedException{
        return figures.get(index).clone();
    }

    public static void main(String[] args) {
        try {
            String input_type;
            input_type = getInputType(System.in,System.out);

            int count;
            ArrayList<Figure> figures;
            switch (input_type) {
                case "random" -> {
                    count = getFigureCount(System.in,System.out);
                    figures = RandomReader.createFigures(count);
                }
                case "stdin" -> {
                    count = getFigureCount(System.in,System.out);
                    figures = StreamReader.createFigures(count, System.in);
                }
                case "file" -> {
                    String filename = getFileName(System.in,System.out);
                    File file= new File(filename);
                    file.createNewFile();
                    InputStream ifstream = new FileInputStream(file);
                    figures = StreamReader.createFigures(ifstream);
                    ifstream.close();
                }
                default -> throw new IllegalArgumentException("There is no such input type!");
            }
            printGeneratedFigures(figures);
        } catch (Exception e){
            System.out.println("Something went wrong. " + e.getMessage());
        }
    }

}

package org.example;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class ApplicationTest {

    @Test
    void testDeleteFigure() {
        ArrayList<Figure> figures1=new ArrayList<>();
        figures1.add(new Triangle(1.5,1.6,1));
        figures1.add(new Circle(10));
        figures1.add(new Rectangle(7,8.9));

        ArrayList<Figure> figures2= new ArrayList<>(figures1);
        ArrayList<Figure> figures3= new ArrayList<>(figures1);

        ArrayList<Figure> figures4=new ArrayList<>();
        figures4.add(new Triangle(1.5,1,2));

        Application.deleteFigure(figures1, 1);
        assertEquals(2,figures1.size());
        assertEquals("triangle 1.5 1.6 1.0", figures1.get(0).toString());
        assertEquals("rectangle 7.0 8.9", figures1.get(1).toString());

        Application.deleteFigure(figures2, 0);
        assertEquals(2,figures2.size());
        assertEquals("circle 10.0", figures2.get(0).toString());
        assertEquals("rectangle 7.0 8.9", figures2.get(1).toString());

        Application.deleteFigure(figures3, 2);
        assertEquals(2,figures3.size());
        assertEquals("triangle 1.5 1.6 1.0", figures3.get(0).toString());
        assertEquals("circle 10.0", figures3.get(1).toString());
        assertThrows(IndexOutOfBoundsException.class, ()->Application.deleteFigure(figures3,2));
        assertThrows(IndexOutOfBoundsException.class, ()->Application.deleteFigure(figures3,-1));

        Application.deleteFigure(figures4, 0);
        assertTrue(figures4.isEmpty());

    }

    @Test
    void testPrintFiguresToPrintStream(){
        ByteArrayOutputStream byte_out1=new ByteArrayOutputStream();
        PrintStream out1= new PrintStream(byte_out1);

        ArrayList<Figure> figures1=new ArrayList<>();
        figures1.add(new Triangle(1.5,1.6,1));
        figures1.add(new Circle(10));
        figures1.add(new Rectangle(7,8.9));

        Application.printFiguresToPrintStream(figures1,out1);

        assertEquals("triangle 1.5 1.6 1.0" + System.lineSeparator() +
                "circle 10.0" + System.lineSeparator() +
                "rectangle 7.0 8.9" + System.lineSeparator(),
                byte_out1.toString());

    }

    @Test
    void testDuplicateFigureAt() throws CloneNotSupportedException {
        ArrayList<Figure> figures1=new ArrayList<>();
        figures1.add(new Triangle(1.5,1.6,1));
        figures1.add(new Circle(10));
        figures1.add(new Rectangle(7,8.9));

        Figure f1=Application.duplicateFigureAt(figures1,0);
        Figure f2=Application.duplicateFigureAt(figures1,1);
        Figure f3=Application.duplicateFigureAt(figures1,2);

        assertThrows(IndexOutOfBoundsException.class,()->Application.duplicateFigureAt(figures1,3));
        assertThrows(IndexOutOfBoundsException.class,()->Application.duplicateFigureAt(figures1,-1));

        assertAll("Figures are not the same instance",
                ()->assertNotSame(f1,figures1.get(0)),
                ()->assertNotSame(f2,figures1.get(1)),
                ()->assertNotSame(f3,figures1.get(2))
                );

        assertAll("Figures have the same field values",
                ()->assertEquals(figures1.get(0).toString(),f1.toString()),
                ()->assertEquals(figures1.get(1).toString(),f2.toString()),
                ()->assertEquals(figures1.get(2).toString(),f3.toString())
                );

    }
}
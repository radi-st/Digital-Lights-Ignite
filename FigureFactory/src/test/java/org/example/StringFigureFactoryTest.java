package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StringFigureFactoryTest {

    @Test
    void testCreateMethodWithValidParameters() throws Exception {
        Figure t1= StringFigureFactory.create("triangle 1,9 2 3,0");
        Figure c1= StringFigureFactory.create("CirClE 10");
        Figure r1= StringFigureFactory.create("RECTANGLE 3,9 4,5");

        assertEquals("triangle 1.9 2.0 3.0", t1.toString());
        assertEquals("circle 10.0",c1.toString());
        assertEquals("rectangle 3.9 4.5",r1.toString());

        assertEquals("class org.example.Triangle", t1.getClass().toString());
        assertEquals("class org.example.Circle",c1.getClass().toString());
        assertEquals("class org.example.Rectangle",r1.getClass().toString());
    }

    @Test
    void testCreateMethodWithInvalidParameters() {

        assertAll("Triangle with invalid parameters",
                ()->assertThrows(IllegalArgumentException.class,()->StringFigureFactory.create("triangle 1 -2,9 -8")),
                ()->assertThrows(IllegalArgumentException.class,()->StringFigureFactory.create("triangle 1 2,9 0")),
                ()->assertThrows(IllegalArgumentException.class,()->StringFigureFactory.create("triangle 3,0 1,9 5"))
        );

        assertAll("Circle with invalid parameters",
                ()->assertThrows(IllegalArgumentException.class,()->StringFigureFactory.create("circle 0,0")),
                ()->assertThrows(IllegalArgumentException.class,()->StringFigureFactory.create("circle -1,5"))
        );

        assertAll("Circle with invalid parameters",
                ()->assertThrows(IllegalArgumentException.class,()->StringFigureFactory.create("rectangle 1,7 0 ")),
                ()->assertThrows(IllegalArgumentException.class,()->StringFigureFactory.create("rectangle -7 4,9"))
                );

        assertAll("Generaly invalid input",
                ()->assertThrows(IllegalArgumentException.class,()->StringFigureFactory.create("3angle 1,7 3 2 ")),
                ()->assertThrows(IllegalArgumentException.class,()->StringFigureFactory.create("rec7a#gle -7 4,9")),
                ()->assertThrows(IllegalArgumentException.class,()->StringFigureFactory.create("10 circle 20.8"))
        );
    }
}
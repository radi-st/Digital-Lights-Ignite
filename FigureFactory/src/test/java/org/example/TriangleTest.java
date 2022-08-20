package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TriangleTest {

    @Test
    void triangleConstructorThrowsWhenGivenInvalidParameters() {
        assertAll("Doesn't pass sum of sides validation.",
                ()->assertThrows(
                        IllegalArgumentException.class,
                        ()->new Triangle(3,2,6),
                        "The sum of two sides must be greater the the third side!" ),
                ()->assertThrows(
                        IllegalArgumentException.class,
                        ()->new Triangle(4,5,9),
                        "The sum of two sides must be greater the the third side!" ));

        assertAll("Doesn't pass nonnegative sides validation.",
                ()->assertThrows( IllegalArgumentException.class, ()->new Triangle(-1,1,1),"Sides must be a positive number!"),
                ()->assertThrows( IllegalArgumentException.class, ()->new Triangle(0,1,1),"Sides must be a positive number!"));
    }

    @Test
    void testToString() {
        Triangle t1= new Triangle(3,4,5);
        Triangle t2 = new Triangle(2,3.7,5.6);
        assertEquals("triangle 3.0 4.0 5.0", t1.toString());
        assertEquals("triangle 2.0 3.7 5.6", t2.toString());
    }


    @Test
    void testGetPerimeter() {
        Triangle t1= new Triangle(3,4,5);
        Triangle t2 = new Triangle(2,3.7,5.6);
        Triangle t3 = new Triangle(5.9,2.4,6);

        assertEquals(12,t1.getPerimeter());
        assertEquals(2+3.7+5.6,t2.getPerimeter());
        assertEquals(14.3,t3.getPerimeter());

    }

    @Test
    void testClone() throws Exception {
        Triangle t1= new Triangle(3,4,5);
        Triangle t3 = new Triangle(5.9,2.4,6);

        Triangle t1_clone=t1.clone();
        Triangle t3_clone=t3.clone();

        assertAll("Object and clone have the same field values",
                ()->assertEquals(t1.toString(),t1_clone.toString()),
                ()->assertEquals(t3.toString(),t3_clone.toString()));

        assertAll("Clone returns a new object not the original.",
                ()->assertNotSame(t1_clone, t1),
                ()->assertNotSame(t3_clone, t3));
    }
}
package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RectangleTest {

    @Test
    void rectangleConstructorThrowsWhenGivenInvalidParameters() {

        assertThrows( IllegalArgumentException.class, ()->new Rectangle(-1.5,1),"Sides must be a positive number!");
        assertThrows( IllegalArgumentException.class, ()->new Rectangle(0,10),"Sides must be a positive number!");
        assertThrows( IllegalArgumentException.class, ()->new Rectangle(2,-10),"Sides must be a positive number!");
    }

    @Test
    void testToString(){

        Rectangle r1= new Rectangle(1,10);
        Rectangle r2= new Rectangle(3.5,787);

        assertEquals("rectangle 1.0 10.0", r1.toString());
        assertEquals("rectangle 3.5 787.0", r2.toString());
    }

    @Test
    void testGetPerimeter() {

        Rectangle r1= new Rectangle(1,10);
        Rectangle r2= new Rectangle(3.5,787);

        assertEquals(22,r1.getPerimeter());
        assertEquals(2*(3.5+787),r2.getPerimeter());
    }


    @Test
    void testClone() throws CloneNotSupportedException{

        Rectangle r1= new Rectangle(1,10);
        Rectangle r2= new Rectangle(3.5,787);
        Rectangle r3= new Rectangle(0.1,2.4);

        Rectangle r1_clone=r1.clone();
        Rectangle r2_clone=r2.clone();
        Rectangle r3_clone=r3.clone();

        assertAll("Object and clone have the same field values",
                ()->assertEquals(r1.toString(),r1_clone.toString()),
                ()->assertEquals(r2.toString(),r2_clone.toString()),
                ()->assertEquals(r3.toString(),r3_clone.toString()));

        assertAll("Clone returns a new object not the original.",
                ()->assertNotSame(r1_clone, r1),
                ()->assertNotSame(r2_clone, r2),
                ()->assertNotSame(r3_clone, r3));
    }
}
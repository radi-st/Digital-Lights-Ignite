package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CircleTest {

    @Test
    void circleConstructorThrowsWhenGivenInvalidParameters() {

        assertThrows( IllegalArgumentException.class, ()->new Circle(-27.7),"Radius must be a positive number!");
        assertThrows( IllegalArgumentException.class, ()->new Circle(0),"Radius must be a positive number!");
        assertThrows( IllegalArgumentException.class, ()->new Circle(-0.1),"Radius must be a positive number!");
    }

    @Test
    void testToString() {
        Circle c1= new Circle(1);
        Circle c2= new Circle(809.9);

        assertEquals("circle 1.0",c1.toString());
        assertEquals("circle 809.9",c2.toString());
    }

    @Test
    void testGetPerimeter() {
        Circle c1= new Circle(1);
        Circle c2= new Circle(809.9);

        assertEquals(2*Math.PI*1, c1.getPerimeter());
        assertEquals(2*Math.PI*809.9, c2.getPerimeter());
    }

    @Test
    void testClone() throws CloneNotSupportedException{
        Circle c1= new Circle(0.5);
        Circle c2= new Circle(10);

        Circle c1_clone= c1.clone();
        Circle c2_clone= c2.clone();

        assertAll("Object and clone have the same field values",
                ()->assertEquals(c1.toString(),c1_clone.toString()),
                ()->assertEquals(c2.toString(),c2_clone.toString()));

        assertAll("Clone returns a new object not the original.",
                ()->assertNotSame(c1_clone, c1),
                ()->assertNotSame(c2_clone, c2));



    }
}
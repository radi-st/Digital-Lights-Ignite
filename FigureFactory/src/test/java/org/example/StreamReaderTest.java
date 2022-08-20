package org.example;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

class StreamReaderTest {

    @Test
    void testCreateFiguresWith1ParameterInputStream() throws Exception {
        String testString1 = """
                triangle 3 4 5
                circle 10,7
                rectangle 7,9 10\s
                """;

        String testString2 = """
                triangle 3 4 5
                circle -1,9
                rectangle 0 10\s
                """;

        String testString3 ="";

        ByteArrayInputStream stream1 = new ByteArrayInputStream(testString1.getBytes());
        ArrayList<Figure> result1= StreamReader.createFigures(stream1);

        ByteArrayInputStream stream2 = new ByteArrayInputStream(testString2.getBytes());
        assertThrows(IllegalArgumentException.class,()-> StreamReader.createFigures(stream2));

        ByteArrayInputStream stream3 = new ByteArrayInputStream(testString3.getBytes());
        assertTrue(StreamReader.createFigures(stream3).isEmpty());

        assertEquals("triangle 3.0 4.0 5.0",result1.get(0).toString());
        assertEquals("circle 10.7",result1.get(1).toString());
        assertEquals("rectangle 7.9 10.0",result1.get(2).toString());
    }

    @Test
    void testCreateFiguresWith2ParametersInputStreamAndCount() throws Exception {

        String testString1 = """
                triangle 3 4 5
                circle 10,7
                rectangle 7,9 10\s
                """;

        String testString2 = """
                triangle 3 4 5
                circle -1,9\s
                """;

        String testString3 ="";


        ByteArrayInputStream stream1 = new ByteArrayInputStream(testString1.getBytes());
        ArrayList<Figure> result1= StreamReader.createFigures(3,stream1);

        ByteArrayInputStream stream2 = new ByteArrayInputStream(testString2.getBytes());
        assertThrows(Exception.class,()-> StreamReader.createFigures(stream2));

        ByteArrayInputStream stream3 = new ByteArrayInputStream(testString3.getBytes());
        assertTrue(StreamReader.createFigures(0,stream3).isEmpty());

        stream1.reset();
        ArrayList<Figure> result2= StreamReader.createFigures(1,stream1);

        assertEquals("triangle 3.0 4.0 5.0",result1.get(0).toString());
        assertEquals("circle 10.7",result1.get(1).toString());
        assertEquals("rectangle 7.9 10.0",result1.get(2).toString());
        assertEquals(3,result1.size());

        assertEquals(1,result2.size());
        assertEquals("triangle 3.0 4.0 5.0",result2.get(0).toString());

    }
}
package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RandomReaderTest {

    @Test
    void testCreateFigures() {

        assertTrue(RandomReader.createFigures(0).isEmpty());
        assertTrue(RandomReader.createFigures(-10).isEmpty());

        assertEquals(10, RandomReader.createFigures(10).size());
        assertEquals(1, RandomReader.createFigures(1).size());

    }
}
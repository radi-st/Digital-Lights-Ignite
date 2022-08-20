package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MathTest {

    @Test
    void testFibbonachiValidParameters() {
        assertAll("Base Conditions",
                () -> assertEquals(0, Math.fibbonachi(0)),
                () -> assertEquals(1, Math.fibbonachi(1))
                );
        assertAll("Generic",
                () -> assertEquals(1, Math.fibbonachi(2)),
                () -> assertEquals(Math.fibbonachi(98)+Math.fibbonachi(99), Math.fibbonachi(100)),
                () -> assertEquals(2,Math.fibbonachi(3)),
                () -> assertEquals(3,Math.fibbonachi(4)),
                () -> assertEquals(5,Math.fibbonachi(5)));
    }

    @Test
    void testFibbonachiInvalidParameters() {
        assertEquals(-1, Math.fibbonachi(-1));
        assertEquals(-1, Math.fibbonachi(-100));
    }

    @Test
    void testFactorialValidParameters() {
        assertAll("Base Conditions",
                () -> assertEquals(1, Math.factorial(0)),
                () -> assertEquals(1, Math.factorial(1))
        );
        assertAll("Generic",
                () -> assertEquals(Math.factorial(99)*100, Math.factorial(100)),
                () -> assertEquals(2,Math.factorial(2)),
                () -> assertEquals(6,Math.factorial(3)),
                () -> assertEquals(120,Math.factorial(5)));
    }

    @Test
    void testFactorialInvalidParameters() {
        assertEquals(-1, Math.fibbonachi(-1));
        assertEquals(-1, Math.fibbonachi(-100));
    }

}
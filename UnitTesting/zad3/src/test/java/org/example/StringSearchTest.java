package org.example;

import static org.junit.jupiter.api.Assertions.*;

class StringSearchAlgorithmTest {
    static void AlgorithmTest(StringSearch s){
        assertAll("Empty string is a substring of any string",
                ()->assertEquals(0,s.positionOf("","")),
                ()->assertEquals(0,s.positionOf("","asbjhfsl")),
                ()->assertEquals(0,s.positionOf(""," 80328eWoihd92o"))
                );
        assertAll("Position of substring is accurately found in the beginning of the string.",
                ()->assertEquals(0,s.positionOf("a","abcdefg")),
                ()->assertEquals(0,s.positionOf("aB","aBbjhfsl")),
                ()->assertEquals(0,s.positionOf("D8","D80328ewoihd92o"))
        );
        assertAll("Position of substring is accurately found in the middle of the string.",
                ()->assertEquals(3,s.positionOf("d","abcdefg")),
                ()->assertEquals(3,s.positionOf("JfH","asbJfHfsl")),
                ()->assertEquals(5,s.positionOf("8ewo"," 80328ewoihd92o")),
                ()->assertEquals(8,s.positionOf(" ","80328ewo ihd92o"))
        );
        assertAll("Position of substring is accurately found in the end of the string.",
                ()->assertEquals(11,s.positionOf(" ","abdsaohowih ")),
                ()->assertEquals(2,s.positionOf("9Ghj","aS9Ghj")),
                ()->assertEquals(8,s.positionOf("a"," 80328ewa"))
        );
        assertAll("Position of a non-substring is -1",
                ()->assertEquals(-1,s.positionOf(" ","")),
                ()->assertEquals(-1,s.positionOf("a","")),
                ()->assertEquals(-1,s.positionOf("A","abdcefg")),
                ()->assertEquals(-1,s.positionOf("eWo"," 80328ewoihd92o")),
                ()->assertEquals(-1,s.positionOf("Cd0","dnaipsjapocD0"))

        );
    }
}
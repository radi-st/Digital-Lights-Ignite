package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CarTest {
    @Test
    void CarConstructorValidPropertiesAreCorrectlySet() throws Exception {
        Car c1 = new Car(" ", 0);
        Car c2 = new Car("8904789739", 1);
        Car c3 = new Car("abdjsfoie", 1000.9);
        Car c4 = new Car("2187udi3h298hd90", 20.5);


        assertAll("Registration is correctly set",
                () -> assertEquals(" ", c1.getRegistration()),
                () -> assertEquals("8904789739", c2.getRegistration()),
                () -> assertEquals("abdjsfoie", c3.getRegistration()),
                () -> assertEquals("2187udi3h298hd90", c4.getRegistration()));

        assertAll("Engine size is correctly set",
                () -> assertEquals(0, c1.getEngineSize()),
                () -> assertEquals(1, c2.getEngineSize()),
                () -> assertEquals(1000.9, c3.getEngineSize()),
                () -> assertEquals(20.5, c4.getEngineSize()));
    }

    @Test
    void CarConstructorInvalidPropertiesThrow() throws Exception {

        assertAll("Invalid engine size throws",
                () -> assertThrows(Exception.class,
                        () -> new Car("", -1),
                        "Engine size cannot be a negative number!"),
                () -> assertThrows(Exception.class,
                        () -> new Car("23rfwfr32", -0.1),
                        "Engine size cannot be a negative number!"),
                () -> assertThrows(Exception.class,
                        () -> new Car("1212423", -1000.8),
                        "Engine size cannot be a negative number!"),
                () -> assertThrows(Exception.class,
                        () -> new Car("sedadwergsves", -1/3),
                        "Engine size cannot be a negative number!")
        );
    }

    @Test
    void ConsumptionIsCorrectlyCalculated() throws Exception {
        Car c1 = new Car(" ", 0);
        Car c2 = new Car("8904789739", 1);
        Car c3 = new Car("abdjsfoie", 1000.9);
        Car c4 = new Car("2187udi3h298hd90", 20.5);

        assertEquals(0, c1.getConsumption());
        assertEquals(c2.getEngineSize()*3,c2.getConsumption());
        assertEquals(3002.7,c3.getConsumption());
        assertEquals(20.5*3,c4.getConsumption());
    }
}

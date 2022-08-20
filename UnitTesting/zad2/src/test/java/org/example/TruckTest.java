package org.example;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class TruckTest {

    @Test
    void TruckConstructorValidPropertiesAreCorrectlySet() throws Exception {
        Truck t1= new Truck("", 1000, 20);
        Truck t2= new Truck("01293021", 3000, 3000);
        Truck t3= new Truck("dabjahsialj", 5000, 4999.5);
        Truck t4= new Truck("012k3ka03ko", 0, 0);

        assertAll("Registration is correctly set",
                ()->assertEquals("", t1.getRegistration()),
                ()->assertEquals("01293021", t2.getRegistration()),
                ()->assertEquals("dabjahsialj", t3.getRegistration()),
                ()->assertEquals("012k3ka03ko", t4.getRegistration()));

        assertAll("Max weight is correctly set",
                ()->assertEquals(1000, t1.getMaxWeight()),
                ()->assertEquals(3000, t2.getMaxWeight()),
                ()->assertEquals(5000, t3.getMaxWeight()),
                ()->assertEquals(0, t4.getMaxWeight()));

        assertAll("Current weight is correctly set",
                ()->assertEquals(20, t1.getCurrWeight()),
                ()->assertEquals(3000, t2.getCurrWeight()),
                ()->assertEquals(4999.5, t3.getCurrWeight()),
                ()->assertEquals(0, t4.getCurrWeight()));
    }

    @Test
    void TruckConstructorTestInvalidParametersThrow() throws Exception{

        assertThrows(Exception.class,
                ()-> new Truck("", 2999.5, 3000),
                "Current weight is more than max weight!" );
        assertThrows(Exception.class,
                ()-> new Truck(" ", 0, 1),
                "Current weight is more than max weight!");
        assertThrows(Exception.class,
                ()->new Truck("01293021", 0, -1),
                "Current weight cannot be a negative number!");
        assertThrows(Exception.class,
                ()-> new Truck("dabjahsialj", -1000, -1000.5),
                "Max weight cannot be a negative number!");
        assertThrows(Exception.class,
                ()->new Truck("d12312ddw", -1000, -999),
                "Max weight cannot be a negative number!");
        assertThrows(Exception.class,
                ()->new Truck("012k3ka03ko", 1000, -10),
                "Current weight cannot be a negative number!");
    }

    @Test
    void ConsumptionIsCorrectlyCalculated() throws Exception {
        Truck t1= new Truck("", 1000, 20);
        Truck t2= new Truck("01293021", 80, 80);
        Truck t3= new Truck("dabjahsialj", 5000, 4999.57);
        Truck t4= new Truck("012k3ka03ko", 0, 0);

        assertEquals(10+20.0/100, t1.getConsumption());
        assertEquals(10+t2.getCurrWeight()/100,t2.getConsumption());
        assertEquals(59.9957,t3.getConsumption());
        assertEquals(10+t4.getCurrWeight()/100,t4.getConsumption());
    }
}

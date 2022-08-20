package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GarageTest {

    Garage g0,g1,g2,g3;
    @BeforeEach
    void init() throws Exception{
        Garage g0=new Garage();

        Garage g1=new Garage();
        g1.addVehicle(new Truck("012k3ka03ko", 0, 0));

        Garage g2=new Garage();
        g2.addVehicle(new Car("8904789739", 1));
        g2.addVehicle(new Car("abdjsfoie", 1000.9));
        g2.addVehicle(new Car("2187udi3h298hd90", 20.5));

        Garage g3=new Garage();
        g3.addVehicle(new Truck("", 1000, 20));
        g3.addVehicle(new Car("abdjsfoie", 1000.9));
    }

    @Test
    void NumberOfVehiclesCountsCorrectly() throws Exception{
        assertEquals(0,g0.numberOfVehicles());
        assertEquals(1,g1.numberOfVehicles());
        assertEquals(3,g2.numberOfVehicles());
        assertEquals(2,g3.numberOfVehicles());
    }

    @Test
    void VehicleAtReturnsCorrectVehicle() throws Exception {

        assertAll("Invalid indexes throw",
                ()->assertThrows(Exception.class,()->g0.vehicleAt(0),"Invalid index!"),
                ()->assertThrows(Exception.class,()->g1.vehicleAt(-1),"Invalid index!"),
                ()->assertThrows(Exception.class,()->g3.vehicleAt(2),"Invalid index!"),
                ()->assertThrows(Exception.class,()->g2.vehicleAt(3),"Invalid index!"));

        Truck v1= (Truck)g1.vehicleAt(0);
        Car v2= (Car)g3.vehicleAt(1);
        Car v3=(Car)g2.vehicleAt(1);

        assertAll("Index 0 - First element",
                ()->assertEquals("012k3ka03ko", v1.getRegistration()),
                ()->assertEquals(0,v1.getMaxWeight()),
                ()->assertEquals(0,v1.getCurrWeight()));

        assertAll("Last element",
                ()->assertEquals("abdjsfoie", v2.getRegistration()),
                ()->assertEquals(1000.9,v2.getEngineSize()));
        assertAll("Between element",
                ()->assertEquals("abdjsfoie", v3.getRegistration()),
                ()->assertEquals(1000.9,v3.getEngineSize())
                );
    }

    @Test
    void AddVehicleAddsTheCorrectVehicle() throws Exception{
        g0.addVehicle(new Car("01234567", 20.5));
        Car v1=(Car)g0.vehicleAt(0);

        g2.addVehicle(new Truck("adewfeg43fes", 30,29.1));
        Truck v2=(Truck)g2.vehicleAt(3);

        assertAll("Ann an empty garage",
                ()->assertEquals(1,g0.numberOfVehicles()),
                ()->assertEquals("01234567", v1.getRegistration()),
                ()->assertEquals(20.5,v1.getEngineSize())
                );

        assertAll("Add in a garage with 3 cars beforehand",
                ()->assertEquals(1,g2.numberOfVehicles()),
                ()->assertEquals("adewfeg43fes", v2.getRegistration()),
                ()->assertEquals(30,v2.getMaxWeight()),
                ()->assertEquals(29.1,v2.getCurrWeight())
        );
    }

    @Test
    void AverageConsumptionIsCalculatedCorrectly(){
        assertEquals(0,g0.averageConsumption());
        assertEquals(10,g1.averageConsumption());
        assertEquals(1+1000.9+20.5,g2.averageConsumption());
        assertEquals((10+20.0/100+1000.9*3)/2,g3.averageConsumption());
    }
}
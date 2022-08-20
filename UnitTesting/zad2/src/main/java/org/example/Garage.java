package org.example;

import java.util.ArrayList;

class Garage{
    private ArrayList<Vehicle> vehicles;

    public void addVehicle(Vehicle v){
        vehicles.add(v);
    }

    public double averageConsumption() {
        double result = 0;
        for (Vehicle v: vehicles) {
            result += v.getConsumption();
        }
        return result / vehicles.size();
    }

    public int numberOfVehicles(){
        return vehicles.size();
    }

    public Vehicle vehicleAt(int index) throws Exception{
        if(index>=vehicles.size() || index<0){
            throw new Exception ("Invalid index!");
        }
        Vehicle temp=vehicles.get(index);
        if(vehicles.get(index) instanceof Truck){
            return new Truck(temp.getRegistration(),((Truck) temp).getMaxWeight(),((Truck) temp).getCurrWeight());
        }
        if(vehicles.get(index) instanceof Car){
            return new Car(((Car) temp).getRegistration(),((Car) temp).getConsumption());
        }
        return null;
    }
}


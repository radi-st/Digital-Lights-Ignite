package org.example;

class Car extends Vehicle{
    private double engine_size;

    public Car(String registration, double engine_size) throws Exception{
        super(registration);
        setEngineSize(engine_size);
    }

    private void setEngineSize(double engine_size) throws Exception {
        if (engine_size < 0) {
            throw new Exception("Engine size cannot be a negative number!");
        }
        this.engine_size=engine_size;
    }

    public double getEngineSize(){
        return engine_size;
    }
    public double getConsumption(){
        return engine_size*3;
    }
}

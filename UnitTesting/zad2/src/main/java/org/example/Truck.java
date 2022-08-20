package org.example;

class Truck extends Vehicle {
    private double max_weight;
    private double current_weight;

    private void setCurrWeight(double curr_weight) throws Exception {
        if (curr_weight > max_weight) {
            throw new Exception("Current weight is more than max weight!");
        }
        if (curr_weight < 0) {
            throw new Exception("Current weight cannot be a negative number!");
        }

        this.current_weight=curr_weight;
    }

    private void setMaxWeight(double max_weight) throws Exception {
        if (max_weight < 0) {
            throw new Exception("Max weight cannot be a negative number!");
        }
        this.max_weight=max_weight;
    }

    public Truck(String registration, double max_weight, double current_weight) throws Exception {
        super(registration);
        setMaxWeight(max_weight);
        setCurrWeight(current_weight);
    }

    public double getConsumption() {
        return 10 + current_weight / 100;
    }

    public double getMaxWeight() {
        return max_weight;
    }

    public double getCurrWeight() {
        return current_weight;
    }
}


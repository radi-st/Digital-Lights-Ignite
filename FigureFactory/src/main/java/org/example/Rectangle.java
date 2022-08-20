package org.example;
public class Rectangle implements Figure, Cloneable {
    private double side1;
    private double side2;

    public Rectangle(double side1, double side2) throws IllegalArgumentException{
        if(side1<=0 || side2<=0){
            throw new IllegalArgumentException ("Sides must be a positive number!");
        }
        this.side1=side1;
        this.side2=side2;
    }

    @Override
    public double getPerimeter(){
        return 2*(side1+side2);
    }

    @Override
    public String toString(){
        return "rectangle " + Double.toString(side1) + " " + Double.toString(side2);
    }

    @Override
    public Rectangle clone() throws CloneNotSupportedException{
        Rectangle clone=null;
        clone=(Rectangle) super.clone();
        clone.side1=side1;
        clone.side2=side2;
        return clone;
    }
}

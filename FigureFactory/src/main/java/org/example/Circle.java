package org.example;
public class Circle implements Figure, Cloneable{
    private double radius;

    public Circle(double radius) throws IllegalArgumentException{
        if(radius<=0){
            throw new IllegalArgumentException ("Radius must be a positive number!");
        }
        this.radius=radius;
    }

    @Override
    public double getPerimeter(){
        return 2*Math.PI*radius;
    }

    @Override
    public String toString(){
        return "circle " + Double.toString(radius);
    }

    @Override
    public Circle clone() throws CloneNotSupportedException{
        Circle clone=null;
        clone=(Circle) super.clone();
        clone.radius=radius;
        return clone;
    }
}

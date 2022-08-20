package org.example;
public class Triangle implements Figure, Cloneable{
    private double side1;
    private double side2;
    private double side3;

    public Triangle(double side1, double side2, double side3) throws IllegalArgumentException{
        if(side1<=0 || side2<=0 || side3<=0){
            throw new IllegalArgumentException ("Sides must be a positive number!");
        }

        if(side1+side2<=side3 || side1+side3<=side2 || side3+side2<=side1 ) {
            throw new IllegalArgumentException ("The sum of two sides must be greater the the third side!");
        }
        this.side1=side1;
        this.side2=side2;
        this.side3=side3;
    }

    @Override
    public double getPerimeter(){
        return side1+side2+side3;
    }

    @Override
    public String toString(){
        return "triangle " + Double.toString(side1) + " " + Double.toString(side2) + " "+Double.toString(side3);
    }

    @Override
    public Triangle clone() throws CloneNotSupportedException{
        Triangle clone=null;
        clone=(Triangle) super.clone();
        clone.side1=side1;
        clone.side2=side2;
        clone.side3=side3;
        return clone;
    }
}

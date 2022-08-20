package org.example;
public interface Figure {

    public double getPerimeter();
    public String toString();
    public Figure clone()throws CloneNotSupportedException;
}

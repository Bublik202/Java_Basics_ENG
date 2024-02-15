package com.epam.rd.autotasks.figures;

abstract class Figure{

    public abstract Point centroid();
    public abstract boolean isTheSame(Figure figure);
    
    public static double side(Point a, Point b) {
    	return Math.sqrt(Math.pow(b.getX() - a.getX(), 2) + Math.pow(b.getY() - a.getY(), 2));
    };
}

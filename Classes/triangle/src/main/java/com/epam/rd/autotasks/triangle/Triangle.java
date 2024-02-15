package com.epam.rd.autotasks.triangle;

import static java.lang.Math.sqrt;
import static java.lang.StrictMath.pow;

class Triangle {
	private Point a;
	private Point b;
	private Point c;

    public Triangle(Point a, Point b, Point c) {
		this.a = a;
		this.b = b;
		this.c = c;
		
		double AB = length(a, b);
        double BC = length(b, c);
        double AC = length(a, c);
        
        if(AB + BC <= AC || BC + AC <= AB || AC + AB <= BC) {
        	throw new IllegalArgumentException();
        }
		
	}
    
    double length(Point start, Point end) {
    	return sqrt((pow(end.getX() - start.getX(), 2)) + (pow(end.getY() - start.getY(), 2)));
    }

	public double area() {
        double AB = length(a, b);
        double BC = length(b, c);
        double AC = length(a, c);
        
        double s = (AB + BC + AC) / 2;
        
        return sqrt(s * (s - AB) * (s - BC) * (s - AC));
    }

    public Point centroid(){
    	double averageX = (a.getX() + b.getX() + c.getX()) / 3;
        double averageY = (a.getY() + b.getY() + c.getY()) / 3;
        
        return new Point(averageX, averageY);
    }

}

package com.epam.rd.autotasks.segments;

import static java.lang.Math.abs;
import static java.lang.Math.sqrt;
import static java.lang.StrictMath.pow;

class Segment {
	private Point start;
	private Point end; 

    public Segment(Point start, Point end) {	   	
		this.start = start;
		this.end = end;
		
		if(length() == 0) {
			throw new IllegalArgumentException();
		}
	}

	double length() {
    	return sqrt((pow(end.getX() - start.getX(), 2)) + (pow(end.getY() - start.getY(), 2)));
    }

    Point middle() {
    	double x = (start.getX() + end.getX()) / 2;
    	double y = (start.getY() + end.getY()) / 2;		
    	
    	return new Point(x, y);
    }

    Point intersection(Segment another) {
    	double x1 = start.getX();
    	double x2 = end.getX();
    	double x3 = another.start.getX();
    	double x4 = another.end.getX();
    	
    	double y1 = start.getY();
    	double y2 = end.getY();
    	double y3 = another.start.getY();
    	double y4 = another.end.getY();
    	
    	double d = ((x1 - x2) * (y3 - y4) - (y1 - y2) * (x3 - x4));
        
        if (Math.abs(d) < 1.0e-10) //better to compare abs(div) with small Eps
            return null;  //collinear case
        
        double t = ((x1 - x3) * (y3 - y4) - (y1 - y3) * (x3 - x4)) / d;
        double u = ((x1 - x3) * (y1 - y2) - (y1 - y3) * (x1 - x2)) / d;        

        if (t < 0 || t > 1.0)
            return null; //intersection outside the first segment
        if (u < 0 || u > 1.0)  
            return null;  //intersection outside the second segment        
        
        double pX = (x1 + t * (x2 - x1));
        double pY = (y1 + t * (y2 - y1));
       
    	return new Point(pX, pY);
    }

}

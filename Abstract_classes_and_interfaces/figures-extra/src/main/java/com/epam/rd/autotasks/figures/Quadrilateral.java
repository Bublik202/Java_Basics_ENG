package com.epam.rd.autotasks.figures;

class Quadrilateral extends Figure{
	private Point a;
	private Point b;
	private Point c;
	private Point d;

	public Quadrilateral(Point a, Point b, Point c, Point d) {
		super();		
		this.a = a;
		this.b = b;
		this.c = c;
		this.d = d;

		validateQuadrilateral(a, b, c, d);
		
	}
	
	private void validateQuadrilateral(Point a, Point b, Point c, Point d) {
		if (a == null || b == null || c == null || d == null) {
	        throw new IllegalArgumentException("Point is null");
	    }

	    if (!isValidQuadrilateral(a, b, c, d)) {
	        throw new IllegalArgumentException();
	    }
	}
	
	private boolean isValidQuadrilateral(Point a, Point b, Point c, Point d) {
	    double crossProduct1 = crossProduct(b, a, c);
	    double crossProduct2 = crossProduct(c, b, d);
	    double crossProduct3 = crossProduct(d, c, a);
	    double crossProduct4 = crossProduct(a, d, b);

	    return (crossProduct1 > 0 && crossProduct2 > 0 && crossProduct3 > 0 && crossProduct4 > 0) ||
	           (crossProduct1 < 0 && crossProduct2 < 0 && crossProduct3 < 0 && crossProduct4 < 0);
	}
	
	private double crossProduct(Point p1, Point p2, Point p3) {
	    return (p2.getX() - p1.getX()) * (p3.getY() - p1.getY()) -
	           (p2.getY() - p1.getY()) * (p3.getX() - p1.getX());
	}
	
	@Override
	public Point centroid() {
	    Point center1 = new Triangle(a, b, c).centroid();
	    Point center2 = new Triangle(a, c, d).centroid();
	    Point center3 = new Triangle(a, d, b).centroid();
	    Point center4 = new Triangle(b, d, c).centroid();

	    //использовать метод intersection(Point) для нахождения пересечения
	    return intersection(center1, center2, center3, center4);
	}

	// Метод для нахождения пересечения двух отрезков 
	private Point intersection(Point p1, Point p2, Point p3, Point p4) {
	    double x1 = p1.getX(), y1 = p1.getY();
	    double x2 = p2.getX(), y2 = p2.getY();
	    double x3 = p3.getX(), y3 = p3.getY();
	    double x4 = p4.getX(), y4 = p4.getY();

	    double d = (x1 - x2) * (y3 - y4) - (y1 - y2) * (x3 - x4);

	    if (d == 0) {
	        // Отрезки параллельны
	        return null;
	    }

	    double xi = ((x3 - x4) * (x1 * y2 - y1 * x2) - (x1 - x2) * (x3 * y4 - y3 * x4)) / d;
	    double yi = ((y3 - y4) * (x1 * y2 - y1 * x2) - (y1 - y2) * (x3 * y4 - y3 * x4)) / d;

	    return new Point(xi, yi);
	}


	@Override
	public boolean isTheSame(Figure figure) {
		final double DELTA = 1e-15;
		if(figure instanceof Quadrilateral){
            Quadrilateral other = (Quadrilateral) figure;
            if (other.a != a){ // вершины
	            if (a.getX()==other.b.getX()||
	            		b.getX()==other.c.getX()||
	            		c.getX()==other.d.getX()||
	            		d.getX()==other.a.getX()) return true;
	            if (a.getX()==other.b.getX()||
	            		b.getX()==other.a.getX()||
	            		c.getX()==other.d.getX()||
	            		d.getX()==other.c.getX()) return true;
	            if (a.getX()==other.c.getX()||
	            		b.getX()==other.b.getX()||
	            		c.getX()==other.a.getX()||
	            		d.getX()==other.d.getX()) return true;
            }
            if(other.a.getX() != a.getX() || 
            		other.b.getX() != b.getX() || 
            		other.c.getX() != c.getX() || 
            		other.d.getX() != d.getX()) return false;
            if(Math.abs(a.getX() - other.a.getX()) <= DELTA ||
            		(Math.abs(b.getX() - other.b.getX()) <= DELTA) ||
            		(Math.abs(c.getX() - other.c.getX()) <= DELTA) ||
            		(Math.abs(d.getX() - other.d.getX()) <= DELTA)) return true;
        }
        
		return false;
	}

}

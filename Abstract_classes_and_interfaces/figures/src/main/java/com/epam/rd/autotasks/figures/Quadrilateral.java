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
	}

	@Override
	public double area() {
		double p =((side(a, b)+side(b, c)+side(c, a))/2);                
		double abc = Math.sqrt(p*(p-side(a, b))*(p-side(b, c))*(p-side(c, a)));
		
		double p2 = ((side(a, d)+side(d, c)+side(c, a))/2); 
		double cda = Math.sqrt(p2*(p2-side(a, d))*(p2-side(d, c))*(p2-side(c, a)));
		
		return abc + cda;
	}

	@Override
	public String pointsToString() {
		StringBuilder builder = new StringBuilder();
		builder.append("(").append(a.getX()).append(",").append(a.getY()).append(")");
		builder.append("(").append(b.getX()).append(",").append(b.getY()).append(")");
		builder.append("(").append(c.getX()).append(",").append(c.getY()).append(")");
		builder.append("(").append(d.getX()).append(",").append(d.getY()).append(")");
		
		
		return builder.toString();
	}

	@Override
	public Point leftmostPoint() {
		if(a.getX() <= b.getX() && a.getX() <= c.getX() && a.getX() <= d.getX()) {
			return new Point(a.getX(), a.getY());
		}
		if(b.getX() <= a.getX() && b.getX() <= c.getX() && b.getX() <= d.getX()) {
			return new Point(b.getX(), b.getY());
		}
		if(c.getX() <= a.getX() && c.getX() <= b.getX() && c.getX() <= d.getX()) {
			return new Point(c.getX(), c.getY());
		}
		if(d.getX() <= a.getX() && d.getX() <= b.getX() && d.getX() <= c.getX()) {
			return new Point(d.getX(), d.getY());
		}
		
		return new Point(0, 0);
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Quadrilateral[(").append(a.getX()).append(",").append(a.getY()).append(")");
		builder.append("(").append(b.getX()).append(",").append(b.getY()).append(")");
		builder.append("(").append(c.getX()).append(",").append(c.getY()).append(")");
		builder.append("(").append(d.getX()).append(",").append(d.getY()).append(")]");
		
		
		return builder.toString();
	}
	
	
	
}

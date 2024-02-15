package com.epam.rd.autotasks.figures;

class Triangle extends Figure{
	private Point a;
	private Point b;
	private Point c;

	public Triangle(Point a, Point b, Point c) {
		super();
		this.a = a;
		this.b = b;
		this.c = c;
	}

	@Override
	public double area() {		
		return 0.5 * Math.abs(a.getX() * (b.getY() - c.getY()) + b.getX() * (c.getY() - a.getY())
				+ c.getX() * (a.getY() - b.getY()));
	}

	@Override
	public String pointsToString() {
		StringBuilder builder = new StringBuilder();
		builder.append("(").append(a.getX()).append(",").append(a.getY()).append(")");
		builder.append("(").append(b.getX()).append(",").append(b.getY()).append(")");
		builder.append("(").append(c.getX()).append(",").append(c.getY()).append(")");
		
		return builder.toString();
	}

	@Override
	public Point leftmostPoint() {
		if(a.getX() <= b.getX() && a.getX() <= c.getX() ) {
			return new Point(a.getX(), a.getY());
		}
		if(b.getX() <= a.getX() && b.getX() <= c.getX() ) {
			return new Point(b.getX(), b.getY());
		}
		if(c.getX() <= a.getX() && c.getX() <= b.getX() ) {
			return new Point(c.getX(), c.getY());
		}
		
		return new Point(0, 0);
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Triangle[(").append(a.getX()).append(",").append(a.getY()).append(")");
		builder.append("(").append(b.getX()).append(",").append(b.getY()).append(")");
		builder.append("(").append(c.getX()).append(",").append(c.getY()).append(")]");
		
		return builder.toString();
	}
	
	

}

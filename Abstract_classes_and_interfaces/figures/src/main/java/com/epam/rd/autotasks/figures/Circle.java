package com.epam.rd.autotasks.figures;

class Circle extends Figure{
	private Point mid;
	private double radius;

	public Circle(Point mid, double radius) {
		super();
		this.mid = mid;
		this.radius = radius;
	}

	@Override
	public double area() {
		return Math.PI * radius * radius;
	}

	@Override
	public String pointsToString() {
		StringBuilder builder = new StringBuilder();
		builder.append("(").append(mid.getX()).append(",").append(mid.getY()).append(")");		
		
		return builder.toString();
	}

	@Override
	public Point leftmostPoint() {		
		return new Point(mid.getX() - radius, mid.getY());
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Circle[(").append(mid.getX()).append(",").append(mid.getY())
		.append(")").append(radius).append("]");		
		
		return builder.toString();
	}
	
	

}

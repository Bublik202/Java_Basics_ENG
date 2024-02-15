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
		if(a == null || b == null || c == null) {
			throw new IllegalArgumentException();
		}
		if((a.getX() - b.getX()) * (c.getY() - b.getY()) - (a.getY() - b.getY()) * (c.getX() - b.getX()) == 0) {
			throw new IllegalArgumentException();
		}
	}

	@Override
	public Point centroid() {
		double centroidX = (a.getX() + b.getX() + c.getX()) / 3.0;
        double centroidY = (a.getY() + b.getY() + c.getY()) / 3.0;
        return new Point(centroidX, centroidY);
	}

	@Override
	public boolean isTheSame(Figure figure) {
		return false;
	}
}

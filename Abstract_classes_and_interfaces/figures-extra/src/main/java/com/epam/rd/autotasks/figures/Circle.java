package com.epam.rd.autotasks.figures;

class Circle extends Figure{
	private Point mid;
	private double radius;

	public Circle(Point mid, double radius) {
		super();
		this.mid = mid;
		this.radius = radius;
		if(radius <= 0 || mid == null) {
			throw new IllegalArgumentException();
		}
		
	}

	@Override
	public Point centroid() {		
		return new Point(mid.getX(), mid.getY());
	}

	@Override
	public boolean isTheSame(Figure figure) {
		final double DELTA = 1e-15;
		if(figure instanceof Circle){
			Circle circle = (Circle) figure;
			
			if(Math.abs(mid.getX() - circle.mid.getX()) <= DELTA &&
            		(Math.abs(mid.getY() - circle.mid.getY()) <= DELTA) &&
            		(Math.abs(radius - circle.radius) <= DELTA)) return true;			
		}
		return false;
	}
	
}

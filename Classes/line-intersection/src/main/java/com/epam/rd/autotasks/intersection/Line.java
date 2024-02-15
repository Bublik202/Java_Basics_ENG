package com.epam.rd.autotasks.intersection;

public class Line {
	private int k;
	private int b;	

    public Line(int k, int b) {
		super();
		this.k = k;
		this.b = b;
	}
	
	public Point intersection(Line other) {
		int x;
		int y;
		try {
			x = (other.b - this.b) / (this.k - other.k);
			y = this.k * x + this.b;
		} catch (Exception e) {
			return null;
		}
		
		return new Point(x, y);
    }

}

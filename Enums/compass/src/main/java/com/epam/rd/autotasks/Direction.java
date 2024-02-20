package com.epam.rd.autotasks;

public enum Direction {
    N(0), NE(45), E(90), SE(135), S(180), SW(225), W(270), NW(315);

    Direction(final int degrees) {
        this.degrees = degrees;
    }

    private int degrees;

    public static Direction ofDegrees(int degrees) {
    	while(degrees < 0) { 
        	degrees = 360 + degrees;
        }
    	while(degrees >= 360) {
    		degrees = degrees - 360;
    	}        
        
    	for (Direction direction : Direction.values()) {
			if(direction.degrees == degrees) {
				return direction;
			}
		}
        return null;
    }

    public static Direction closestToDegrees(int degrees) {
    	while(degrees < 0) { 
        	degrees = 360 + degrees;
        }
    	
    	while(degrees >= 360) {
    		degrees = degrees - 360;
    	}        
        
        Direction direction = null;
        int value = Integer.MAX_VALUE;
    	for (Direction directions : Direction.values()) {
    		if(directions.degrees == degrees) {
    			return directions;
    		}
    		int x = Math.abs(directions.degrees - degrees);
			if(x < value) {
				value = x;
				direction = directions;
			}
		}
    	return direction;
    	
    }

    public Direction opposite() {
        return ofDegrees(degrees + 180);
    }

    public int differenceDegreesTo(Direction direction) {
//        return direction.degrees > this.degrees ? direction.degrees - this.degrees
//        		: this.degrees - direction.degrees;	
        int value = Math.abs(direction.degrees - this.degrees);
        return Math.min(value, 360 - value);
    }	
}

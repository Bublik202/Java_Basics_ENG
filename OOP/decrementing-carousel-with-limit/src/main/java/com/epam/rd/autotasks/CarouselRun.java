package com.epam.rd.autotasks;

public class CarouselRun {
	private int[] array;
	private int i = 0;

	public CarouselRun(int[] array) {
		this.array = array;
	}
			
    public int next() {
    	if(isFinished()) {
    		return -1;
    	}
    	
    	while(array[i %= array.length] == 0) {  		
    		i++;
    	}
    	return array[i++]--;
    }

    public boolean isFinished() {
        for (int i : array) {
			if(i > 0) {
				return false;
			}
		}
        return true;
    }

}

package com.epam.rd.autotasks;

public class DecrementingCarousel {
	private int capacity;
	private int[] array;
	private int j = 0;
	private boolean check = true;
	
    public DecrementingCarousel(int capacity) {
    	this.capacity = capacity;
    	array = new int[this.capacity];
    }

    public boolean addElement(int element){    	
        for (int i : array) {
			if(i == 0 && element > 0 && check) {
				array[j++] = element;
				return true;
			}
		}
        return false;
    }

    public CarouselRun run(){
    	if(!this.check) {
    		return null;
    	}
    	this.check = false;
    	return new CarouselRun(array);
    }
}

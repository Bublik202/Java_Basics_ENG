package com.epam.rd.autotasks;

public class CountDownTask implements Task{
	private int value;
	private boolean check = false;

    public CountDownTask(int value) {   
        if(value <= 0) {
        	value = 0;
        	check = true;
        }
        this.value = value;
    	
        
    }
    public int getValue() {
		return value;
	}

	@Override
    public void execute() {	
		value--;
		if(value <= 0) {
			value = 0;
			check = true;
		}
    }

    @Override
    public boolean isFinished() {
        return check;
    }
    
}

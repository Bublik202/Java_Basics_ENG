package com.epam.rd.autotasks;

public class CompleteByRequestTask implements Task {
	private boolean check = false;
	private boolean check2 = false;
	
	public CompleteByRequestTask() {
		
	}

    @Override
    public void execute() {
        if(check2) {
        	check = true;
        }
    }

    @Override
    public boolean isFinished() {
        return check;
    }

    public void complete() {
        check2 = true;
    }
    
}

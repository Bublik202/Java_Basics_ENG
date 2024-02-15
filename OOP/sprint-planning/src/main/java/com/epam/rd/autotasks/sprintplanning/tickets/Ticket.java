package com.epam.rd.autotasks.sprintplanning.tickets;

public class Ticket {
	private int id;
	private String name;
	private int estimate;
	protected boolean check = false;

    public Ticket(int id, String name, int estimate) {
		super();
		this.id = id;
		this.name = name;
		this.estimate = estimate;
	}
    
    public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}
	
	public int getEstimate() {
		return estimate;
	}
	
	public boolean isCheck() {
		return check;
	}

	public boolean isCompleted() {
        if(check) {
        	return true;
        }
        return false;
    }

    public void complete() {
        check = true;
    }
    
}

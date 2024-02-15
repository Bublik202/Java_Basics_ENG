package com.epam.rd.autotasks.sprintplanning;

import java.util.Arrays;

import com.epam.rd.autotasks.sprintplanning.tickets.Bug;
import com.epam.rd.autotasks.sprintplanning.tickets.Ticket;
import com.epam.rd.autotasks.sprintplanning.tickets.UserStory;

public class Sprint{
	private int capacity;
	private int tickectsLimit;
	private int totalEstimate;
	private Ticket[] tickets;
	private int i = 0;
	
    public Sprint(int capacity, int tickectsLimit) {
    	super();
		this.capacity = capacity;
		this.tickectsLimit = tickectsLimit;
		this.tickets = new Ticket[tickectsLimit]; 
		this.totalEstimate = 0;
	}  

	public boolean addUserStory(UserStory userStory) {
        if(userStory == null || userStory.isCompleted()) {
        	return false;
        }
        
        for (UserStory dependens : userStory.getDependencies()) {
			if(!checkTickets(dependens)) {
				return false;
			};
		}
        
        
        if(tickectsLimit == 0) {
        	return false;
        }
        
        if(capacity - userStory.getEstimate() < 0) {
    		return false;
    	}
        
        tickets[i++] = userStory;
        tickectsLimit--;
        
        capacity -= userStory.getEstimate();
        totalEstimate += userStory.getEstimate();
        
        return true;
    }

	private boolean checkTickets(UserStory dependens) {
		for (Ticket ticket : tickets) {
			if(dependens.equals(ticket)) {
				return true;
			}
		}
		 return false;
	}

    public boolean addBug(Bug bugReport) {
    	if(bugReport == null) {
        	return false;
        } 	
    	
    	if(bugReport.isCompleted()) {
    		return false;
    	}
    	
    	if(tickectsLimit == 0) {
    		return false;
    	}
    	
    	if(capacity - bugReport.getEstimate() < 0) {
    		return false;
    	}
    	
    	tickets[i++] = bugReport;
        tickectsLimit--;
        
        capacity -= bugReport.getEstimate();
        totalEstimate += bugReport.getEstimate();
    	
    	return true;
    }

    public Ticket[] getTickets() {
    	int count = 0;
    	for (Ticket ticket : tickets) {
			if(ticket != null) {
				count++;
			}
		}
        return Arrays.copyOf(tickets, count);
    }

    public int getTotalEstimate() {
    	return totalEstimate;
    }
}

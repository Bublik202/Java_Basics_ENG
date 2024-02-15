package com.epam.rd.autotasks.sprintplanning.tickets;

import java.util.Arrays;

public class UserStory extends Ticket {
	private UserStory[] dependsOn;

    public UserStory(int id, String name, int estimate, UserStory... dependsOn) {
        super(id, name, estimate);
        this.dependsOn = dependsOn;
    }

    @Override
    public void complete() {
    	check = true;
    	for (UserStory userStory : dependsOn) {
    		if(!userStory.isCompleted()) {
        		check = false;
        	}
		}
                
    }

    public UserStory[] getDependencies() {
        return Arrays.copyOf(dependsOn, dependsOn.length);
    }

    @Override
    public String toString() {
    	StringBuilder builder = new StringBuilder();
    	builder.append("[US ").append(getId()).append("] ")
    	.append(getName());
    	
        return builder.toString();
    }
}

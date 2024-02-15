package com.epam.rd.autotasks.sprintplanning.tickets;

public class Bug extends Ticket {
	private UserStory userStory;
	
	private Bug(int id, String name, int estimate, UserStory userStory) {
        super(id, name, estimate);
        this.userStory = userStory;
    }

    public static Bug createBug(int id, String name, int estimate, UserStory userStory) {
    	if(!userStory.isCompleted() || userStory == null) {
    		return null;
    	} 	
    	return new Bug(id, name, estimate, userStory);
        
    }

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("[Bug ").append(getId()).append("] ")
		.append(userStory.getName()).append(":").append(" ").append(getName());
		return builder.toString();
	}

}

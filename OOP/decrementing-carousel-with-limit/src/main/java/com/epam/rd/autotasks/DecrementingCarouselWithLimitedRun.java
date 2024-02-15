package com.epam.rd.autotasks;

public class DecrementingCarouselWithLimitedRun extends DecrementingCarousel{
	private int count = 0;
	private int actionLimit;
	
    public DecrementingCarouselWithLimitedRun(final int capacity, final int actionLimit) {
        super(capacity);
        this.actionLimit = actionLimit;
    }
    
    @Override
	public CarouselRun run() {
		if(check) {
			check = false;
	    	return new CarouselRun(array) {
	    		@Override
				public int next() {		    			
	    			if(isFinished()) {
			    		return -1;
			    	}
			    	
			    	while(array[j %= array.length] == 0) {			    		
			    		j++;
			    	}
			    	
			    	actionLimit -= 1;
	    			return array[j++]--;
				}

	    		@Override
	    		public boolean isFinished() {
	    			if(actionLimit != 0) {
	    				for (int i : array) {
		    				if(i > 0) {
		    					return false;
		    				}
		    			}
	    			}
	    	        return true;
	    		}				
	    		
	    	};
		}
		return super.run();
	}
}

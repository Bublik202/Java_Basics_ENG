package com.epam.rd.autotasks;

public class GraduallyDecreasingCarousel extends DecrementingCarousel{

    public GraduallyDecreasingCarousel(final int capacity) {
        super(capacity);
    }
    
    @Override
	public CarouselRun run() {
		if(check) {
			check = false;
	    	return new CarouselRun(array) {
	    		int count = 0;
	    		@Override
				public int next() {					
					int num;					
					if(isFinished()) {
			    		return -1;
			    	}
			    	
					int value = j;
			    	while(array[j %= array.length] <= 0) {			    		
			    		j++;
			    	}
			    	
			    	if(value > j) {
			    		count++;
			    	}
			    	
			    	num = array[j];
					array[j++] -= count;
					return num;
				}

	    		@Override
	    		public boolean isFinished() {
	    			for (int i : array) {
	    				if(i > 0) {
	    					return false;
	    				}
	    			}
	    	        return true;
	    		}				
	    		
	    	};
		}
		return super.run();
	}
}

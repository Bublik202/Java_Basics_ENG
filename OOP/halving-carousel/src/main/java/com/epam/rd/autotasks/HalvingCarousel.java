package com.epam.rd.autotasks;

public class HalvingCarousel extends DecrementingCarousel {

    public HalvingCarousel(final int capacity) {
        super(capacity);
    }

	@Override
	public CarouselRun run() {
		if(check) {
			check = false;
	    	return new CarouselRun(array) {

	    		@Override
				public int next() {					
					int num;
					if(isFinished()) {
			    		return -1;
			    	}
			    	
			    	while(array[j %= array.length] == 0) {			    		
			    		j++;
			    	}					
					num = array[j];
					array[j] = array[j++]-- /2;
					
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

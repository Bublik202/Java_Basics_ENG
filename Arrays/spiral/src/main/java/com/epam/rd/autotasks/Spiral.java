package com.epam.rd.autotasks;

class Spiral {
    static int[][] spiral(int rows, int columns) {
    	int[][] array = new int[rows][columns];
    	int value = 1;
    	int countRows = 1;
    	int countColumns = 1;
    	
    	for (int j = 0; j < columns; j++) {
			array[0][j] = value++;												
		}
    	
    	boolean check = true;    	
    	while(check) {
    		for (int i = 0; i < array.length; i++) {
        		if(array[i][columns-countColumns] == 0) {
        			array[i][columns-countColumns] = value++;
        		}
        			
    		}
    		
        	countColumns++;
        	for (int i = rows-countRows; i > 0; i--) {
    			for (int j = columns-countColumns; j >= 0; j--) {
    				if(array[i][j] == 0) {
    					if(i == rows-countRows) {
    						array[i][j] = value++;
    					}
    				}
    								
    			}
    		}
        	
        	for (int i = rows-countRows; i > 0; i--) {
    			if(array[i][0] == 0) {
        			array[i][0] = value++;
        		}		  				
    		} 
        	
        	countColumns--;
        	
        	for (int i = 0; i < rows-countRows; i++) {
    			for (int j = 0; j < columns-countColumns; j++) {
    				if(array[i][j] == 0) {
    					if(i == countRows) {
    						array[i][j] = value++;
    					}					
    				}
    			}
    		}
        	
        	countRows++;
        	countColumns++;
        	
        	check = check(array, check);
    	}
        return array;
    }

	private static boolean check(int[][] array, boolean check) {
		for (int[] is : array) {
			for (int is2 : is) {
				if(is2 == 0) {					
					return check;
				}					
			}
		}
		return false;
	}
}

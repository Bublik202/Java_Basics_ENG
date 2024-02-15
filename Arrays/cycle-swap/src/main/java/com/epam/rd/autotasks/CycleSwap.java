package com.epam.rd.autotasks;

class CycleSwap {
    static void cycleSwap(int[] array) {
    	if (array == null || array.length == 0) {
            System.out.println("null");
        } else {
        	int[] resultArray = new int[array.length];
        	System.arraycopy(array, 0, resultArray, 1, array.length-1);
        	resultArray[0] = array[array.length - 1];
        	System.arraycopy(resultArray, 0, array, 0, array.length);
        }
    	
    }

    static void cycleSwap(int[] array, int shift) {
    	if (array == null || array.length == 0) {
            System.out.println("null");
        } else {
        	if(array.length != shift) {
        		while(shift != 0) {
            		shift--;
            		int[] resultArray = new int[array.length];
                	System.arraycopy(array, 0, resultArray, 1, array.length-1);
                	resultArray[0] = array[array.length - 1];
                	System.arraycopy(resultArray, 0, array, 0, array.length);
            	}
        	}
        }
    	
    	
    	
    }
}

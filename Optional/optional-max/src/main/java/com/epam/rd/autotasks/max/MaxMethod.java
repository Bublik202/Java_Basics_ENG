package com.epam.rd.autotasks.max;

import java.util.OptionalInt;

public class MaxMethod {
    public static OptionalInt max(int[] values) {   	
    	if(values == null || values.length == 0) {
    		return OptionalInt.empty();
    	}
    	
    	int max = Integer.MIN_VALUE;
    	for (int i : values) {
			if(i > max) {
				max =  i;
			}
		}
    	return OptionalInt.of(max);
        
    }
}

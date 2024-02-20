package com.rpam.rd.autotasks;

import java.io.FileNotFoundException;
import java.io.IOException;

public class CatchEmAll {
    static Exception exception = new FileNotFoundException();

    public static void riskyMethod() throws Exception {
        throw exception;
    }

    public static void main(String[] args) throws Exception {
    	try {
    		riskyMethod();	    					
		} catch (NumberFormatException | ArithmeticException e) {
			System.err.println(e.getLocalizedMessage());
		} catch (FileNotFoundException e) {
			throw new IllegalArgumentException("Resource is missing", e);
		} catch (IOException e) {
			throw new IllegalArgumentException("Resource error", e);  
		}
    }
}

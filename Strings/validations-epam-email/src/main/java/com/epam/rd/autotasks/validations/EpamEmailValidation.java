package com.epam.rd.autotasks.validations;

import java.util.regex.Pattern;

public class EpamEmailValidation {

    public static boolean validateEpamEmail(String email) {       
    	if(email == null) {
    		return false;
    	}
    	String path = "\\w+_\\w+@epam.com";
    	return Pattern.matches(path, email);
    }
}


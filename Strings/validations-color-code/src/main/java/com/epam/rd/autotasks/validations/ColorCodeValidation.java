package com.epam.rd.autotasks.validations;

import java.util.regex.Pattern;

public class ColorCodeValidation {
    public static boolean validateColorCode(String color) {
    	if(color == null) {
    		return false;
    	}
    	String path = "^#([a-fA-F\\d]{3}){1,2}";
    	return Pattern.matches(path, color);

    }
}

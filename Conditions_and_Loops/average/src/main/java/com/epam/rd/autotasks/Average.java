package com.epam.rd.autotasks;

import java.util.Scanner;

public class Average {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int count = 0;
        int result = 0;
        boolean check = true;
        
        while(check) {
        	int value = scanner.nextInt();
        	
        	if(value == 0) {      		
        		result /= count;
        		System.out.println(result);
        		check = false;
        	}
        	
        	result += value;
        	count++;
        }

    }

}
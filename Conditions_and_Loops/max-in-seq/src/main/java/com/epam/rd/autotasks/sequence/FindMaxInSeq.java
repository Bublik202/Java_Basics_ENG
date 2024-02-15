package com.epam.rd.autotasks.sequence;
import java.util.Scanner;

public class FindMaxInSeq {
    public static int max() {
    	int max = Integer.MIN_VALUE;
        Scanner scan = new Scanner(System.in);       
        while(max != 0) {
        	int value = scan.nextInt();
        	if(value == 0) {
        		return max;
        	}
        	if(value > max) {
            	max = value;
            }
        }        

        return max;
    }

    public static void main(String[] args) {
        System.out.println("Test your code here!\n");

        int result = max();
        System.out.println(result);
    }
}

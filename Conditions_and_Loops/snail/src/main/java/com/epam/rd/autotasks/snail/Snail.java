package com.epam.rd.autotasks.snail;

import java.util.Scanner;

public class Snail
{
    public static void main(String[] args)
    {     
    	Scanner scan = new Scanner(System.in);
    	int a = scan.nextInt();
    	int b = scan.nextInt();
    	int h = scan.nextInt();
    	
    	int nowHight = 0;
    	int days = 0;   	
    	if(a > b) {
    		while(nowHight <= h) {
    			nowHight += a;
    			days++;
    			if(nowHight >= h) {
    				System.out.println(days);
    				break;
    			}    			
    			nowHight -= b; 			
    		}   		
    	}    	
    	if(a <= b) {
    		System.out.println("Impossible");
    	}
    	if(b >= a && a >= h) {
    		System.out.println("1");
    	}
    	
    	
    }
}

package com.epam.rd.autotasks.godutch;

import java.util.Scanner;

public class GoDutch {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int Bill = scan.nextInt();
        int countFriends = scan.nextInt();
        int result = 0;
        
        if(countFriends > 0 && Bill >= 0) {
        	int precent = Bill / 10;
            result = (Bill + precent) / countFriends;
        	System.out.println(result);
        }
        if(countFriends <= 0) {
        	System.out.println("Number of friends cannot be negative or zero");
        }
        if(Bill < 0) {
        	System.out.println("Bill total amount cannot be negative");
        }
       
    }
}

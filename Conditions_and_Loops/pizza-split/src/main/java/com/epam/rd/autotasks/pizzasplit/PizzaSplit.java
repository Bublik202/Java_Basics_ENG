package com.epam.rd.autotasks.pizzasplit;

import java.util.Scanner;

public class PizzaSplit {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int people = scan.nextInt();
        int piecesPizza = scan.nextInt();
        int past = piecesPizza;
        int countPizza = 1;
        
        while(piecesPizza % people != 0) {
        	piecesPizza += past;
        	countPizza++;
        }
        System.out.println(countPizza);      
        
    }
}

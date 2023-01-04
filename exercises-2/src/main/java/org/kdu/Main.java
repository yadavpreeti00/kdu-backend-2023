package org.kdu;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc=new Scanner(System.in);
        int ans1 = 0,ans2=0,ans3=0;

        System.out.println("Let's start the test!");

        //question1
        System.out.println("What is 2+2 ?");
        try {
            ans1=sc.nextInt();
        } catch (InputMismatchException e) {
            e.printStackTrace();
            System.err.println("The answer is an Integer");
        }

        //question2
        System.out.println("What is 2 to the power 4 ?");
        try {
            ans2=sc.nextInt();
        } catch (InputMismatchException e) {
            e.printStackTrace();
            System.err.println("The answer is an Integer");
        }

        //question3
        System.out.println("What is 10-0 ?");
        try {
            ans3=sc.nextInt();
        } catch (InputMismatchException e) {
            e.printStackTrace();
            System.err.println("The answer is an Integer");
        }

        int score=0;
        if(ans1==4){
            score++;
        }
        if(ans2==16){
            score++;
        }
        if(ans3==10){
            score++;
        }
        sc.close();

        Result obj1=new Result();
        obj1.printResult(score);

    }
}
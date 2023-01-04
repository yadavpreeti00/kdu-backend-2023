package org.kdu;
import java.util.*;
import java.lang.String;


public class Main {
    public static void main(String[] args) {

        Scanner sc=new Scanner(System.in);
        String input;
        input=sc.next();
        int number;
        int odd=0,even=0;
        for(int i=0;i<input.length();i++)
        {
            char c=input.charAt(i);
            number=c -'0';

            if(number%2==1)
            {
                odd++;
            }
            else{
                even++;
            }
        }
        System.out.println("Even: " + even +" , Odd: "+ odd);
        sc.close();
    }
}
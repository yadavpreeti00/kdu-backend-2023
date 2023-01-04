package org.kdu;

public class Result {

    public void printResult(int score){
        if(score==0){
            System.out.println("Ooops your score is 0/3 ! Need to work hard.");
        }
        else if(score==1){
            System.out.println("Need to improve, your score is 1/3");
        }
        else if(score==2){
            System.out.println("So Close! Your score is 2/3...Try Again");
        }
        else if(score==3){
            System.out.println("Excellent! Your score is 3/3");
        }
    }
}

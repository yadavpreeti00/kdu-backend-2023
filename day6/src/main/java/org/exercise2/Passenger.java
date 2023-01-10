package org.exercise2;

public class Passenger {

    String firstName;
    String lastName;
    int age;
    String gender;
    String travelClass;
    String confirmationNumber;

    Passenger(String firstName, String lastName,int age,String gender,String travelClass,String confirmationNumber) {
        this.firstName=firstName;
        this.lastName=lastName;
        this.age=age;
        this.travelClass=travelClass;
        this.confirmationNumber=confirmationNumber;
    }
//    public static void main(String[] args){
//
//        Passenger p1=new Passenger("Preeti","Yadav",21,"female","economy","C9");
//    }
}
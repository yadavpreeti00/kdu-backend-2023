package org.exercise1;



// class representing custom exception
public class MissingGradeException extends Exception{

    private int studentId;
    public int getStudentId() {
        return studentId;
    }

    public MissingGradeException(int studentId){

        super(studentId+" Should first get all the grades");
        this.studentId=studentId;
    }


}



package org.question1;

import java.util.ArrayList;

public class StudentUtil {

    public static double[] calculateGPA(int[] studentIdList, char[][] studentsGrades) {
        // your code

        int student_count=studentIdList.length;
        double[] gpa_values=new double[student_count];
        double gpa=0.0;
        int course_count=0;

        int i=0,j=0;
        int num_grade=0;
        for(int student: studentIdList)
        {
            course_count=0;
            gpa=0.0;
            for(char grade: studentsGrades[j++])
            {
                if(grade=='A')
                {
                    num_grade=4;
                }
                else if(grade=='B')
                {
                    num_grade=3;
                }
                else if(grade=='C')
                {
                    num_grade=2;
                }
                gpa+=num_grade;
                course_count++;
            }
            gpa/=course_count;
            gpa_values[i++]=gpa;
            System.out.println(gpa+" "+course_count);
        }
        return gpa_values;
    }

    public static int[] getStudentsByGPA(double lower, double higher, int[] studentIdList, char[][] studentsGrades) {
        // perform parameter validation. Return null if passed parameters are not valid
        if(lower<0 || higher<0 || lower>higher)
        {
            return null;
        }

        double gpa[]=calculateGPA(studentIdList,studentsGrades);
        // invoke calculateGPA


        // construct the result array and return it. You would need an extra for loop to compute the size of the resulting array

        int size=0;
        for(double num:gpa)
        {
            if(num>=lower && num<=higher)
            {
                size++;
            }
        }
        int[] studentBygpa=new int[size];

        int j=0,i=0;
        for(double num:gpa)
        {
            if(num>=lower && num<=higher)
            {
                studentBygpa[j++] = studentIdList[i];
            }
            i++;
        }
        return studentBygpa;
    }

    public static void main(String[] args){

        double lower=3.2;
        double higher=3.5;
        int[] studentIdList={1001,1002};
        char[][] studentsGrades={ { 'A', 'A', 'A', 'B' }, { 'A', 'B', 'B' } };

        int[] result=getStudentsByGPA(lower,higher,studentIdList,studentsGrades);

        for(int i:result)
        {
            System.out.println(i);
        }

    }

}
package org.exercise1;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;

import java.util.ArrayList;

public class StudentUtil {

    private static final Logger logger =LoggerFactory.getLogger(StudentUtil.class);

    public static double[] calculateGPA(int[] studentIdList, char[][] studentsGrades) throws MissingGradeException{
        // your code
        // Your code: throw IllegalArgumentException with the message that lengths of input arrays are out-of-sync
        int studentIdListSize=studentIdList.length;
        int studentsGradesSize=studentsGrades.length;

        //parameter validation
        try {
            if (studentIdListSize != studentsGradesSize) {
                throw new IllegalArgumentException();
            }
        }
        catch(IllegalArgumentException e){
            System.out.println("studentIdList & studentsGrades are out-of-sync. studentIdList.length: " + studentIdListSize + ", studentsGrades.length: " + studentsGradesSize);
            logger.info("studentIdListLength: "+studentIdListSize+" studentGradeslength "+studentsGradesSize);
        }

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
                else if (grade == ' ') {


                    throw new MissingGradeException(student);
                    // student is yet to receive a grade
                    // Your code: throw checked exception MissingGradeException with student ID
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

        double gpa[]= new double[studentIdList.length];
        try {
            gpa = calculateGPA(studentIdList,studentsGrades);
        } catch (MissingGradeException e) {
            throw new InvalidDataException("Invalid data",e);
        }

        // Your code: catch MissingGradeException and re-throw runtime exception InvalidDataException initialized with the cause MissingGradeException


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
        char[][] studentsGrades={ { 'A', 'A', 'A', 'B' },{'A',' '}};


        int[] result=getStudentsByGPA(lower,higher,studentIdList,studentsGrades);

        for(int i:result)
        {
            System.out.println(i);
            logger.info(String.valueOf(i));
        }

    }

}
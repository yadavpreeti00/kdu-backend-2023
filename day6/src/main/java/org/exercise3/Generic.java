package org.exercise3;

import org.exercise2.TicketReservation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;

public class Generic {

    private static final Logger logger = LoggerFactory.getLogger(TicketReservation.class);
    public static <T> void swap(T[] inputArray) {

        T temp=inputArray[0];
        inputArray[0]=inputArray[1];
        inputArray[1]=temp;
    }

//    public static <T> void printArray(T[] inputArray) {
//
//        for (T element : inputArray)
//            System.out.printf(String.valueOf(element)+" ");
//
//        System.out.println();
//    }

    public static void main(String args[]) {

        Integer[] integerArray = { 1, 2, 3, 4, 5, 6 };
        Double[] doubleArray = { 1.1, 2.2, 3.3, 4.4, 5.5, 6.6, 7.7 };
        Character[] characterArray = { 'P','R','E','E','T','I'};

        logger.info(Arrays.toString(integerArray));
        swap(integerArray);
        logger.info(Arrays.toString(integerArray));

        logger.info(Arrays.toString(doubleArray));
        swap(doubleArray);
        logger.info(Arrays.toString(doubleArray));

        logger.info(Arrays.toString(characterArray));
        swap(characterArray);
        logger.info(Arrays.toString(characterArray));
    }
}

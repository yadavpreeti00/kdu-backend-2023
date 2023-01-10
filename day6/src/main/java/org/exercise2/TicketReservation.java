package org.exercise2;

import org.exercise1.MissingGradeException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.Iterator;
import java.util.List;

public class TicketReservation {

    private static final Logger logger = LoggerFactory.getLogger(TicketReservation.class);

    private static final int CONFIRMEDLIST_LIMIT = 10;
    private static final int WAITINGLIST_LIMIT = 3;

    private List<Passenger> confirmedList = new ArrayList<>();
    private Deque<Passenger> waitingList = new ArrayDeque<>();

    // This getter is used only by the junit test case.
    public List<Passenger> getConfirmedList() {
        return confirmedList;
    }

    /**
     * Returns true if passenger could be added into either confirmedList or
     * waitingList. Passenger will be added to waitingList only if confirmedList
     * is full.
     *
     * Return false if both passengerList & waitingList are full
     */
    public boolean bookFlight(String firstName, String lastName, int age, String gender, String travelClass,String confirmationNumber) {

        boolean booked=false;
        Passenger p1=new Passenger(firstName, lastName, age, gender, travelClass, confirmationNumber);
        if(confirmedList.size()<CONFIRMEDLIST_LIMIT){
            confirmedList.add(p1);
            booked=true;
        }
        else if(waitingList.size()<WAITINGLIST_LIMIT){
            waitingList.add(p1);
            booked=true;
        }

        logger.info(String.valueOf(confirmedList.size()));
        logger.info(String.valueOf(waitingList.size()));
        return booked;
    }

    /**
     * Removes passenger with the given confirmationNumber. Passenger could be
     * in either confirmedList or waitingList. The implementation to remove the
     * passenger should go in removePassenger() method and removePassenger method
     * will be tested separately by the uploaded test scripts.

     * If passenger is in confirmedList, then after removing that passenger, the
     * passenger at the front of waitingList (if not empty) must be moved into
     * passengerList. Use poll() method (not remove()) to extract the passenger
     * from waitingList.
     */
    public boolean cancel(String confirmationNumber) {

        boolean removed = false;
        for(int i=0;i<confirmedList.size();i++){
            if(confirmedList.get(i).confirmationNumber==confirmationNumber){
                Iterator<Passenger>itr=confirmedList.listIterator();
                removed=removePassenger(itr,confirmationNumber);
                Passenger obj=waitingList.poll();
                logger.info("inside cancel method");
                logger.info(obj.confirmationNumber);
                confirmedList.add(obj);


            }
        }
        if(removed==false){
            Iterator itr=waitingList.iterator();
            for(Passenger obj:waitingList){
                if(obj.confirmationNumber==confirmationNumber){
                    removed=removePassenger(itr,confirmationNumber);
                    logger.info("cancel waiting");
                }
            }
        }

        logger.info("cancel"+String.valueOf(confirmedList.size()));
        logger.info("cancel"+String.valueOf(waitingList.size()));
        return removed;
    }

    /**
     * Removes passenger with the given confirmation number.
     * Returns true only if passenger was present and removed. Otherwise, return false.
     */
    public boolean removePassenger(Iterator<Passenger> iterator, String confirmationNumber) {

        while (iterator.hasNext()) {
            Passenger obj = iterator.next();
            if (obj.confirmationNumber.equals(confirmationNumber)) {
                iterator.remove();


                logger.info("removed method"+String.valueOf(confirmedList.size()));
                logger.info("removed method"+String.valueOf(waitingList.size()));
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args){

        TicketReservation obj=new TicketReservation();
        obj.bookFlight("Preeti","Yadav",21,"female","economy","C1");
        obj.bookFlight("Preeti","Yadav",21,"female","economy","C2");
        obj.bookFlight("Preeti","Yadav",21,"female","economy","C3");
        obj.bookFlight("Preeti","Yadav",21,"female","economy","C10");

        obj.cancel("C1");

    }

}
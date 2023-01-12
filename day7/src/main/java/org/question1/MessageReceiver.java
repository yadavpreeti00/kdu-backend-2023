package org.question1;

import java.util.Iterator;
import org.question1.MessageQueue;

public class MessageReceiver extends Thread{

    Caller caller;

   public MessageReceiver(Caller obj){
       this.caller=obj;
   }

   public void receiveMessage(Caller caller){


       MessageReceiver r1=new MessageReceiver(caller);
       MessageReceiver r2=new MessageReceiver(caller);
       MessageReceiver r3=new MessageReceiver(caller);
       r1.start();
       r2.start();
       r3.start();
   }
   public void printMessage(Caller caller) {

       Iterator itr = MessageQueue.messages.iterator();
       while (itr.hasNext()) {
           System.out.println(itr.next() + " printed by " + Thread.currentThread().getName() + " with thread id " + Thread.currentThread().getId());
       }

   }

    public void run(){
        synchronized (caller){
            printMessage(caller);
        }
    }

}

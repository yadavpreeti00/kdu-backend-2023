package org.question1;

import java.util.ArrayDeque;
import java.util.Deque;

public class MessageQueue extends Thread{

    static Deque<String> messages= new ArrayDeque<String>();
    MessageSender sender;
    String msg;

    public void addMessage(String msg,MessageSender sender){

        messages.add(msg);

    }
    public MessageQueue(String msg,MessageSender sender){
        this.msg=msg;
        this.sender=sender;
    }

    public void run(){
        synchronized (sender){
            addMessage(msg,sender);
        }
    }

}

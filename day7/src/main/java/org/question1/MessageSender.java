package org.question1;

public class MessageSender {

    MessageSender send;



    public void sendMessages(MessageSender send){

        this.send=send;

        MessageQueue m1= new MessageQueue("This is 1st message",send);

        MessageQueue m2= new MessageQueue("This is 2nd message",send);

        MessageQueue m3= new MessageQueue("This is 3rd message",send);
        m1.start();
        m2.start();
        m3.start();
    }
}

package org.question1;

public class Main {
    public static void main(String[] args) {

        MessageSender send=new MessageSender();

        send.sendMessages(send);

        Caller caller=new Caller();

        MessageReceiver receiver=new MessageReceiver(caller);
        receiver.receiveMessage(receiver.caller);
    }
}

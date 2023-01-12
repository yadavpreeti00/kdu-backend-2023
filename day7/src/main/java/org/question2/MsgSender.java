package org.question2;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayDeque;
import java.util.Deque;

public class MsgSender implements Runnable {

    private static final Logger logger = LoggerFactory.getLogger(MsgSender.class);

    static Deque<String> messages= new ArrayDeque<String>();

    @Override
    public void run() {
            logger.info("Message sent by " + Thread.currentThread().getId());
            messages.add("Message sent by " + Thread.currentThread().getId());
    }
}

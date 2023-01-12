package org.question2;

import org.question1.MessageQueue;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Iterator;

public class MsgReceiver implements Runnable{

    private static final Logger logger = LoggerFactory.getLogger(MsgReceiver.class);

    @Override
    public void run() {

        Iterator itr = MsgSender.messages.iterator();
        while (itr.hasNext()) {
            logger.info(itr.next() + " printed by " + Thread.currentThread().getName() + " with thread id " + Thread.currentThread().getId());
        }
    }
}

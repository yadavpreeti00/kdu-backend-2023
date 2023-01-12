package org.question2;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {

    private static final Logger logger = LoggerFactory.getLogger(Main.class);
    public static void main(String[] args){


        ExecutorService pool = Executors.newFixedThreadPool(3);
        for(int i=0;i<3;i++) {
            pool.execute(new MsgSender());
        }
        pool.shutdown();
        while (!pool.isTerminated()) {
        }

        ExecutorService pool2 = Executors.newFixedThreadPool(3);
        for(int i=0;i<3;i++) {
            pool2.execute(new MsgReceiver());
        }
        while (!pool2.isTerminated()) {
        }


    }
}

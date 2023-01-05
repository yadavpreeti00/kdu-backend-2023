package org.example;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;

public class IntroToLogs {

    private static final Logger logger= LoggerFactory.getLogger(IntroToLogs.class);

    public static void main(String[] args)
    {
        logger.info("Hello World");
        logger.warn("Warning Message");
        logger.debug("Debug Message");
    }
}

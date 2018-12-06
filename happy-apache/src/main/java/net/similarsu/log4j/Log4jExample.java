package net.similarsu.log4j;

import org.apache.log4j.Logger;

public class Log4jExample {
    private static final Logger LOGGER = Logger.getLogger(Log4jExample.class);

    public void example1(){
        LOGGER.info("example1");
    }

}

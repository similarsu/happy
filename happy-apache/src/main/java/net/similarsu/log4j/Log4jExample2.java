package net.similarsu.log4j;

import org.apache.log4j.Logger;

public class Log4jExample2 {
    private static final Logger LOGGER_HELPER = Log4jHelper.getLogger();

    public void example2(){
        LOGGER_HELPER.info("example2");
    }

}

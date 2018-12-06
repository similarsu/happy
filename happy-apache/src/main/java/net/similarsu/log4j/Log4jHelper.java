package net.similarsu.log4j;

import org.apache.log4j.Logger;

public abstract class Log4jHelper {
    private static Logger logger = null;

    private static void init() {
        //BasicConfigurator.configure();
        logger = Logger.getLogger(Log4jHelper.class);
    }

    public static Logger getLogger() {
        if (logger == null) {
            init();
        }

        return logger;
    }
}

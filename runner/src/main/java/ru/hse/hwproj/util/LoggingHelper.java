package ru.hse.hwproj.util;

import org.slf4j.Logger;

public class LoggingHelper {

    public static void logWrap(Logger logger, String name, Runnable method) {
        logger.info(name + " IN");
        method.run();
        logger.info(name + " OUT");
    }
}

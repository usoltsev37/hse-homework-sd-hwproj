package ru.hse.hwproj.util;

import org.slf4j.Logger;

import java.util.function.Supplier;

public class LoggingHelper<T> {

    public static <T> T logWrap(Logger logger, String name, Supplier<T> method) {
        logger.info(name + " IN");
        T result = method.get();
        logger.info(name + " OUT");
        return result;
    }

    public static void logWrap(Logger logger, String name, Runnable method) {
        logger.info(name + " IN");
        method.run();
        logger.info(name + " OUT");
    }
}

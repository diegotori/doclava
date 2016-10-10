package com.google.doclava;

import org.slf4j.LoggerFactory;

import ch.qos.logback.classic.Logger;
import ch.qos.logback.classic.LoggerContext;
import ch.qos.logback.classic.encoder.PatternLayoutEncoder;
import ch.qos.logback.classic.spi.ILoggingEvent;
import ch.qos.logback.core.ConsoleAppender;

/**
 * Created by diegotori on 10/10/16.
 */
public final class DoclavaLoggerUtils {
    public static final String DEFAULT_PATTERN_LAYOUT = "%-5level/%logger: %message%n";

    private DoclavaLoggerUtils() {
        throw new UnsupportedOperationException();
    }

    public static boolean isValidLogLevel(final String logLevel) {
        return !(logLevel == null || logLevel.isEmpty()) &&
                (logLevel.equalsIgnoreCase("error") ||
                        logLevel.equalsIgnoreCase("warn") ||
                        logLevel.equalsIgnoreCase("info") ||
                        logLevel.equalsIgnoreCase("warning") ||
                        logLevel.equalsIgnoreCase("trace"));
    }

    public static void wrapDefaultLoggerWithDefaultPatternLayout(){
        wrapDefaultLoggerWithCustomPatternLayout(DEFAULT_PATTERN_LAYOUT);
    }

    public static void wrapDefaultLoggerWithCustomPatternLayout(final String newPatternLayout){
        if (newPatternLayout == null || newPatternLayout.isEmpty()){
            throw new IllegalArgumentException("Please pass in a valid pattern layout.");
        }
        Logger rootLogger = (Logger) LoggerFactory.getLogger(Logger.ROOT_LOGGER_NAME);
        final LoggerContext loggerContext = rootLogger.getLoggerContext();
        loggerContext.reset();

        final PatternLayoutEncoder encoder = new PatternLayoutEncoder();
        encoder.setContext(loggerContext);
        encoder.setPattern(newPatternLayout);
        encoder.start();

        final ConsoleAppender<ILoggingEvent> appender = new ConsoleAppender<ILoggingEvent>();
        appender.setContext(loggerContext);
        appender.setEncoder(encoder);
        appender.start();

        rootLogger.addAppender(appender);
        rootLogger.trace("Configuration completed.");
    }
}

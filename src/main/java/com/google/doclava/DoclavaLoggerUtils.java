package com.google.doclava;

/**
 * Created by diegotori on 10/10/16.
 */
public final class DoclavaLoggerUtils {

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
}

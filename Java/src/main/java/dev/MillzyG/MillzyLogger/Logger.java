package dev.MillzyG.MillzyLogger;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Logger {
    public enum Level {
        /**
         * 	Specialized Developer Information
         */
        FINEST("FINEST"),
        /**
         * Detailed Developer Information
         */
        FINER("FINER"),
        /**
         * 	General Developer Information
         */
        FINE("FINE"),
        /**
         * 	Configuration Information
         */
        CONFIG("CONFIG"),
        /**
         * 	General Information
         */
        INFO("INFO"),
        /**
         * 	Potential Problem
         */
        WARNING("WARN"),
        /**
         * 	Represents serious failure
         */
        SEVERE("SEVERE")
        ;
        Level(String value) {}
    }

    private static String getColor(Level lvl) {
        String color = "";
        switch (lvl) {
            case FINEST:
                color = "\033[36m";
                break;
            case FINER:
                color = "\033[31;1m";
                break;
            case FINE:
                color = "\033[33m";
                break;
            case CONFIG:
                color = "\033[34;1m";
                break;
            case INFO:
                color = "\033[32m";
                break;
            case WARNING:
                color = "\033[33;1m";
                break;
            case SEVERE:
                color = "\033[31m";
                break;
        }
        return color;
    }

    private static void log(Level lvl, Object x) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        String now = dtf.format(LocalDateTime.now());

        System.out.printf("[%s] [%s%s\033[0m] %s%s\033[0m\n", now, getColor(lvl), lvl.name(), getColor(lvl), x);
    }

    public static void finest(Object x) {
        log(Level.FINEST, x);
    }

    public static void finer(Object x) {
        log(Level.FINER, x);
    }

    public static void fine(Object x) {
        log(Level.FINE, x);
    }

    public static void config(Object x) {
        log(Level.CONFIG, x);
    }

    public static void info(Object x) {
        log(Level.INFO, x);
    }

    public static void warning(Object x) {
        log(Level.WARNING, x);
    }

    public static void severe(Object x) {
        log(Level.SEVERE, x);
    }
}

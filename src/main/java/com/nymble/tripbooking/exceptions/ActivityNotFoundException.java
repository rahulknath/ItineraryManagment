package com.nymble.tripbooking.exceptions;

/**
 * The ActivityNotFoundException is an exception that is thrown when an activity is not found.
 */
public class ActivityNotFoundException extends RuntimeException {

    /**
     * Constructs an ActivityNotFoundException with no detail message.
     */
    public ActivityNotFoundException() {
        super();
    }

    /**
     * Constructs an ActivityNotFoundException with the specified detail message.
     *
     * @param msg the detail message
     */
    public ActivityNotFoundException(String msg) {
        super(msg);
    }
}

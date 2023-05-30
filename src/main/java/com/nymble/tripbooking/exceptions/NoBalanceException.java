package com.nymble.tripbooking.exceptions;

/**
 * The NoBalanceException is an exception that is thrown when a passenger has insufficient balance.
 */
public class NoBalanceException extends RuntimeException {

    /**
     * Constructs a NoBalanceException with no detail message.
     */
    public NoBalanceException() {
        super();
    }

    /**
     * Constructs a NoBalanceException with the specified detail message.
     *
     * @param msg the detail message
     */
    public NoBalanceException(String msg) {
        super(msg);
    }
}

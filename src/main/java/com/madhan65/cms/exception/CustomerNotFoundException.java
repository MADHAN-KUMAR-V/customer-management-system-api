package com.madhan65.cms.exception;

public class CustomerNotFoundException extends RuntimeException {

    public CustomerNotFoundException() {
        super();
    }

    public CustomerNotFoundException(String message, Throwable cause) {
        super(message);
    }


    public CustomerNotFoundException(String customerNotFound) {
    }
}

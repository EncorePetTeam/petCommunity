package com.encore.pet.community.exception;

public class DBNotFoundException extends RuntimeException {

    public DBNotFoundException(String message) {
        super(message);
    }
}

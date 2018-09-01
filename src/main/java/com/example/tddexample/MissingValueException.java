package com.example.tddexample;

public class MissingValueException extends RuntimeException {

    public MissingValueException(String message) {
        super(message);
    }
}
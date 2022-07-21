package com.senac.api.exception;

public class ParseException extends RuntimeException {
    public ParseException(String msg) {
        super(msg);
    }
    public ParseException(String msg, Throwable throwable) {
        super(msg, throwable);
    }}

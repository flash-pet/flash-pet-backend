package com.senac.adapter.exception;

public class CacheException extends RuntimeException {
    public CacheException(String msg) {
        super(msg);
    }
    public CacheException(String msg, Throwable throwable) {
        super(msg, throwable);
    }
}

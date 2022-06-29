package com.senac.service.exception;

public class ImageConverterException extends RuntimeException {
    public ImageConverterException(String msg, Throwable throwable) {
        super(msg, throwable);
    }
}

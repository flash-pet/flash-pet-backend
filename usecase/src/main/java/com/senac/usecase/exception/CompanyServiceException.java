package com.senac.usecase.exception;

public class CompanyServiceException extends RuntimeException {
    public CompanyServiceException(String msg) {
        super(msg);
    }
    public CompanyServiceException(String msg, Throwable throwable) {
        super(msg, throwable);
    }
}

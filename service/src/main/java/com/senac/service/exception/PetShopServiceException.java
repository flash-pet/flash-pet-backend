package com.senac.service.exception;

public class PetShopServiceException extends RuntimeException{
    public PetShopServiceException(String msg) {
        super(msg);
    }

    public PetShopServiceException(String msg, Throwable throwable) {
        super(msg, throwable);
    }
}

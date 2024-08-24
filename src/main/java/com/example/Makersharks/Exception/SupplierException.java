package com.example.Makersharks.Exception;

public class SupplierException extends RuntimeException {
    public SupplierException(String message) {
        super(message);
    }

    public SupplierException(String message, Throwable cause) {
        super(message, cause);
    }
}

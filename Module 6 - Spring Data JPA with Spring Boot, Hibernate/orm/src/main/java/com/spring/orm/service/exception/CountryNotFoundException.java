// 1. Hands on 6
package com.spring.orm.service.exception;

public class CountryNotFoundException extends Exception {

    private static final long serialVersionUID = 1L;

    public CountryNotFoundException(String message) {
        super(message);
    }
}
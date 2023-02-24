package com.ericsson.homework.exceptions;

import lombok.Getter;

import java.util.function.Supplier;

@Getter
public class BaseException extends RuntimeException implements Supplier<BaseException> {

    private final String message;
    private final BaseExceptionType type;

    public BaseException(String message, BaseExceptionType type) {
        this.message = message;
        this.type = type;
    }

    @Override
    public BaseException get() {
        return this;
    }
}

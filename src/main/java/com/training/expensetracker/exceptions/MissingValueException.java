package com.training.expensetracker.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class MissingValueException extends RuntimeException {
    public MissingValueException() {
        super("Missing value! Please fill the missing value");
    }
}

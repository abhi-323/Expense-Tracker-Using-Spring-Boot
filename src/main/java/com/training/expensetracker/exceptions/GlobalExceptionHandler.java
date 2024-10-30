package com.training.expensetracker.exceptions;

import com.training.expensetracker.dto.ErrorResponseDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ErrorResponseDTO> handleIdNotFoundException(ResourceNotFoundException exception) {
        ErrorResponseDTO error = new ErrorResponseDTO(exception.getMessage());
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(ResourceAlreadyExistException.class)
    public ResponseEntity<ErrorResponseDTO> handleAlreadyExistException(ResourceAlreadyExistException exception) {
        ErrorResponseDTO error = new ErrorResponseDTO(exception.getMessage());
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(MissingValueException.class)
    public ResponseEntity<ErrorResponseDTO> handleMissingValueException(MissingValueException exception) {
        ErrorResponseDTO error = new ErrorResponseDTO(exception.getMessage());
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }
}

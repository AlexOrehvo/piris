package com.piris.bank.exceptions;

import com.piris.bank.exceptions.errors.ErrorResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class DbExceptionHandler {

    @Autowired
    private ErrorIdentifier errorIdentifier;



    @ExceptionHandler(Exception.class)
    @ResponseBody
    public final ResponseEntity<Object> handle(Exception exception) {
        ErrorResponse errorResponse = errorIdentifier.identify(exception);
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .contentType(MediaType.APPLICATION_JSON)
                .body(errorResponse);
    }
}

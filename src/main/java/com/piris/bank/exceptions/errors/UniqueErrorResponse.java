package com.piris.bank.exceptions.errors;

public class UniqueErrorResponse extends ErrorResponse {

    private String responsePattern = "Such %s already exist";

    public UniqueErrorResponse(String field) {
        message = String.format(responsePattern, field);
    }
}

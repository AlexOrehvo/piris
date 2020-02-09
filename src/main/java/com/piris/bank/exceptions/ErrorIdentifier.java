package com.piris.bank.exceptions;

import com.piris.bank.exceptions.errors.ErrorResponse;
import com.piris.bank.exceptions.errors.UniqueErrorResponse;
import org.postgresql.util.PSQLException;
import org.springframework.stereotype.Component;

@Component
public class ErrorIdentifier {

    public ErrorResponse identify(Exception exception) {
        System.out.println(exception);
        if (exception.getCause().getCause() instanceof PSQLException) {
            PSQLException psqlException = (PSQLException)exception.getCause().getCause();
            String cause = psqlException.getServerErrorMessage().getDetail();
            return checkUnique(cause);
        }
        return new ErrorResponse();
    }

    private ErrorResponse checkUnique(String cause) {
        if (cause.contains(ConstraintValues.EMAIL)) {
            return new UniqueErrorResponse("email");
        }
        if (cause.contains(ConstraintValues.IDENTIFICATION_NUMBER)) {
            return new UniqueErrorResponse("identification number");
        }
        if (cause.contains(ConstraintValues.PASSPORT_NUMBER)) {
            return new UniqueErrorResponse("passport number");
        }
        return new ErrorResponse();
    }
}

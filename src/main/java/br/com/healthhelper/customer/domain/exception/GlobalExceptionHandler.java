package br.com.healthhelper.customer.domain.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.net.URI;
import java.time.Instant;

@RestControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(UserNotFoundException.class)
    ProblemDetail handleCustomerNotExistsException(UserNotFoundException e) {
        ProblemDetail problemDetail = ProblemDetail.forStatusAndDetail(HttpStatus.NOT_FOUND, e.getLocalizedMessage());
        problemDetail.setTitle("UUID of user is null or invalid");
        problemDetail.setDetail("User uuid valid is necessary to execute");
        problemDetail.setProperty("Category", "Platform");
        problemDetail.setProperty("TimeStamp", Instant.now());
        problemDetail.setType(URI.create("/user/uuid"));
        return problemDetail;
    }
}

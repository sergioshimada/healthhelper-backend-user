package br.com.healthhelper.customer.domain.exception;

public class UserNotFoundException extends RuntimeException {

    public UserNotFoundException() {
        super("user not found");
    }
}

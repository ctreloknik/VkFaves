package net.vkfave.services.exception;

public class UserValidationException extends Exception {
    public UserValidationException() {
    }

    public UserValidationException(String message) {
        super(message);
    }

    public UserValidationException(String message, Throwable cause) {
        super(message, cause);
    }

    public UserValidationException(Throwable cause) {
        super(cause);
    }

    public UserValidationException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}

package net.imadness.abe.controllers.exceptions;

/**
 * Общий класс для исключений Spring-контроллеров приложения
 */
public class SpringControllerException extends Exception {
    public SpringControllerException() {
    }

    public SpringControllerException(String message) {
        super(message);
    }

    public SpringControllerException(String message, Throwable cause) {
        super(message, cause);
    }

    public SpringControllerException(Throwable cause) {
        super(cause);
    }

    public SpringControllerException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}

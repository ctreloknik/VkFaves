package net.imadness.abe.controllers.exceptions;

/**
 * Общее исключение для элементов REST-API приложения
 */
public class RestException extends Exception {
    public RestException() {

    }

    public RestException(String message) {
        super(message);
    }

    public RestException(Throwable cause) {
        super(cause);
    }
}

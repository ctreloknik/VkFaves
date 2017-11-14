package net.imadness.abe.controllers.exceptions;

/**
 * Общий класс для исключений Spring-контроллеров приложения
 */
public class SpringControllerException extends Exception {
    public SpringControllerException() {
        super();
    }

    public SpringControllerException(String message) {
        super(message);
    }

    public SpringControllerException(Throwable cause) {
        super(cause);
    }
}

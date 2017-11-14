package net.imadness.abe.controllers.exceptions;

/**
 * Исключение, выбрасываемое при ошибке загрузки доски на главную страницу
 */
public class BoardLoadingException extends Exception {
    public BoardLoadingException(Throwable cause) {
        super(cause);
    }
}

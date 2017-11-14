package net.imadness.abe.controllers.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Глобальный обработчик исключений для контроллеров
 */
@ControllerAdvice
public class ControllerExceptionHandler {

    /**
     * Обработка исключений Spring-контроллеров
     * @param exception исключение
     * @param model     коллекция параметров представления
     * @return адрес страницы ошибки
     */
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(SpringControllerException.class)
    public String handleSpringControllerException(Exception exception, ModelMap model) {
        model.addAttribute("errorName", "Ошибка при подготовке главной страницы!");
        model.addAttribute("errorMessage", "Произошла ошибка при загрузке списка форумов на главную страницу.<br>" + exception.getMessage());
        return "error";
    }

    /**
     * Обработка исключений элементов REST-API
     * @param exception исключение
     * @return ответ сервера с кодом ошибки 500 и сообщением об ошибке
     */
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(RestException.class)
    public ResponseEntity<String> handleRestException(Exception exception) {
        return new ResponseEntity<>(exception.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}

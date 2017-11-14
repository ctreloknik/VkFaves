package net.imadness.abe.util;

/**
 * Класс-обёртка над объектом, который необходимо передать клиенту в качестве ответа сервера (json).
 * Помимо самого объекта инкапсулирует строку с сообщением об ошибке {@link Throwable#getMessage()}
 *
 * @param <T> тип инкапсулируемого объекта
 */
public class RestResponseWrapper<T> {
  
  private T data;
  private String errorMessage;

  public RestResponseWrapper(T data) {
    this.data = data;
  }
  
  public RestResponseWrapper(String errorMessage) {
    this.errorMessage = errorMessage;
  }
  
  public RestResponseWrapper(T data, String errorMessage) {
    this.data = data;
    this.errorMessage = errorMessage;
  }

  public T getData() {
    return data;
  }

  public void setData(T data) {
    this.data = data;
  }

  public String getErrorMessage() {
    return errorMessage;
  }

  public void setErrorMessage(String errorMessage) {
    this.errorMessage = errorMessage;
  }
  
}

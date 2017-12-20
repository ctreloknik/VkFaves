package net.vkfave.util;

public class ResponseWrapper<ResponseType> {
    private ResponseType payload;
    private String message;

    public static <ResponseType> ResponseWrapper<ResponseType> wrap(ResponseType payload, String message) {
        return new ResponseWrapper<ResponseType>(payload, message);
    }

    public static <ResponseType> ResponseWrapper wrap(ResponseType payload) {
        return new ResponseWrapper<ResponseType>(payload, null);
    }

    public static <ResponseType> ResponseWrapper wrap(String message, Throwable throwable) {
        String msg = message == null ? "" : message + "\n";
        return wrap(msg + throwable.getMessage());
    }

    public ResponseWrapper(ResponseType payload) {
        this.payload = payload;
    }

    public ResponseWrapper(ResponseType payload, String message) {
        this.payload = payload;
        this.message = message;
    }

    public ResponseType getPayload() {
        return payload;
    }

    public void setPayload(ResponseType payload) {
        this.payload = payload;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}

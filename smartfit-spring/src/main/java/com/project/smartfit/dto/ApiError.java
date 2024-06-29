package com.project.smartfit.dto;

import java.time.LocalDateTime;

/*Clase para manejar una exepción*/
public class ApiError {

    private String backengMessage;
    private String message;
    private String url;
    private String method;
    private LocalDateTime timestamp;

    public String getBackengMessage() {
        return backengMessage;
    }

    public void setBackengMessage(String backengMessage) {
        this.backengMessage = backengMessage;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }
}

package com.project.smartfit.dto;

public class LogOutResponse {

    private String message;

    public LogOutResponse(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}

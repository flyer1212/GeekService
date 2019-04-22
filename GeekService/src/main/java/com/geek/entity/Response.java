package com.geek.entity;

public class Response {
    public static final Response USERNAME_PASSWORD_INVALID =
            new Response(false, "username or passwrod invalid");
    private boolean statusCode;
    private String message;

    public Response(boolean statusCode, String message) {
        this.statusCode = statusCode;
        this.message = message;
    }

    public boolean isStatusCode() {
        return statusCode;
    }

    public void setStatusCode(boolean statusCode) {
        this.statusCode = statusCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}

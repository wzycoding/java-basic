package com.wzy.guava.eventbus;

public class OrderMessage {

    private String message;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "OrderMessage{" +
                "message='" + message + '\'' +
                '}';
    }
}

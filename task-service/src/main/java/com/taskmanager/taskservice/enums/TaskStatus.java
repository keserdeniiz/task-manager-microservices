package com.taskmanager.taskservice.enums;

public enum TaskStatus {
    ARCHIVED("ARCHIVED"),
    COMPLETED("COMPLETED"),
    CREATED("CREATED"),
    IN_PROGRESS("IN_PROGRESS");

    private final String value;

    TaskStatus(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

}

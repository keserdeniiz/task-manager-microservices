package com.taskmanager.taskservice.exception;

public class TaskException extends RuntimeException{
    public TaskException(Long id) {
        super("Task not found with id: " + id);
    }
}

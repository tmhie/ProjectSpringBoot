package com.todoExam.ToDo.exception;

public class EntityNotFound extends RuntimeException {
    public EntityNotFound() {
        super("Entity not found");
    }
}

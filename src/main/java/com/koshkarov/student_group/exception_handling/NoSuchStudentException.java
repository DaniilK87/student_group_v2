package com.koshkarov.student_group.exception_handling;

public class NoSuchStudentException extends RuntimeException{
    public NoSuchStudentException(String message) {
        super(message);
    }
}

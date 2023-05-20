package com.koshkarov.student_group.exception_handling;

public class DataDeleteException extends RuntimeException {
    public DataDeleteException(String message) {
        super(message);
    }
}

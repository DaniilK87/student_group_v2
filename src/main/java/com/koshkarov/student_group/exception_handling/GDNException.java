package com.koshkarov.student_group.exception_handling;

import org.springframework.dao.DataAccessException;

public class GDNException extends RuntimeException {
    public GDNException(String message) {
        super(message);
    }
}

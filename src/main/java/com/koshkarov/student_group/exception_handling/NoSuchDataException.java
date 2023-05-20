package com.koshkarov.student_group.exception_handling;

public class NoSuchDataException extends NullPointerException{
    public NoSuchDataException(String s) {
        super(s);
    }
}

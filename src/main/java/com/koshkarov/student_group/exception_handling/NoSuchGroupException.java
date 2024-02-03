package com.koshkarov.student_group.exception_handling;

public class NoSuchGroupException extends NullPointerException{
    public NoSuchGroupException(String s) {
        super(s);
    }
}

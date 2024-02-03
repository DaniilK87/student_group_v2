package com.koshkarov.student_group.exception_handling;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler
    ResponseEntity<GroupIncorrectData> groupHandleException(NoSuchGroupException e) {
        GroupIncorrectData data = new GroupIncorrectData();
        data.setInfo(e.getMessage());
        return new ResponseEntity<>(data, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler
    ResponseEntity<StudentIncorrectData> studentHandleException(NoSuchStudentException e) {
        StudentIncorrectData data = new StudentIncorrectData();
        data.setInfo(e.getMessage());
        return new ResponseEntity<>(data, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler
    ResponseEntity<GroupDeleteNotification> studentHandleException(GDNException e) {
        GroupDeleteNotification gdn = new GroupDeleteNotification();
        gdn.setNotification(e.getMessage());
        return new ResponseEntity<>(gdn, HttpStatus.OK);
    }
}

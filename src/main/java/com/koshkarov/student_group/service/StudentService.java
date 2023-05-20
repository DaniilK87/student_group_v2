package com.koshkarov.student_group.service;

import com.koshkarov.student_group.dto.*;


import java.util.List;

public interface StudentService {

    void deleteStudent(int studentId);
    List<StudentDto> getAllStudent();
    void addStudent(StudentDto studentDto, int groupId);
    List<StudentDto> getStudentByName(String name);
    List<StudentDto> getAllStudentsByGroup(int groupId);
    RatingDto getRating(int studentId);
    void getMoney(GrantsDto grantsDto, int studentId);
    void editStudent(StudentDto studentDto, int studentId);
    void transferStudent(int groupId, int studentId);
}

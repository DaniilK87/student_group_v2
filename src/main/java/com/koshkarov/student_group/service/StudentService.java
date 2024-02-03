package com.koshkarov.student_group.service;

import com.koshkarov.student_group.dto.*;


import java.util.List;

public interface StudentService {


    public String deleteStudent(int studentId);

    List<StudentDto> getAllStudent();

    List<StudentDto> getStudentByName(String name);

    List<StudentDto> getAllStudentsByGroup(int groupId);

    RatingDTO getRating(int studentId);

    void getMoney(GrantsDto grantsDto, int studentId);


    void editStudent(EditStudentDto editStudentDto, int studentId);

}

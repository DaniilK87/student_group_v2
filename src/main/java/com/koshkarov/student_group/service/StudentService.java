package com.koshkarov.student_group.service;

import com.koshkarov.student_group.dto.GrantsDto;
import com.koshkarov.student_group.dto.RatingDTO;
import com.koshkarov.student_group.dto.StudentDto;


import java.util.List;

public interface StudentService {


    public String deleteStudent(int id);

    List<StudentDto> getAllStudent();

    List<StudentDto> getStudentByName(String name);

    List<StudentDto> getAllStudentsByGroup(int groupId);

    RatingDTO getRating(int id);

    void getMoney(GrantsDto grantsDto, int id);
}

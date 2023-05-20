package com.koshkarov.student_group.service;



import com.koshkarov.student_group.dto.StudentResponseDto;


import java.util.List;

public interface StudentService {


    public String deleteStudent(int id);

    List<StudentResponseDto> getAllStudent();


}

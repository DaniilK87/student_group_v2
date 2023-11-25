package com.koshkarov.student_group.service;



import com.koshkarov.student_group.dto.GrantsResponseDto;
import com.koshkarov.student_group.dto.RatingResponseDTO;
import com.koshkarov.student_group.dto.StudentResponseDto;


import java.util.List;

public interface StudentService {


    public String deleteStudent(int id);

    List<StudentResponseDto> getAllStudent();

    List<StudentResponseDto> getStudentByName(String name);

    List<StudentResponseDto> getAllStudentsByGroup(int groupId);

    RatingResponseDTO getRating(int id);

    void getMoney(GrantsResponseDto grantsResponseDto, int id);
}

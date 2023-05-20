package com.koshkarov.student_group.service;

import com.koshkarov.student_group.dto.GrantsDto;
import com.koshkarov.student_group.dto.RatingDto;
import com.koshkarov.student_group.dto.TeacherDto;

import java.util.List;

public interface TeacherService {
    List<TeacherDto> getAllTeacher();
    TeacherDto getTeacherById(int id);
    void addNewTeacher(TeacherDto teacherDto);
    void deleteTeacher(int id);
    RatingDto getRating(int teacherId);
    void getMoney(GrantsDto grantsDto, int teacherId);
}

package com.koshkarov.student_group.service;

import com.koshkarov.student_group.dto.*;

import java.util.List;

public interface GroupService {

    List<GroupResponseDto> getAllGroup();

    void addNewGroup(AddGroupRequestDto addGroupRequestDto);


    void deleteGroup(int groupId);

    GroupResponseDto getGroupById(int groupId);

    void addStudent(AddStudentRequestDto addStudentRequestDto, int groupId);

    void editGroup (StudentRequestDto studentRequestDto, int groupId);
}

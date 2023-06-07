package com.koshkarov.student_group.service;

import com.koshkarov.student_group.dto.*;

import java.util.List;

public interface GroupService {

    public List<GroupResponseDto> getAllGroup();

    public void addNewGroup(AddGroupRequestDto addGroupRequestDto);


    void deleteGroup(int groupId);

    GroupResponseDto getGroupById(int groupId);

    void addStudent(AddStudentRequestDto addStudentRequestDto, int groupId);

    void editGroup (StudentRequestDto studentRequestDto, int groupId);
}

package com.koshkarov.student_group.service;

import com.koshkarov.student_group.dto.*;

import java.util.List;

public interface GroupService {

    List<GroupDto> getAllGroup();

    void addNewGroup(AddGroupDto addGroupDto);


    void deleteGroup(int groupId);

    GroupDto getGroupById(int groupId);

    void addStudent(AddStudentDto addStudentDto, int groupId);

    void editGroup (StudentDto studentDto, int groupId);
}

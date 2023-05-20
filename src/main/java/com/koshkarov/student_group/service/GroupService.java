package com.koshkarov.student_group.service;

import com.koshkarov.student_group.dto.*;
import com.koshkarov.student_group.entity.Group;

import java.util.List;
import java.util.Optional;

public interface GroupService {

    public List<GroupResponseDto> getAllGroup();

    public void addNewGroup(AddGroupRequestDto addGroupRequestDto);


    void deleteGroup(int groupId);

    GroupResponseDto getGroupById(int groupId);

    void addStudent(AddStudentRequestDto addStudentRequestDto, int groupId);

//    void editGroup(EditGroupRequestDto editGroupRequestDto, int groupId);
}

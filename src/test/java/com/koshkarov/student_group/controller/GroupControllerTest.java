package com.koshkarov.student_group.controller;

import com.koshkarov.student_group.dto.AddGroupDto;
import com.koshkarov.student_group.dto.AddStudentDto;
import com.koshkarov.student_group.dto.GroupDto;
import com.koshkarov.student_group.dto.StudentDto;
import com.koshkarov.student_group.service.GroupService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
class GroupControllerTest {

    @InjectMocks
    private GroupController groupController;

    @Mock
    private GroupService groupService;

    @Test
    void addNewGroup() {
        AddGroupDto addGroup = Mockito.mock(AddGroupDto.class);
        groupController.addNewGroup(addGroup);
        verify(groupService).addNewGroup(addGroup);
    }

    @Test
    void getAllGroups()  {
        List<GroupDto> groupList = new ArrayList<>();
        groupList.add(Mockito.mock(GroupDto.class));
        groupList.add(Mockito.mock(GroupDto.class));

        when(groupService.getAllGroup()).thenReturn(groupList);
        List<GroupDto> groups = groupController.getAllGroups();
        verify(groupService).getAllGroup();
        Assertions.assertNotNull(groups);
    }

    @Test
    void addStudent() {
        AddStudentDto addStudent = Mockito.mock(AddStudentDto.class);
        int id = 1;
        groupController.addStudent(addStudent,id);
        verify(groupService).addStudent(addStudent,id);
    }

}
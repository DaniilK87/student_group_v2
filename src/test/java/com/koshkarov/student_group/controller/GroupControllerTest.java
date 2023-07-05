package com.koshkarov.student_group.controller;

import com.koshkarov.student_group.dto.AddGroupRequestDto;
import com.koshkarov.student_group.dto.AddStudentRequestDto;
import com.koshkarov.student_group.dto.GroupResponseDto;
import com.koshkarov.student_group.dto.StudentRequestDto;
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
        AddGroupRequestDto addGroup = Mockito.mock(AddGroupRequestDto.class);
        groupController.addNewGroup(addGroup);
        verify(groupService).addNewGroup(addGroup);
    }

    @Test
    void getAllGroups()  {
        List<GroupResponseDto> groupList = new ArrayList<>();
        groupList.add(Mockito.mock(GroupResponseDto.class));
        groupList.add(Mockito.mock(GroupResponseDto.class));

        when(groupService.getAllGroup()).thenReturn(groupList);
        List<GroupResponseDto> groups = groupController.getAllGroups();
        verify(groupService).getAllGroup();
        Assertions.assertNotNull(groups);
    }

    @Test
    void addStudent() {
        AddStudentRequestDto addStudent = Mockito.mock(AddStudentRequestDto.class);
        int id = 1;
        groupController.addStudent(addStudent,id);
        verify(groupService).addStudent(addStudent,id);
    }

    @Test
    void editGroup() {
        StudentRequestDto requestDto = Mockito.mock(StudentRequestDto.class);
        int id = 1;
        groupController.editGroup(requestDto,id);
        verify(groupService).editGroup(requestDto,id);
    }
}
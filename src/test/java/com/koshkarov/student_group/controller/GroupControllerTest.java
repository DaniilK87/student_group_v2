package com.koshkarov.student_group.controller;

import com.koshkarov.student_group.dto.GroupDto;
import com.koshkarov.student_group.service.GroupService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

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
        GroupDto addGroup = Mockito.mock(GroupDto.class);
        groupController.newGroup(addGroup);
        verify(groupService).addNewGroup(addGroup);
    }
    @Test
    void getAllGroups()  {
        List<GroupDto> groupList = new ArrayList<>();
        groupList.add(Mockito.mock(GroupDto.class));
        groupList.add(Mockito.mock(GroupDto.class));

        when(groupService.getAllGroup()).thenReturn(groupList);
        ResponseEntity<List<GroupDto>> groups = groupController.allGroups();
        verify(groupService).getAllGroup();
        Assertions.assertNotNull(groups);
    }
}
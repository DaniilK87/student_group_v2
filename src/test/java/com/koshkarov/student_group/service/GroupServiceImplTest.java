package com.koshkarov.student_group.service;

import com.koshkarov.student_group.dao.GroupRepository;
import com.koshkarov.student_group.dao.StudentRepository;
import com.koshkarov.student_group.dto.GroupResponseDto;
import com.koshkarov.student_group.entity.Group;
import com.koshkarov.student_group.entity.Student;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.stubbing.OngoingStubbing;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
class GroupServiceImplTest {

    @InjectMocks
    private GroupServiceImpl groupService;

    @Mock
    private GroupRepository groupRepository;

    @Mock
    private StudentRepository studentRepository;

    @Test
    void returnAllGroup()  {
        List<Group> groupList = getGroup().stream().map(
                groupResponseDto -> {
                    Group group = new Group();
                    group.setId(groupResponseDto.getId());
                    group.setGroupNumber(groupResponseDto.getGroupNumber());
                    group.setStudentCount(groupResponseDto.getStudentCount());
                    return group;
                }).collect(Collectors.toList());

        groupService = Mockito.mock(GroupServiceImpl.class);
        when(groupRepository.findAll()).thenReturn(groupList);
        List<GroupResponseDto> groups = groupService.getAllGroup();

        assertNotNull(groups);
        assertEquals(2,groups.size());
    }

    @Test
    void addNewGroup() {
        Group group = Mockito.mock(Group.class);
        group.setGroupNumber("101");
        groupRepository.save(group);
        assertNotNull(group);
    }

    @Test
    void addStudent() {
        String id = "1";
        Student student = Mockito.mock(Student.class);
        Group group = Mockito.mock(Group.class);
        group.setGroupNumber(id);
        student.setGroup(group);
        studentRepository.save(student);
        assertNotNull(student);
    }

    @Test
    void editGroup() {
    }

    @Test
    void deleteGroup() {
        Group group = Mockito.mock(Group.class);
        groupRepository.deleteById(group.getId());
        assertNotNull(group);
    }

    @Test
    void getGroupById() {

    }

    List<GroupResponseDto> getGroup() {
        List<GroupResponseDto> listGroup = new ArrayList<>();
        listGroup.add(new GroupResponseDto(1,"Б101",7));
        listGroup.add(new GroupResponseDto(2,"Б102",8));
        return listGroup;
    }

}
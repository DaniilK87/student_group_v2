package com.koshkarov.student_group.service;

import com.koshkarov.student_group.repo.GroupRepository;
import com.koshkarov.student_group.repo.StudentRepository;
import com.koshkarov.student_group.dto.GroupDto;
import com.koshkarov.student_group.entity.Group;
import com.koshkarov.student_group.entity.Student;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
        List<Group> groupList = new ArrayList<>();
        groupList.add(Mockito.mock(Group.class));
        groupList.add(Mockito.mock(Group.class));

        when(groupRepository.findAll()).thenReturn(groupList);
        List<GroupDto> groups = groupService.getAllGroup();

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
        List<Student> students = new ArrayList<>();
        students.add(Mockito.mock(Student.class));

        int id = students.get(0).getId();
        Student student = students.get(id);

        studentRepository.save(student);
        assertNotNull(student);
    }

    @Test
    void deleteGroup() {
        Group group = Mockito.mock(Group.class);
        groupRepository.deleteById(group.getId());
        assertNotNull(group);
    }

    @Test
    void getGroupById() {
        GroupDto groupDto = Mockito.mock(GroupDto.class);
        groupDto.setId(1);
        Optional<Group> group = groupRepository.findById(groupDto.getId());
        assertNotNull(group);
    }

}
package com.koshkarov.student_group.service;

import com.koshkarov.student_group.dao.GroupRepository;
import com.koshkarov.student_group.dao.StudentRepository;
import com.koshkarov.student_group.dto.*;
import com.koshkarov.student_group.entity.Group;
import com.koshkarov.student_group.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class GroupServiceImpl implements GroupService{
    @Autowired
    private GroupRepository groupRepository;
    @Autowired
    private StudentRepository studentRepository;

    @Override
    public List<GroupResponseDto> getAllGroup() {
        List<Group> groups = groupRepository.findAll();
        List<GroupResponseDto> collect = groups.stream()
                .map(group -> {
                    GroupResponseDto groupResponseDto = new GroupResponseDto();
                    groupResponseDto.setId(group.getId());
                    groupResponseDto.setGroupNumber(group.getGroupNumber());
                    groupResponseDto.setStudentCount(group.getStudents().size());
                    return groupResponseDto;
                }).collect(Collectors.toList());
        return collect;
    }


    @Override
    public void addNewGroup(AddGroupRequestDto addGroupRequestDto) {
            Group group = new Group();
            group.setGroupNumber(addGroupRequestDto.getGroupNumber());
            groupRepository.save(group);
    }

    @Override
    public void addStudent(AddStudentRequestDto addStudentRequestDto, int groupId) {
        Student student = new Student();
        LocalDate date = LocalDate.now();

        Group id = groupRepository.getReferenceById(groupId);

        Group group = groupRepository.findById(id.getId())
                .orElseThrow(() -> new IllegalStateException("group has not been founded"));

        student.setId(addStudentRequestDto.getId());
        student.setAcceptDate(addStudentRequestDto.getAcceptDate());
        student.setStudentFIO(addStudentRequestDto.getStudentFIO());

        if (group.getStudents().size() != 0) {
            group.setStudentCount(group.getStudents().size() + 1);
        } else {
            group.setStudentCount(1);
        }

        student.setAcceptDate(date.toString());
        student.setGroup(group);
        studentRepository.save(student);
    }

//    @Override
//    public void editGroup(EditGroupRequestDto editGroupRequestDto, int groupId) {
//
//        Group id = groupRepository.getReferenceById(groupId);
//        Group group = groupRepository.findById(id.getId())
//                .orElseThrow(() -> new IllegalStateException("group has not been founded"));
//
//        group.setId(editGroupRequestDto.getGroupId());
//        group.setStudents(editGroupRequestDto.getStudentList());
//
//        groupRepository.save(group);
//    }


    @Override
    public void deleteGroup(int groupId) {
        groupRepository.deleteById(groupId);
    }

    @Override
    public GroupResponseDto getGroupById(int groupId) {
        Group group = groupRepository.getReferenceById(groupId);
        GroupResponseDto groupResponseDto = new GroupResponseDto();
        groupResponseDto.setId(group.getId());
        groupResponseDto.setGroupNumber(group.getGroupNumber());
        groupResponseDto.setStudentCount(group.getStudents().size());
        return groupResponseDto;
    }


}

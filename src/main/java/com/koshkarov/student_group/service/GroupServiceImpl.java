package com.koshkarov.student_group.service;

import com.koshkarov.student_group.repo.GroupRepository;
import com.koshkarov.student_group.repo.StudentRepository;
import com.koshkarov.student_group.dto.*;
import com.koshkarov.student_group.entity.Group;
import com.koshkarov.student_group.entity.Student;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class GroupServiceImpl implements GroupService{

    private final GroupRepository groupRepository;
    private final StudentRepository studentRepository;

    @Override
    public List<GroupDto> getAllGroup() {
        List<Group> groups = groupRepository.findAll();
        List<GroupDto> collect = groups.stream()
                .map(group -> {
                    GroupDto groupDto = new GroupDto();
                    groupDto.setId(group.getId());
                    groupDto.setGroupNumber(group.getGroupNumber());
                    groupDto.setStudentCount(group.getStudents().size());
                    return groupDto;
                }).collect(Collectors.toList());
        return collect;
    }


    @Override
    public void addNewGroup(AddGroupDto addGroupDto) {
            Group group = new Group();
            group.setGroupNumber(addGroupDto.getGroupNumber());
            groupRepository.save(group);
    }

    @Override
    public void addStudent(AddStudentDto addStudentDto, int groupId) {
        Student student = new Student();
        LocalDate date = LocalDate.now();

        Group id = groupRepository.getReferenceById(groupId);

        Group group = groupRepository.findById(id.getId())
                .orElseThrow(() -> new IllegalStateException("group has not been founded"));

        student.setId(addStudentDto.getId());
        student.setAcceptDate(addStudentDto.getAcceptDate());
        student.setStudentFIO(addStudentDto.getStudentFIO());

        if (group.getStudents().size() != 0) {
            group.setStudentCount(group.getStudents().size() + 1);
        } else {
            group.setStudentCount(1);
        }

        student.setAcceptDate(date.toString());
        student.setGroup(group);
        studentRepository.save(student);
    }


    @Override
    public void editGroup(StudentDto studentDto, int groupId) {

        List<Student> getList = studentRepository.getStudentsByGroup_Id(groupId);

        Student student = getList.stream().findFirst()
                .orElseThrow(() -> new IllegalStateException("student has not been founded"));

        student.setId(studentDto.getId());
        student.setAcceptDate(studentDto.getAcceptDate());
        student.setStudentFIO(studentDto.getStudentFIO());

        studentRepository.save(student);
    }

    @Override
    public void deleteGroup(int groupId) {
        groupRepository.deleteById(groupId);
    }

    @Override
    public GroupDto getGroupById(int groupId) {
        Group group = groupRepository.getReferenceById(groupId);
        GroupDto groupDto = new GroupDto();
        groupDto.setId(group.getId());
        groupDto.setGroupNumber(group.getGroupNumber());
        groupDto.setStudentCount(group.getStudents().size());
        return groupDto;
    }


}

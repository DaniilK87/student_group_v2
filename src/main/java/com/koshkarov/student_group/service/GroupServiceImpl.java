package com.koshkarov.student_group.service;

import com.koshkarov.student_group.exception_handling.GDNException;
import com.koshkarov.student_group.exception_handling.NoSuchGroupException;
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

    //Добавить логгирование
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

        Group group = groupRepository.findById(groupId)
                .orElseThrow(() -> new NoSuchGroupException("группы с таким id нет"));

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
    public void deleteGroup(int groupId) {
        try {
            Group group = groupRepository.findById(groupId)
                    .orElseThrow(() -> new NoSuchGroupException("группы с таким id нет"));
            groupRepository.delete(group);
        } catch (RuntimeException e) {
            throw new GDNException("удаление не возможно, в данной группе есть студенты, " +
                    "удадите студентов из группы и повторите запрос");
        }

    }

    @Override
    public GroupDto getGroupById(int groupId)  {
        Group id = groupRepository.getReferenceById(groupId);
        Group group = groupRepository.findById(id.getId())
                .orElseThrow(() -> new NoSuchGroupException("группы с таким id нет"));

        GroupDto groupDto = new GroupDto();
        groupDto.setId(group.getId());
        groupDto.setGroupNumber(group.getGroupNumber());
        groupDto.setStudentCount(group.getStudents().size());
        return groupDto;
    }
}

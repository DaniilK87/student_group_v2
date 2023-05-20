package com.koshkarov.student_group.service;

import com.koshkarov.student_group.exception_handling.DataDeleteException;
import com.koshkarov.student_group.exception_handling.NoSuchDataException;
import com.koshkarov.student_group.repo.GroupRepository;
import com.koshkarov.student_group.repo.StudentRepository;
import com.koshkarov.student_group.dto.*;
import com.koshkarov.student_group.entity.Group;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class GroupServiceImpl implements GroupService{
    private final GroupRepository groupRepository;
    private final StudentRepository studentRepository;
    @Override
    public List<GroupDto> getAllGroup() {
        return groupRepository.findAll().stream()
                .map(group -> {
                    GroupDto groupDto = new GroupDto();
                    groupDto.setId(group.getId());
                    groupDto.setGroupNumber(group.getGroupNumber());
                    groupDto.setStudentCount(group.getStudents().size());
                    return groupDto;
                }).collect(Collectors.toList());
    }
    @Override
    public void addNewGroup(GroupDto groupDto){
            Group group = new Group();
            group.setGroupNumber(groupDto.getGroupNumber());
            groupRepository.save(group);
    }
    @Override
    public void deleteGroup(int groupId) {
        Group group = groupRepository.findById(groupId)
                .orElseThrow(() -> new NoSuchDataException("группы с таким id нет"));
        if (group.getStudents().size() != 0) throw new DataDeleteException("удаление не возможно, " +
                "в данной группе есть студенты, " +
                    "переведите или удалите студентов из группы и повторите запрос");
        groupRepository.delete(group);
    }
    @Override
    public GroupDto getGroupById(int groupId) {
        Group group = groupRepository.findById(groupId)
                .orElseThrow(() -> new NoSuchDataException("группы с таким id нет"));
        GroupDto groupDto = new GroupDto();
        groupDto.setId(group.getId());
        groupDto.setGroupNumber(group.getGroupNumber());
        groupDto.setStudentCount(group.getStudents().size());
        return groupDto;
    }
}

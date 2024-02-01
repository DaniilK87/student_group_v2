package com.koshkarov.student_group.controller;


import com.koshkarov.student_group.dto.*;
import com.koshkarov.student_group.service.GroupService;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@Data
@RequiredArgsConstructor
public class GroupController {


    private final GroupService groupService;

    @PostMapping("/groups")
    public void addNewGroup(@RequestBody AddGroupDto addGroupDto) {
        groupService.addNewGroup(addGroupDto);
    }

    @GetMapping("/groups")
    public List<GroupDto> getAllGroups() {
        return groupService.getAllGroup();
    }

    @PostMapping("/groups/{groupId}")
    public void addStudent(@RequestBody AddStudentDto addStudentDto,
                           @PathVariable int groupId) {
        groupService.addStudent(addStudentDto, groupId);
    }


    @PutMapping("/groups/{groupId}")
    public void editGroup(@RequestBody StudentDto studentDto, @PathVariable int groupId) {
       groupService.editGroup(studentDto, groupId);
    }

    @DeleteMapping("/groups/{groupId}")
    private void deleteGroup(@PathVariable int groupId) {
        groupService.deleteGroup(groupId);
    }


    @GetMapping("/groups/{groupId}")
    private GroupDto getGroupById(@PathVariable int groupId) {
       return groupService.getGroupById(groupId);
    }

}

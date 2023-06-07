package com.koshkarov.student_group.controller;


import com.koshkarov.student_group.dto.*;
import com.koshkarov.student_group.service.GroupService;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@Data
@AllArgsConstructor
public class GroupController {


    private GroupService groupService;

    @PostMapping("/groups")
    public void addNewGroup(@RequestBody AddGroupRequestDto addGroupRequestDto) {
        groupService.addNewGroup(addGroupRequestDto);
    }

    @GetMapping("/groups")
    public List<GroupResponseDto> getAllGroups() {
        return groupService.getAllGroup();
    }

    @PostMapping("/groups/{groupId}")
    public void addStudent(@RequestBody AddStudentRequestDto addStudentRequestDto,
                           @PathVariable int groupId) {
        groupService.addStudent(addStudentRequestDto, groupId);
    }


    @PutMapping("/groups/{groupId}")
    public void editGroup(@RequestBody StudentRequestDto studentRequestDto, @PathVariable int groupId) {
       groupService.editGroup(studentRequestDto, groupId);
    }

    @DeleteMapping("/groups/{groupId}")
    private void deleteGroup(@PathVariable int groupId) {
        groupService.deleteGroup(groupId);
    }


    @GetMapping("/groups/{groupId}")
    private GroupResponseDto getGroupById(@PathVariable int groupId) {
       return groupService.getGroupById(groupId);
    }

}

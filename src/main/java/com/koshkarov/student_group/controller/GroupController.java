package com.koshkarov.student_group.controller;


import com.koshkarov.student_group.config.SwaggerConfig;
import com.koshkarov.student_group.dto.*;
import com.koshkarov.student_group.service.GroupService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
@Api(tags = {SwaggerConfig.GROUP_TAG})
public class GroupController {


    private final GroupService groupService;

    //добавить новую группу
    @PostMapping("/groups")
    @ApiOperation("добавление новой группы")
    public void addNewGroup(@RequestBody AddGroupDto addGroupDto) {
        groupService.addNewGroup(addGroupDto);
    }

    //получить список групп
    @GetMapping("/groups")
    @ApiOperation("получение списка всех групп")
    public List<GroupDto> getAllGroups() {
        return groupService.getAllGroup();
    }

    //добавить студента в группу
    @PostMapping("/groups/{groupId}")
    @ApiOperation("добавление студента в группу")
    public void addStudent(@RequestBody AddStudentDto addStudentDto,
                           @PathVariable int groupId) {
        groupService.addStudent(addStudentDto, groupId);
    }

    //удалить группу
    @DeleteMapping("/groups/{groupId}")
    @ApiOperation("удаление группы")
    public void deleteGroup(@PathVariable int groupId) {
        groupService.deleteGroup(groupId);
    }

    //получить одну группу
    @GetMapping("/groups/{groupId}")
    @ApiOperation("получить одну группу по id")
    public GroupDto getGroupById(@PathVariable int groupId) {
       return groupService.getGroupById(groupId);
    }

}

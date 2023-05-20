package com.koshkarov.student_group.controller;

import com.koshkarov.student_group.dto.*;
import com.koshkarov.student_group.service.GroupService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
@Tag(name = "Группы", description = "REST API групп")
public class GroupController {

    private final GroupService groupService;

    @PostMapping("/groups")
    @Operation(summary = "Новая группа", description = "Создание новой группы")
    public ResponseEntity<?> newGroup(@RequestBody GroupDto groupDto) {
        groupService.addNewGroup(groupDto);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @GetMapping("/groups")
    @Operation(summary = "Список групп", description = "Получение всех групп в системе")
    public ResponseEntity<List<GroupDto>> allGroups() {
        return new ResponseEntity<>(groupService.getAllGroup(),HttpStatus.OK);
    }
    @DeleteMapping("/groups/{groupId}")
    @Operation(summary = "Удалить группу", description = "Удаление выбранной группы")
    public ResponseEntity<?> deleteGroup(@PathVariable int groupId) {
        groupService.deleteGroup(groupId);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @GetMapping("/groups/{groupId}")
    @Operation(summary = "Одна группа", description = "Получение информации по одной выбранной группе")
    public ResponseEntity<GroupDto> groupById(@PathVariable int groupId) {
        return new ResponseEntity<>(groupService.getGroupById(groupId), HttpStatus.OK);
    }
}

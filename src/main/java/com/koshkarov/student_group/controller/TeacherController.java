package com.koshkarov.student_group.controller;

import com.koshkarov.student_group.dto.GrantsDto;
import com.koshkarov.student_group.dto.RatingDto;
import com.koshkarov.student_group.dto.TeacherDto;
import com.koshkarov.student_group.service.TeacherService;
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
@Tag(name = "Учителя", description = "REST API учителей")
public class TeacherController {
    private final TeacherService teacherService;
    @GetMapping("/teachers")
    @Operation(summary = "Список учителей", description = "Получение списка всех учителей")
    public ResponseEntity<List<TeacherDto>> allTeachers() {
        return new ResponseEntity<>(teacherService.getAllTeacher(), HttpStatus.OK);
    }
    @GetMapping("/teachers/{id}")
    @Operation(summary = "Один учитель", description = "Получение информации по выбраному учителю")
    public ResponseEntity<TeacherDto> teacherById(@PathVariable int id) {
        return new ResponseEntity<>(teacherService.getTeacherById(id), HttpStatus.OK);
    }
    @PostMapping("/teachers")
    @Operation(summary = "Новый учитель", description = "Заведение в систему нового учителя")
    public ResponseEntity<?> newTeacher(@RequestBody TeacherDto teacherDto) {
        teacherService.addNewTeacher(teacherDto);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @DeleteMapping("/teachers/{id}")
    @Operation(summary = "Удалить учителя", description = "Удаление выбранного учителя из системы")
    public ResponseEntity<?> deleteTeachers(@PathVariable int id) {
        teacherService.deleteTeacher(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @GetMapping("/teachers/rating/{teacherId}")
    @Operation(summary = "Ставка учителя", description = "Получение ставки учителя")
    public ResponseEntity<RatingDto> rating(@PathVariable int teacherId) {
        return new ResponseEntity<>(teacherService.getRating(teacherId), HttpStatus.OK);
    }
    @PostMapping("/teachers/salary/{teacherId}")
    private ResponseEntity<?> money(@RequestBody GrantsDto grantsDto, @PathVariable int teacherId) {
        teacherService.getMoney(grantsDto,teacherId);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}

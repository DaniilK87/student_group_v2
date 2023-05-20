package com.koshkarov.student_group.controller;

import com.koshkarov.student_group.dto.*;
import com.koshkarov.student_group.service.StudentService;
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
@Tag(name = "Студенты", description = "REST API студентов")
public class StudentController {
    private final StudentService studentService;
    @DeleteMapping("/students/{studentId}")
    @Operation(summary = "Удаление студента", description = "Удаление выбранного студента")
    public ResponseEntity<?> deleteStudent(@PathVariable int studentId){
        studentService.deleteStudent(studentId);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @GetMapping("/students")
    @Operation(summary = "Список студентов", description = "Получение списка всех студентов")
    private ResponseEntity<List<StudentDto>> allStudent() {
        return new ResponseEntity<>(studentService.getAllStudent(), HttpStatus.OK);
    }
    @PostMapping("/students/group/{groupId}")
    @Operation(summary = "Новый студент", description = "Создание и добавление нового студента в выбранную группу")
    public ResponseEntity<?> newStudent(@RequestBody StudentDto studentDto,
                                        @PathVariable int groupId) {
        studentService.addStudent(studentDto, groupId);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @GetMapping("/students/{name}")
    @Operation(summary = "Поиск студентов по имени", description = "Получение списка студентов с одинаковым именем")
    public ResponseEntity<List<StudentDto>> studentByName(@PathVariable String name){
        return new ResponseEntity<>(studentService.getStudentByName(name), HttpStatus.OK);
    }
    @GetMapping("/all-students/group/{groupId}")
    @Operation(summary = "Список учащихся группы", description = "Получение списка всех учащихся в выбранной группе")
    public ResponseEntity<List<StudentDto>> allStudentsByGroup(@PathVariable int groupId) {
        return new ResponseEntity<>(studentService.getAllStudentsByGroup(groupId), HttpStatus.OK);
    }
    @GetMapping("/students/rating/{studentId}")
    @Operation(summary = "Успеваемость студента", description = "Получение балла успеваемости студента")
    public ResponseEntity<RatingDto> rating(@PathVariable int studentId) {
        return new ResponseEntity<>(studentService.getRating(studentId), HttpStatus.OK);
    }
    @PostMapping("/students/grants/{studentId}")
    private ResponseEntity<?> money(@RequestBody GrantsDto grantsDto, @PathVariable int studentId) {
        studentService.getMoney(grantsDto,studentId);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @PutMapping("/students/{studentId}")
    @Operation(summary = "Редактирование студента", description = "Изменение данных по выбранному студенту")
    public ResponseEntity<?> update(@RequestBody StudentDto studentDto, @PathVariable int studentId) {
        studentService.editStudent(studentDto,studentId);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @PutMapping("/groups/{groupId}/students/{studentId}")
    @Operation(summary = "Перевод студента", description = "Перевод студента из одной группы в другую")
    public ResponseEntity<?> transferStudent(@PathVariable int groupId,
                                @PathVariable int studentId) {
        studentService.transferStudent(groupId, studentId);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}

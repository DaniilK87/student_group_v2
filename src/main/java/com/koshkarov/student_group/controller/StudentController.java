package com.koshkarov.student_group.controller;

import com.koshkarov.student_group.config.SwaggerConfig;
import com.koshkarov.student_group.dto.*;
import com.koshkarov.student_group.service.StudentService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
@Api(tags = {SwaggerConfig.STUDENT_TAG})
public class StudentController {

    private final StudentService studentService;

    // удаляем студента
    @DeleteMapping("/groups/students/{studentId}")
    @ApiOperation("удаление студента")
    public String deleteStudent(@PathVariable int studentId){
        studentService.deleteStudent(studentId);
        return "Student with ID = " + studentId + "delete";
    }

    // получаем список всех студернтов
    @GetMapping("/groups/students")
    @ApiOperation("получение списка всех студентов")
    private List<StudentDto> getAllStudent() {
        return studentService.getAllStudent();
    }

    // получаем студента по имени
    @GetMapping("/groups/students/{name}")
    @ApiOperation("получение студента по имени")
    public List<StudentDto> getStudentByName(@PathVariable String name){
        return studentService.getStudentByName(name);
    }

    // получаем всех студентов в группе
    @GetMapping("/groups/allStudents/{groupId}")
    @ApiOperation("получение всех студентов в группе")
    public List<StudentDto> getAllStudentsByGroup(@PathVariable int groupId) {
        return studentService.getAllStudentsByGroup(groupId);
    }

    // получаем бал успеваемости студента
    @GetMapping("/groups/students/rating/{studentId}")
    @ApiOperation("получение бала успеваемости студента")
    public RatingDTO getRating(@PathVariable int studentId) {
        return studentService.getRating(studentId);
    }

    // начисляем стипендию студенту
    @PostMapping("/groups/students/grants/{studentId}")
    @ApiOperation("начисление стипендии студенту")
    public void getMoney(@RequestBody GrantsDto grantsDto, @PathVariable int studentId) {
        studentService.getMoney(grantsDto,studentId);
    }

    // редкатрируем данные студента
    @PutMapping("/groups/students/{studentId}")
    @ApiOperation("редактирование данных студента")
    public void editStudent(@RequestBody EditStudentDto editStudentDto, @PathVariable int studentId) {
        studentService.editStudent(editStudentDto,studentId);
    }

}

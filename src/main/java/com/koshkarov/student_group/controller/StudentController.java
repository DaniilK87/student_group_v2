package com.koshkarov.student_group.controller;

import com.koshkarov.student_group.dto.GrantsDto;
import com.koshkarov.student_group.dto.RatingDTO;
import com.koshkarov.student_group.dto.StudentDto;
import com.koshkarov.student_group.service.StudentService;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
@Data
public class StudentController {

    private final StudentService studentService;

    @DeleteMapping("/groups/students/{id}")
    public String deleteStudent(@PathVariable int id){
        studentService.deleteStudent(id);
        return "Student with ID = " + id + "delete";
    }

    @GetMapping("/groups/students")
    private List<StudentDto> getAllStudent() {
        return studentService.getAllStudent();
    }

    @GetMapping("/groups/students/{name}")
    public List<StudentDto> getStudentByName(@PathVariable String name){
        return studentService.getStudentByName(name);
    }

    @GetMapping("/groups/allStudents/{groupId}")
    public List<StudentDto> getAllStudentsByGroup(@PathVariable int groupId) {
        return studentService.getAllStudentsByGroup(groupId);
    }

    @GetMapping("/groups/student/rating/{studentId}")
    public RatingDTO getRating(@PathVariable int studentId) {
        return studentService.getRating(studentId);
    }

    @PostMapping("/groups/student/grants/{studentId}")
    public void getMoney(@RequestBody GrantsDto grantsDto, @PathVariable int studentId) {
        studentService.getMoney(grantsDto,studentId);
    }

}

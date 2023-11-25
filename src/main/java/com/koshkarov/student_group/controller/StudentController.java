package com.koshkarov.student_group.controller;

import com.koshkarov.student_group.dto.GrantsResponseDto;
import com.koshkarov.student_group.dto.RatingResponseDTO;
import com.koshkarov.student_group.dto.StudentResponseDto;
import com.koshkarov.student_group.service.StudentService;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@AllArgsConstructor
@Data
public class StudentController {

    private StudentService studentService;

    @DeleteMapping("/groups/students/{id}")
    public String deleteStudent(@PathVariable int id){
        studentService.deleteStudent(id);
        return "Student with ID = " + id + "delete";
    }

    @GetMapping("/groups/students")
    private List<StudentResponseDto> getAllStudent() {
        return studentService.getAllStudent();
    }

    @GetMapping("/groups/students/{name}")
    public List<StudentResponseDto> getStudentByName(@PathVariable String name){
        return studentService.getStudentByName(name);
    }

    @GetMapping("/groups/allStudents/{groupId}")
    public List<StudentResponseDto> getAllStudentsByGroup(@PathVariable int groupId) {
        return studentService.getAllStudentsByGroup(groupId);
    }

    @GetMapping("/groups/student/rating/{studentId}")
    public RatingResponseDTO getRating(@PathVariable int studentId) {
        return studentService.getRating(studentId);
    }

    @PostMapping("/groups/student/grants/{studentId}")
    public void getMoney(@RequestBody GrantsResponseDto grantsResponseDto, @PathVariable int studentId) {
        studentService.getMoney(grantsResponseDto,studentId);
    }

}

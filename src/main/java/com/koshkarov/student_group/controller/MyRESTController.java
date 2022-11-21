package com.koshkarov.student_group.controller;

import com.koshkarov.student_group.entity.Group;
import com.koshkarov.student_group.entity.Student;
import com.koshkarov.student_group.service.GroupService;
import com.koshkarov.student_group.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api")
public class MyRESTController {

    @Autowired
    private GroupService groupService;

    @Autowired
    private StudentService studentService;

    @GetMapping("/groups")
    public List<Group> showAllGroup() {
        List<Group> allGroup = groupService.getAllGroup();
        return allGroup;
    }

    @GetMapping("/students")
    public List<Student> showAllStudent() {
        List<Student> allStudent = studentService.getAllStudent();
        return allStudent;
    }

    @PostMapping("/students")
    public Student addNewEmployee(@RequestBody Student student) {
        Date date = new Date();
        student.setAcceptDate(String.valueOf(date));
        studentService.saveStudent(student);
        return student;
    }

    @DeleteMapping("/students/{id}")
    public String deleteStudent(@PathVariable int id) {
        studentService.deleteStudent(id);
        return "Student with ID = " + id + "delete";
    }
}

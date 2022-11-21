package com.koshkarov.student_group.service;

import com.koshkarov.student_group.entity.Student;

import java.util.List;

public interface StudentService {

    public List<Student> getAllStudent();

    public void saveStudent(Student student);

    public void deleteStudent(int id);
}

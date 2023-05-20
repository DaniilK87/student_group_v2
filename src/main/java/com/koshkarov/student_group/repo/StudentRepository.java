package com.koshkarov.student_group.repo;

import com.koshkarov.student_group.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Integer> {
    List<Student> findStudentByStudentFIOEquals(String name);
    List<Student> getStudentsByGroup_Id(Integer groupId);








}

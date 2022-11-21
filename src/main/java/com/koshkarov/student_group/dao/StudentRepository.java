package com.koshkarov.student_group.dao;

import com.koshkarov.student_group.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Integer> {

}

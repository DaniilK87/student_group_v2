package com.koshkarov.student_group.repo;

import com.koshkarov.student_group.entity.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeacherRepository extends JpaRepository<Teacher, Integer> {
}

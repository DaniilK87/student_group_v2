package com.koshkarov.student_group.dao;

import com.koshkarov.student_group.entity.University;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UniversityRepository extends JpaRepository<University, Integer> {
}

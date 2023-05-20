package com.koshkarov.student_group.dao;

import com.koshkarov.student_group.entity.Group;
import com.koshkarov.student_group.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GroupRepository extends JpaRepository<Group, Integer> {

}

package com.koshkarov.student_group.repo;

import com.koshkarov.student_group.entity.Group;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GroupRepository extends JpaRepository<Group, Integer> {

}

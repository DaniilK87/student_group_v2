package com.koshkarov.student_group.repo;

import com.koshkarov.student_group.entity.Lesson;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LessonRepository extends JpaRepository<Lesson, Integer> {

    List<Lesson> getLessonsByGroupNumber_Id(Integer groupId);
}

package com.koshkarov.student_group.service;

import com.koshkarov.student_group.dto.LessonDto;

import java.util.List;

public interface LessonService {

    void addLesson(LessonDto lessonDto, int groupId, int lessonId);

    List<LessonDto> getAllLesson();

    List<LessonDto> getAllLessonsByGroup(int groupId);
}

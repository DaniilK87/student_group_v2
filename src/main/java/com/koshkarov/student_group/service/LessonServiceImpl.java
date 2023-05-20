package com.koshkarov.student_group.service;

import com.koshkarov.student_group.entity.Group;
import com.koshkarov.student_group.entity.Lesson;
import com.koshkarov.student_group.entity.Teacher;
import com.koshkarov.student_group.exception_handling.NoSuchDataException;
import com.koshkarov.student_group.repo.GroupRepository;
import com.koshkarov.student_group.repo.LessonRepository;
import com.koshkarov.student_group.repo.TeacherRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


import com.koshkarov.student_group.dto.LessonDto;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class LessonServiceImpl implements LessonService{

    private final LessonRepository lessonRepository;
    private final GroupRepository groupRepository;
    private final TeacherRepository teacherRepository;

    @Override
    public void addLesson(LessonDto lessonDto, int groupId, int teacherId) {
        Group group = groupRepository.findById(groupId).orElseThrow(
                () -> new NoSuchDataException("группы с таким id нет"));
        Teacher teacher = teacherRepository.findById(teacherId).orElseThrow(
                () -> new NoSuchDataException("преподователя с таким id нет"));
        Lesson lesson = new Lesson();
        LocalDate date = LocalDate.now();
        lesson.setDate(date.toString());
        if (!lessonDto.getName().contains(teacher.getProfile()))
            throw new NullPointerException("Нельзя назначить данного преподователя на этот урок из-за отсутствии " +
                    "квалификации");
        lesson.setName(lessonDto.getName());
        lesson.setGroupNumber(group);
        lesson.setTeacher(teacher);
        lessonRepository.save(lesson);
    }

    @Override
    public List<LessonDto> getAllLesson() {
        return lessonRepository.findAll().stream().map(
                lesson -> {
                    LessonDto lessonDto = new LessonDto();
                    lessonDto.setDate(lesson.getDate());
                    lessonDto.setName(lesson.getName());
                    lessonDto.setGroupNumber(lesson.getGroupNumber().getGroupNumber());
                    lessonDto.setTeacherName(lesson.getTeacher().getName());
                    return lessonDto;
                }).collect(Collectors.toList());
    }

    @Override
    public List<LessonDto> getAllLessonsByGroup(int groupId) {
        Group group = groupRepository.findById(groupId).orElseThrow(
                () -> new NoSuchDataException("занятий не найдено, группы с таким id нет"));
        return lessonRepository.getLessonsByGroupNumber_Id(group.getId()).stream().map(
                lesson -> {
                    LessonDto lessonDto = new LessonDto();
                    lessonDto.setDate(lesson.getDate());
                    lessonDto.setName(lesson.getName());
                    lessonDto.setGroupNumber(lesson.getGroupNumber().getGroupNumber());
                    lessonDto.setTeacherName(lesson.getTeacher().getName());
                    return lessonDto;
                }).collect(Collectors.toList());
    }
}

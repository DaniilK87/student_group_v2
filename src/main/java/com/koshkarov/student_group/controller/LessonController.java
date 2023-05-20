package com.koshkarov.student_group.controller;

import com.koshkarov.student_group.dto.LessonDto;
import com.koshkarov.student_group.service.LessonService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
@Tag(name = "Уроки", description = "REST API уроков")
public class LessonController {
    private final LessonService lessonService;
    @PostMapping("/lessons/{groupId}/{teacherId}")
    @Operation(summary = "Новый урок", description = "Создание нового урока в расписание")
    public ResponseEntity<?> newLesson(@RequestBody LessonDto lessonDto,
                                    @PathVariable int groupId, @PathVariable int teacherId) {
        lessonService.addLesson(lessonDto,groupId,teacherId);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @GetMapping("/lessons")
    @Operation(summary = "Список уроков", description = "Показать расписание всех уроков")
    public ResponseEntity<List<LessonDto>> allLessons() {
        return new ResponseEntity<>(lessonService.getAllLesson(), HttpStatus.OK);
    }
    @GetMapping("/lessons/{groupId}")
    @Operation(summary = "Список уроков группы", description = "Показать расписание уроков выбранной группы")
    public ResponseEntity<List<LessonDto>> allLessonsByGroup(@PathVariable int groupId) {
        return new ResponseEntity<>(lessonService.getAllLessonsByGroup(groupId), HttpStatus.OK);
    }
}

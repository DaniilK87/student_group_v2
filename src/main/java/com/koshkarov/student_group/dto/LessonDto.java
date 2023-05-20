package com.koshkarov.student_group.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "Описание урока")
public class LessonDto {

    @Schema(name = "date", description = "Дата урока", example = "2001-01-01")
    private String date;

    @Schema(name = "name", description = "Название урока", example = "Lesson#1")
    private String name;

    @Schema(name = "groupNumber", description = "Номер группы", example = "К101")
    private String groupNumber;

    @Schema(name = "teacherName", description = "ФИО учителя", example = "Teacher#1")
    private String teacherName;
}

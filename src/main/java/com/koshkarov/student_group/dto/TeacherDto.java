package com.koshkarov.student_group.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "Описание учителя")
public class TeacherDto {

    @Schema(name = "name", description = "ФИО учителя", example = "Teacher#1")
    private String name;

    @Schema(name = "profile", description = "Специализация", example = "Преподаватель Lesson#1, Lesson#2")
    private String profile;

    @Schema(name = "rating", description = "Ставка учителя", example = "2")
    private Integer rating;
}

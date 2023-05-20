package com.koshkarov.student_group.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Schema(description = "Описание студента")
public class StudentDto {

    @Schema(name = "id", description = "Идентификатор студента", example = "1")
    private Integer id;

    @Schema(name = "studentFIO", description = "ФИО студента", example = "Student#1")
    private String studentFIO;

    @Schema(name = "acceptDate", description = "Дата зачисления", example = "2001-01-01")
    private String acceptDate;

    @Schema(name = "rating", description = "Бал успеваемости", example = "4")
    private Integer rating;
}

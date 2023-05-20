package com.koshkarov.student_group.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "Описание группы")
public class GroupDto {

    @Schema(name = "id", description = "Идентификатор группы", example = "1")
    private Integer id;

    @Schema(name = "groupNumber", description = "Номер группы", example = "К101")
    private String groupNumber;

    @Schema(name = "studentCount", description = "Количество студентов в группе", example = "10")
    private int studentCount;
}

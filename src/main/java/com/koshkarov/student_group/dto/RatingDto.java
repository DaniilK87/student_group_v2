package com.koshkarov.student_group.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "Рейтинг")
public class RatingDto {

    @Schema(name = "id", description = "Идентификатор рейтинга", example = "1")
    private Integer id;

    @Schema(name = "rating", description = "Рейтинг", example = "4")
    private Integer rating;
}

package com.koshkarov.student_group.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StudentResponseDto {

    private Integer id;
    private String acceptDate;
    private String studentPS;
}

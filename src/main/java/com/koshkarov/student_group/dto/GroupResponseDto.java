package com.koshkarov.student_group.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GroupResponseDto {

    private Integer id;
    private String groupNumber;
    private int studentCount;
}

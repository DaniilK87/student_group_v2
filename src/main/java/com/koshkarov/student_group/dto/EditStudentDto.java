package com.koshkarov.student_group.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EditStudentDto {

    private String studentFIO;
    private String acceptDate;
    private Integer rating;
}
